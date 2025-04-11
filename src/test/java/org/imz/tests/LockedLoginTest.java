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

public class LockedLoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LockedLoginTest.class);
    private LoginPage loginPage;

    @BeforeMethod
    public void navigateToBaseUrl() {
        driver.get(Cons.BASE_WEB);
        loginPage = new LoginPage(driver);

        logger.info("Initialized pages and navigated to base URL");

    }


    @DataProvider(name = Cons.Node_Locked)
    public Object[][] getLockedLoginData() {
        return JsonDatareader.getValidLoginData(Cons.FileLoginPath, Cons.Node_Locked);
    }


    @Test(dataProvider = Cons.Node_Locked, priority = 2)
    public void testLockedLogin(String username, String password) {
        if (driver != null) {
            loginPage.login(username, password);
            logger.info("Locked Login successful!");
            Assert.assertTrue(loginPage.isErrorButtonDisplayed(), "Login locked for: " + username);


        } else
            System.out.println("Failed at testLockedLogin @Test 3");

    }


}
