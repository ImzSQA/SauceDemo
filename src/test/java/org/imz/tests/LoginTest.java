package org.imz.tests;


import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.imz.base.BaseTest;
import org.imz.pages.LoginPage;


import org.imz.utils.*;

import org.testng.annotations.*;
import org.testng.Assert;


import java.nio.file.Paths;

public class LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    private LoginPage loginPage;
    String isInventory = "inventory";
    private LogoutTest logoutTest;


    @BeforeMethod
    public void navigateToBaseUrl() {
        driver.get(Cons.BASE_WEB);
        logoutTest = new LogoutTest();
        loginPage = new LoginPage(driver);

        logger.info("Initialized pages and navigated to base URL");

    }

    @DataProvider(name = "validAccounts")
    public Object[][] validAccounts() {
        String filePath = Paths.get("src", "test", "resources", "secrets.json").toString();
        return JsonDatareader.getValidLoginData(filePath);
    }

    @DataProvider(name = "testLockedLoginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce"}
        };
    }


    @Test(dataProvider = "validAccounts", priority = 1)
    public void testValidMultipleLogin(String username, String password) {
        if (driver != null) {
            Assert.assertNotNull(driver, "Driver is null before login");
            loginPage.login(username, password);
            Assert.assertTrue(isInventoryContained(), "Login failed for: " + username);
            logger.info("Login successful!");
            logger.info("Attempting login with user: {}", username);
            logger.info("Login attempted.");

        } else
            System.out.println("Failed at testValidLogin @Test 1");

    }


    @Test
    public boolean isInventoryContained() {
        return driver.getCurrentUrl().contains(isInventory);
    }

    @Test(dataProvider = "testLockedLoginData", priority = 2)
    public void testLockedLogin(String username, String password) {
        if (driver != null) {
            loginPage.login(username, password);
            logger.info("Locked Login successful!");
            Assert.assertTrue(loginPage.isErrorButtonDisplayed(), "Login locked for: " + username);


        } else
            System.out.println("Failed at testLockedLogin @Test 3");

    }

    @AfterMethod
    public void logoutAfterEachTest() {
        if (driver != null) {
            try {

                logger.info("Attempting to logout after test...");
                logoutTest.ensureLoggedOut();
                logger.info("Logout successful.");
            } catch (Exception e) {
                logger.error("Logout failed or encountered an error.", e);
            }
        }
    }
}
