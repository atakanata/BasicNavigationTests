package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TitleVerification2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com/", "https://walmart.com","https://www.westelm.com/");

        //WebDriver driver = BrowserFactory.getDriver("chrome");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setHeadless(true);
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver(options);

        driver.get(urls.get(0));
        String pageTitle0 = driver.getTitle().toLowerCase().replace(" ","");
        String pageCurrentUrl0 = driver.getCurrentUrl().split("\\.")[1];
        if (pageTitle0.contains(pageCurrentUrl0)){
            System.out.println("index 0 passed");
        }else {
            System.out.println("index 0 failed");
        }


        driver.get(urls.get(1));
        String pageTitle1 = driver.getTitle().toLowerCase().replace(" ","");
        String pageCurrentUrl1 = driver.getCurrentUrl().split("\\.")[1];
        if (pageTitle1.contains(pageCurrentUrl1)){
            System.out.println("index 1 passed");
        }else {
            System.out.println("index 1 failed");
            System.out.println(pageTitle1);
            System.out.println(pageCurrentUrl1);
        }



        driver.get(urls.get(2));
        String pageTitle2 = driver.getTitle().toLowerCase().replace(" ","");
        String pageCurrentUrl2 = driver.getCurrentUrl().split("\\.")[1];
        if (pageTitle2.contains(pageCurrentUrl2)){
            System.out.println("index 2 passed");
        }else {
            System.out.println("index 2 failed");
            System.out.println(pageTitle2);
            System.out.println(pageCurrentUrl2);
        }


        driver.get(urls.get(3));
        String pageTitle3 = driver.getTitle().toLowerCase().replace(" ","");
        String pageCurrentUrl3 = driver.getCurrentUrl().split("\\.")[1];
        if (pageTitle3.contains(pageCurrentUrl3)){
            System.out.println("index 3 passed");
        }else {
            System.out.println("index 3 failed");
            System.out.println(pageTitle3);
            System.out.println(pageCurrentUrl3);
        }

        driver.quit();
    }
}
