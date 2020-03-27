package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigationTests {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        //driver = BrowserFactory.getDriver()

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){
        String browserName = "chrome";
        driver = BrowserFactory.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.get("https://google.com");
        String GoogleTitle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String EtsyTitle = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(driver.getTitle(),GoogleTitle);
        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(),EtsyTitle);
    }

    @Test
    public void test2(){
        String browserName = "safari";
        driver = BrowserFactory.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.get("https://google.com");
        String GoogleTitle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String EtsyTitle = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(driver.getTitle(),GoogleTitle);
        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(),EtsyTitle);
    }

    @Test
    public void test3(){
        String browserName = "firefox";
        driver = BrowserFactory.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.get("https://google.com");
        String GoogleTitle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String EtsyTitle = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(driver.getTitle(),GoogleTitle);
        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(),EtsyTitle);
    }

}
