package org.imz.tests;

import net.bytebuddy.build.Plugin;
import org.imz.base.BaseTest;
import org.imz.pages.LoginPage;
import org.imz.utils.LoginModel;
import org.imz.utils.SecretsUtil;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {



/*
    @Test
    public void testValidLogin() {
        if (driver != null) {
            driver.get(String.valueOf(SecretsUtil.getSecret("url")));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(SecretsUtil.getSecret("username"), SecretsUtil.getSecret("password"));
            assertTrue(driver.getCurrentUrl().contains("inventory"));
        } else System.out.println("Failed at testValidLogin @Test 1");
    }

*/


    @Test
    public void testInValidLogin() {
        if (driver != null) {
            driver.get("https://www.saucedemo.com/");
            LoginPage loginPage = new LoginPage(driver);
            authLogin(loginPage);

        } else {
            System.out.println("Failed at testValidLogin @Test 2");

        }
    }

    private void authLogin(LoginPage loginPage) {
        List<LoginModel> loginList = SecretsUtil.loadSecrets();
        for (int i = 0; i <= loginList.size(); i++) {

            loginPage.login(loginList.get(i).getUsername(), loginList.get(i).getPassword());

            boolean isvalid = driver.getCurrentUrl().contains("inventory");
            if (isvalid) testLogout();
            else System.out.println(isvalid);
        }
    }

    @Test
    public void testLogout() {
        driver.findElement(By.className("bm-burger-button")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

}
