package org.imz.tests;

import org.imz.pages.LogoutPage;
import org.imz.utils.ElementFluentWaitUtility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.imz.utils.*;
import org.imz.base.BaseTest;
public class LogoutTest extends BaseTest{

    @Test(priority = 2)
    public void testLogout() {

        LogoutPage LogoutPage = new LogoutPage(driver);
        LogoutPage.logout();
       /* ElementFluentWaitUtility.getElementByFluentWait(By.className("bm-burger-button"), driver).click();
        ElementFluentWaitUtility.getElementByFluentWait(By.id("logout_sidebar_link"), driver).click();
*/
        // Assert logout successful
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"), "Logout failed!");
    }
}
