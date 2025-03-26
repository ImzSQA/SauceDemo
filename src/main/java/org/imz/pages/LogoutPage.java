package org.imz.pages;

import org.imz.utils.ElementFluentWaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "bm-burger-button")
    WebElement bmBtn;


    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;



    public void logout() {
        ElementFluentWaitUtility.getElementByFluentWait(bmBtn, 10, 500, driver).click();
        ElementFluentWaitUtility.getElementByFluentWait(logoutButton, 10, 500, driver).click();
    }

}
