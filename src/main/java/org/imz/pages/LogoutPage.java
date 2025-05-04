package org.imz.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imz.utils.ElementFluentWaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    private static final Logger logger = LogManager.getLogger(LogoutPage.class);
    WebDriver driver;

    public LogoutPage(WebDriver driver) {

        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "bm-burger-button")
    WebElement bmBtn;


    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;


    public void logout() {
        try {
            // Wait for and click the hamburger menu (bmBtn)
            WebElement hamburgerButton = ElementFluentWaitUtility.getElementByFluentWait(bmBtn, 10, 500, driver);
            hamburgerButton.click();

            // Wait for and click the logout button (logoutButton)
            WebElement logoutButtonElement = ElementFluentWaitUtility.getElementByFluentWait(logoutButton, 10, 500, driver);
            logoutButtonElement.click();

            logger.info("Logout action performed successfully.");
        } catch (Exception e) {
            logger.error("Error during logout process: ", e);
        }
    }


}