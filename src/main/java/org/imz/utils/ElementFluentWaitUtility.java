package org.imz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;


public class ElementFluentWaitUtility {


    public static WebElement getElementByFluentWait(WebElement element, int timeout, int pollingTime, WebDriver webDriver) {


        FluentWait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(timeout))  // Maximum wait
                .pollingEvery(Duration.ofSeconds(pollingTime))  // Check every
                .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException


        return wait.until(driver -> {
            if (element.isDisplayed()) {
                return element;
            } else {
                return null;
            }
        });


    }


}
