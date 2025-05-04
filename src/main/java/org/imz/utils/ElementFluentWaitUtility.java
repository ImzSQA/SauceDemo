package org.imz.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;



public class ElementFluentWaitUtility {


    public static WebElement getElementByFluentWait(WebElement element, int timeout, int pollingTime, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.pollingEvery(Duration.ofMillis(pollingTime));

        return wait.until(ExpectedConditions.elementToBeClickable(element));  // Wait explicitly for element to be clickable
    }


}
