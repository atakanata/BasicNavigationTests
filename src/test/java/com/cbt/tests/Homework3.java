package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Homework3 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        //driver = BrowserFactory.getDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){
        String url = "https://practice-cybertekschool.herokuapp.com/";
        driver.get(url);
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        WebElement warning1 = driver.findElement(By.xpath("//*[@id='registrationForm']/div[8]/div/small[2]"));
        Assert.assertTrue(warning1.isDisplayed());
    }
    @Test
    public void test2(){
        String url = "https://practice-cybertekschool.herokuapp.com/";
        driver.get(url);
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement cplusplus = driver.findElement(By.xpath("//*[@id=\'inlineCheckbox1\']//.."));
        WebElement java = driver.findElement(By.xpath("//*[@id=\'inlineCheckbox2\']//.."));
        WebElement JS = driver.findElement(By.xpath("//*[@id=\'inlineCheckbox3\']//.."));
        Assert.assertTrue(cplusplus.isDisplayed());
        Assert.assertTrue(java.isDisplayed());
        Assert.assertTrue(JS.isDisplayed());
    }

    @Test
    public void test6(){
        String url = "https://temp-mail.org/en/";
        driver.get(url);
        String email = driver.findElement(By.id("mail")).getAttribute("value");
        //System.out.println("email = " + email);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Atakan Ata");
        driver.findElement(By.name("email")).sendKeys(email, Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.name("signup_message")).isDisplayed());
        driver.navigate().to("https://temp-mail.org/en/");
        BrowserFactory.wait(3);
        driver.findElement(By.linkText("do-not-reply@practice.cybertekschool.com")).click();
        BrowserFactory.wait(3);
        String fromEmail = driver.findElement(By.className("from-email")).getText();
        String expected = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(fromEmail,expected);
        Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(), "Thanks for subscribing to practice.cybertekschool.com!");

    }
}
