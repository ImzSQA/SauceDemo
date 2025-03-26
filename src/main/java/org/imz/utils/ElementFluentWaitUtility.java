package org.imz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class ElementFluentWaitUtility {


    public static WebElement getElementByFluentWait(By by, WebDriver driver) {


        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))  // Maximum wait time
                .pollingEvery(Duration.ofSeconds(2))  // Check every 2 seconds
                .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException

        // Wait until the element is visible
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement ele = driver.findElement(by);
                if (ele.isDisplayed()) {
                    return ele;
                } else {
                    return null;
                }
            }
        });

        return element;
    }

    public static WebElement getElementByFluentWait(WebElement webElement, WebDriver driver) {

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))  // Maximum wait time
                .pollingEvery(Duration.ofSeconds(2))  // Check every 2 seconds
                .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException

        // Wait until the element is visible
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement ele = webElement;
                if (ele.isDisplayed()) {
                    return ele;
                } else {
                    return null;
                }
            }
        });
        return element;
    }
}
