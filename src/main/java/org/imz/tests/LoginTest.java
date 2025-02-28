package org.imz.tests;


import org.imz.base.BaseTest;
import org.imz.pages.LoginPage;
import org.imz.utils.SecretsUtil;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {


    @Test
    public void testValidLogin() {

        if (driver != null) {
            driver.get(String.valueOf(SecretsUtil.getSecret("url")));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(SecretsUtil.getSecret("username"), SecretsUtil.getSecret("password"));
            assertTrue(driver.getCurrentUrl().contains("inventory"));
        }
        else System.out.println("Failed at testValidLogin @Test 1");
    }


}
