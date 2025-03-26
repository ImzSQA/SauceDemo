package org.imz.tests;


import org.imz.base.BaseTest;
import org.imz.pages.LoginPage;
import org.imz.utils.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;


import java.nio.file.Paths;

public class LoginTest extends BaseTest {


    @DataProvider(name = "validAccounts")
    public Object[][] validAccounts() {
        String filePath = Paths.get("src", "test", "resources", "secrets.json").toString();
        return JsonDatareader.getLoginData(filePath);
    }


    @Test(dataProvider = "validAccounts",priority = 1)
    public void testValidMultipleLogin(String username, String password) {
        if (driver != null) {
            driver.get(Cons.BASE_WEB);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password);
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed for: " + username);

        } else
            System.out.println("Failed at testValidLogin @Test 1");

    }




}
