package org.imz.base;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;

import org.imz.utils.DriverManagerSingleton;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setup() {
        driver = DriverManagerSingleton.getInstance().getDriver();
    }

   @AfterSuite
   public void tearDown() {

       DriverManagerSingleton.getInstance().quitDriver();
    }
}