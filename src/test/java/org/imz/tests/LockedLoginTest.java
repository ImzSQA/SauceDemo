package org.imz.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imz.base.BaseTest;
import org.imz.pages.LoginPage;
import org.imz.utils.Cons;
import org.imz.utils.DriverFactory;
import org.imz.utils.DriverManager;
import org.imz.utils.JsonDatareader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LockedLoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LockedLoginTest.class);
    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeMethod
    public void navigateToBaseUrl() {
        driver = DriverManager.getDriver();
        //   driver.get(Cons.BASE_WEB);
        loginPage = new LoginPage(driver);
        logger.info("Initialized pages and navigated to base URL on browser: ");
    }

/*    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }*/

    @DataProvider(name = Cons.Node_Locked)
    public Object[][] getLockedLoginData() {
        return JsonDatareader.getValidLoginData(Cons.FileLoginPath, Cons.Node_Locked);
    }

    @Test(dataProvider = Cons.Node_Locked, priority = 3)
    public void testLockedLogin(String username, String password) {

        loginPage.login(username, password);
        logger.info("Tried locked login with user: {}", username);

        Assert.assertTrue(loginPage.isErrorButtonDisplayed(), "Expected locked login error for: " + username);
    }
}
