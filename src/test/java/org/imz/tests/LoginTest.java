package org.imz.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imz.base.BaseTest;
import org.imz.pages.LoginPage;
import org.imz.pages.ProductPage;
import org.imz.utils.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    private LoginPage loginPage;
    private ProductPage productPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Get the WebDriver from DriverManager, as it's already initialized in BaseTest
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        logger.info("Initialized pages and navigated to base URL.");
    }

    @AfterMethod
    public void tearDown() {
        try {
            DriverManager.quitDriver();
        } catch (Exception e) {
            logger.error("Logout failed or encountered an error.", e);
        }
    }

    @DataProvider(name = Cons.Node_Login)
    public Object[][] getLoginData() {
        return JsonDatareader.getValidLoginData(Cons.FileLoginPath, Cons.Node_Login);
    }

    @Test(dataProvider = Cons.Node_Login, priority = 1)
    public void testValidLogin(String username, String password) {
        productPage = loginPage.login(username, password);
        logger.info("Login successful! {}", username);
        Assert.assertTrue(productPage.isProductsPageVisible());
        Assert.assertEquals(productPage.getPageTitle(), "Products");
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
    }
}
