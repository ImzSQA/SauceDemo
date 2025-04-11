package org.imz.tests;


import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.imz.base.BaseTest;
import org.imz.pages.LoginPage;


import org.imz.utils.*;

import org.testng.annotations.*;
import org.testng.Assert;


import java.nio.file.Paths;
import java.util.concurrent.CompletionService;

public class LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    private LoginPage loginPage;

    @BeforeMethod
    public void navigateToBaseUrl() {
        driver.get(Cons.BASE_WEB);
        loginPage = new LoginPage(driver);

        logger.info("Initialized pages and navigated to base URL");

    }


    @DataProvider(name = Cons.Node_Login)
    public Object[][] getLoginData() {
        return JsonDatareader.getValidLoginData(Cons.FileLoginPath, Cons.Node_Login);
    }

    @Test(dataProvider = Cons.Node_Login, priority = 3)
    public void testLogin(String username, String password) {
        if (driver != null) {
            loginPage.login(username, password);
            logger.info("Login successful! " + username);

        } else
            System.out.println("Failed at Login @Test 3");

    }

}
