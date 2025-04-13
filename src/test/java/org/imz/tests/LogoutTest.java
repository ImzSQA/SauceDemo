package org.imz.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imz.base.BaseTest;
import org.imz.pages.LogoutPage;
import org.imz.utils.Cons;
import org.imz.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LogoutTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LogoutTest.class);
    private LogoutPage logoutPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverManager.getDriver();

        logoutPage = new LogoutPage(driver);
    }

    public void ensureLoggedOut() {
        try {

            logoutPage.logout();
            logger.info("Logout successful");
            Assert.assertEquals(driver.getCurrentUrl(), Cons.BASE_WEB,
                    "Failed to return to login page after logout");

        } catch (Exception e) {
            logger.error("Logout encountered exception, navigating directly to login page", e);
            driver.get(Cons.BASE_WEB);
        }
    }

/*    @AfterMethod()
    public void tearDown() {
        DriverManager.quitDriver();
    }*/
}
