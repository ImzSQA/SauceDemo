package org.imz.base;


import org.imz.utils.Cons;
import org.imz.utils.DriverFactory;
import org.imz.utils.DriverManager;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {


    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        // Initialize WebDriver using the browser name passed from the TestNG XML
        WebDriver driver = DriverFactory.initializeDriver(browser);
        DriverManager.setDriver(driver);
        driver.get(Cons.BASE_WEB); // Open the website
    }

    @AfterMethod
    public void tearDown() {
        //   DriverManager.quitDriver();  // Quit WebDriver and clean up after the test
    }
}