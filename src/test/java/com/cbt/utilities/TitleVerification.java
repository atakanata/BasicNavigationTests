package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/", "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(urls.get(0));
        String pageTitle0 = driver.getTitle();
        String pageCurrentUrl0 = driver.getCurrentUrl();

        driver.get(urls.get(1));
        String pageTitle1 = driver.getTitle();
        String pageCurrentUrl1 = driver.getCurrentUrl();

        driver.get(urls.get(2));
        String pageTitle2 = driver.getTitle();
        String pageCurrentUrl2 = driver.getCurrentUrl();

        StringUtility.verifyEquals(pageTitle0,pageTitle1);
        StringUtility.verifyEquals(pageTitle1,pageTitle2);
        Assert.assertTrue(pageCurrentUrl0.startsWith("http://practice.cybertekschool.com"));
        Assert.assertTrue(pageCurrentUrl1.startsWith("http://practice.cybertekschool.com"));
        Assert.assertTrue(pageCurrentUrl2.startsWith("http://practice.cybertekschool.com"));
        driver.quit();
    }
}
