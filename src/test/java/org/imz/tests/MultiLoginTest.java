package org.imz.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imz.base.BaseTest;
import org.imz.pages.LoginPage;
import org.imz.utils.Cons;
import org.imz.utils.JsonDatareader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static org.imz.utils.Cons.Node_Multi;

public class MultiLoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(MultiLoginTest.class);
    private LoginPage loginPage;
    private LogoutTest logoutTest;

    @BeforeMethod
    public void navigateToBaseUrl() {
        driver.get(Cons.BASE_WEB);
        logoutTest = new LogoutTest();
        loginPage = new LoginPage(driver);
        logger.info("Initialized page and navigated to base URL + " + Cons.BASE_WEB);

    }

    @DataProvider(name = Cons.Node_Multi)
    public Object[][] getValidAccounts() {
        return JsonDatareader.getValidLoginData(Cons.FileLoginPath, Cons.Node_Multi);
    }


    @Test(dataProvider = Cons.Node_Multi, priority = 1)
    public void testValidMultipleLogin(String username, String password) {
        if (driver != null) {
            Assert.assertNotNull(driver, "Driver is null before login");
            loginPage.login(username, password);
            Assert.assertTrue(isInventoryContained(), "Login failed for: " + username);
            logger.info("Attempting login with user: {}", username);

        } else
            System.out.println("Failed at testValidLogin @Test 1");

    }


    @Test
    public boolean isInventoryContained() {
        return driver.getCurrentUrl().contains(Cons.isInventory);
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
