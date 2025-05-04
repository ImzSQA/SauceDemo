package org.imz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


public class DriverFactory {

    public static WebDriver initializeDriver(String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = getChromeOptions();
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }


    private static ChromeOptions getChromeOptions() {
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
        return options;
    }


}
