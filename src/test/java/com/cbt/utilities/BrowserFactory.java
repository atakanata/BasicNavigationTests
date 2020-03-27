package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class BrowserFactory {

    public static WebDriver getDriver(String browserName){
        if (System.getProperty("os.name").toLowerCase().contains("mac")&&browserName.toLowerCase().contains("edge") ){
            return null;
        }else if (System.getProperty("os.name").toLowerCase().contains("windows")&&browserName.toLowerCase().contains("safari") ){
            return null;
        }else if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("79").setup();
            return new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("safari")){
            return new SafariDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            return new EdgeDriver();
        }else {
            return null;
        }
    }

    public static void wait(int seconds)  {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
