package org.imz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerSingleton {

    private static DriverManagerSingleton instance = null;
    private WebDriver driver;

    // Private constructor to prevent multiple instances
    private DriverManagerSingleton() {
        //     System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Singleton pattern to get only one instance of DriverManager
    public static DriverManagerSingleton getInstance() {
        if (instance == null) {
            instance = new DriverManagerSingleton();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instance = null;
        }
    }
}
