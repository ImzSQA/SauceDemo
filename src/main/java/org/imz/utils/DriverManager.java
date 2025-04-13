

package org.imz.utils;

import org.openqa.selenium.WebDriver;


public class DriverManager {


    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    // Method to get WebDriver instance for the current thread

    public static WebDriver getDriver() {
        return threadDriver.get();
    }
    // Method to set WebDriver for the current thread

    public static void setDriver(WebDriver driver) {
        threadDriver.set(driver);
    }
    // Method to quit the WebDriver for the current thread


    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            threadDriver.remove();  // Remove the driver to avoid memory leaks
        }
    }


}

