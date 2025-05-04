package org.imz.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imz.base.BaseTest;
import org.imz.pages.LoginPage;
import org.imz.pages.LogoutPage;
import org.imz.utils.Cons;
import org.imz.utils.DriverManager;
import org.imz.utils.JsonDatareader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MultiLoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(MultiLoginTest.class);
    private LoginPage loginPage;
    private LogoutPage logoutPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        logger.info("Initialized page and navigated to base URL: " + Cons.BASE_WEB);
    }

    @DataProvider(name = Cons.Node_Multi)
    public Object[][] getValidAccounts() {
        return JsonDatareader.getValidLoginData(Cons.FileLoginPath, Cons.Node_Multi);
    }

    @Test(dataProvider = Cons.Node_Multi, priority = 2)
    public void testValidMultipleLogin(String username, String password) {
        loginPage.login(username, password);
        Assert.assertTrue(isInventoryContained(driver), "Login failed for: " + username);
        logger.info("Login successful for user: {}", username);
        logger.info("Logout done after login test for user: {}", username);

    }

    @AfterMethod
    public void tearDown() {
        try {
            logger.info("Attempting to logout after test...");
            logoutPage.logout(); // Directly use logoutPage
            logger.info("Logout successful.");
            DriverManager.quitDriver();
        } catch (Exception e) {
            logger.error("Logout failed or encountered an error.", e);
        }
    }

    private boolean isInventoryContained(WebDriver driver) {
        return driver.getCurrentUrl().contains(Cons.isInventory);
    }
}
