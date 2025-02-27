package org.imz.tests;


import org.imz.base.BaseTestSingleton;
import org.imz.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTestSingleton {


    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }


}
