package org.imz.base;




import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.imz.utils.DriverManagerSingleton;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverManagerSingleton.getInstance().getDriver();
    }

    @AfterClass
    public void teardown() {
        DriverManagerSingleton.getInstance().quitDriver();
    }
}