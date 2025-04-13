package org.imz.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imz.base.BaseTest;

import org.imz.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class ProductTest extends BaseTest {
    private WebDriver driver = DriverManager.getDriver();

    private static final Logger logger = LogManager.getLogger(ProductTest.class);


    private void checkAllListedItemsShowing() {
        List<WebElement> inventory_item = driver.findElements(By.className("inventory_item"));
        for (WebElement element : inventory_item) {
            System.out.println(element.isDisplayed());
            logger.info("Listed " + inventory_item.size());
        }


    }
}



