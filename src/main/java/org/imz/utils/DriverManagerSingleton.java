package org.imz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


public class DriverManagerSingleton {

    private static DriverManagerSingleton driverManagerSingleton = null;
    private WebDriver driver;

    // Private constructor to prevent multiple instances
    private DriverManagerSingleton() {

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--incognito"); // or "--guest"

        options.addArguments(
                "--disable-notifications",
                "--disable-popup-blocking",
                "--disable-save-password-bubble",
                "--disable-blink-features=PasswordCredential"
        );

        driver = new ChromeDriver(options);

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
