package org.imz.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imz.base.BaseTest;
import org.imz.pages.LogoutPage;

import org.imz.utils.Cons;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LogoutTest.class);
    private final LogoutPage logoutPage = new LogoutPage(driver);

    @Test( priority = 3)
    public void ensureLoggedOut() {
        if (driver != null) {
            try {
                if (!driver.getCurrentUrl().equals(Cons.BASE_WEB)) {
                    logoutPage.logout();
                    logger.info("Logout successful");
                    Assert.assertEquals(driver.getCurrentUrl(), Cons.BASE_WEB,
                            "Failed to return to login page after logout");
                }

            } catch (Exception e) {
                logger.error("Logout encountered exception, navigating directly to login page", e);
                driver.get(Cons.BASE_WEB);
            }
        }
    }
}
