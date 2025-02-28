package org.imz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerSingleton {

    private static DriverManagerSingleton driverManagerSingleton = null;
    private WebDriver driver;

    // Private constructor to prevent multiple instances
    private DriverManagerSingleton() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Singleton pattern to get only one instance of DriverManager
    public static DriverManagerSingleton getInstance() {
        if (driverManagerSingleton == null) {
            driverManagerSingleton = new DriverManagerSingleton();
        }
        return driverManagerSingleton;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            driverManagerSingleton = null;
        }
    }
}
