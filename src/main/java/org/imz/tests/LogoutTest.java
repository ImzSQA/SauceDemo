package org.imz.tests;

import org.imz.pages.LogoutPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.imz.base.BaseTest;

public class LogoutTest extends BaseTest {

    @Test(priority = 2)
    public void testLogout() {

        LogoutPage LogoutPage = new LogoutPage(driver);
        LogoutPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"), "Logout failed!");
    }
}
