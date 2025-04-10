package org.imz.tests;


import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.imz.base.BaseTest;
import org.imz.pages.LoginPage;

import org.imz.utils.*;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.Assert;


import java.nio.file.Paths;

public class LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    private LoginPage loginPage;
    String isInventory ="inventory";


    @BeforeSuite
    public void navigateToBaseUrl() {
        driver.get(Cons.BASE_WEB);
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
            if (!driver.getCurrentUrl().equals(Cons.BASE_WEB)) {
                driver.get(Cons.BASE_WEB);
            }
            loginPage.login(username, password);
            Assert.assertTrue(isInventoryContained(), "Login failed for: " + username);
            logger.info("Login successful!");
        } else
            System.out.println("Failed at testValidLogin @Test 1");

    }


    @Test
    public boolean isInventoryContained() {
        return driver.getCurrentUrl().contains(isInventory);
    }

    @Test(dataProvider = "testLockedLoginData", priority = 3)
    public void testLockedLogin(String username, String password) {
        if (driver != null) {
            if (!driver.getCurrentUrl().equals(Cons.BASE_WEB)) {
                driver.get(Cons.BASE_WEB);
            }
            loginPage.login(username, password);
            Assert.assertTrue(loginPage.isErrorButtonDisplayed(), "Login locked for: " + username);

        } else
            System.out.println("Failed at testLockedLogin @Test 3");

    }





}
