package org.imz.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By productsTitle = By.className("title");

    public boolean isProductsPageVisible() {
        return driver.findElement(productsTitle).isDisplayed();
    }

    public String getPageTitle() {
        return driver.findElement(productsTitle).getText();
    }


}
