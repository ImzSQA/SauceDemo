package org.imz.pages;


import org.imz.utils.ElementFluentWaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;
    private ProductPage pPage;

    public LoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement userName;


    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;


    @FindBy(className = "error-button")
    WebElement errorButton;


    public boolean isErrorButtonDisplayed() {
        return ElementFluentWaitUtility.getElementByFluentWait(errorButton, 10, 500, driver).isDisplayed();
    }


    public ProductPage login(String user, String pass) {
        ElementFluentWaitUtility.getElementByFluentWait(userName, 10, 500, driver).sendKeys(user);
        ElementFluentWaitUtility.getElementByFluentWait(password, 10, 500, driver).sendKeys(pass);
        ElementFluentWaitUtility.getElementByFluentWait(loginButton, 10, 500, driver).click();
        return new ProductPage(driver);
    }


}
