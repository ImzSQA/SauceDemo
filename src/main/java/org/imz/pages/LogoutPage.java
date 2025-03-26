package org.imz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.imz.base.BaseTest;

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

        bmBtn.click();

        logoutButton.click();


    }

}
