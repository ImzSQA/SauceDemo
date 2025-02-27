package org.imz.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTestSingleton {

    protected static volatile WebDriver driver;

    public BaseTestSingleton() {
    }

    @BeforeMethod
    // Public method to provide access to the WebDriver instance
    public static void getDriver() {
        if (driver == null) {
            synchronized (BaseTestSingleton.class) { // Ensuring thread safety
                if (driver == null) {
                    ChromeOptions options = new ChromeOptions();
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    // Open Base Url
                    driver.get("https://www.saucedemo.com/"); // Change


                }
            }
        }

    }

    @AfterMethod
    // Method to quit the WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset instance to ensure a new one can be created
        }
    }


    public static boolean waitForPageIsLoad(WebDriver driver) {
        // Max wait time
        // Check every 500ms
        long startTime = System.nanoTime();  // Start time measurement

        try {
            return new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(15))  // Max wait time
                    .pollingEvery(Duration.ofMillis(500))  // Check every 500ms
                    .until(d -> "complete".equals(((JavascriptExecutor) d).executeScript("return document.readyState")));
        } finally {
            long endTime = System.nanoTime();
            System.out.println("FluentWait took total site to load : " + (endTime - startTime) / 1_000_000_000.0 + " seconds");
        }
    }


}




