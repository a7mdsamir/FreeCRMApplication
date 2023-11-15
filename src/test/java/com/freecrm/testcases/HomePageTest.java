package com.freecrm.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest {
    ChromeDriver driver;

    @Parameters({"URL"})
    @BeforeMethod ( groups = {"E2E" , "Sanity" , "Regression"})
    public void setup( String URL ){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement usernameBtn = driver.findElement(By.name("username"));
        WebElement passwordBtn = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        usernameBtn.sendKeys("asamir");
        passwordBtn.sendKeys("a7mdsamir");
        loginBtn.click();
    }
    @AfterMethod ( groups = {"E2E" , "Sanity" , "Regression"})
    public void tearDown(){
        driver.quit();
    }

    @Test (priority = 1, groups = {"E2E" , "Sanity"})
    public void contacts(){
        driver.switchTo().frame("mainpanel");
        WebElement contactsBtn = driver.findElement(By.xpath("//a[text() = 'Contacts']"));
        contactsBtn.click();
        WebElement statusLabel = driver.findElement(By.xpath("//td[text() = 'Status']"));
        boolean actualResult = statusLabel.isDisplayed();
        Assert.assertTrue(actualResult , " status label isn't displayed");

    }
    @Test (priority = 2, groups = {"Regression"})
    public void tasks(){
        driver.switchTo().frame("mainpanel");
        WebElement contactsBtn = driver.findElement(By.xpath("//a[text() = 'Tasks']"));
        contactsBtn.click();
        WebElement statusLabel = driver.findElement(By.xpath("//td[text() = 'Keyword']"));
        boolean actualResult = statusLabel.isDisplayed();
        Assert.assertTrue(actualResult , " Keyword label isn't displayed");

    }
    @Test (priority = 3, groups = {"Regression"} , enabled = false ) // enabl false ya3ni m4 hattnafiz fe ai test
    public void Deals(){
        driver.switchTo().frame("mainpanel");
        WebElement contactsBtn = driver.findElement(By.xpath("//a[text() = 'Deals']"));
        contactsBtn.click();
        WebElement statusLabel = driver.findElement(By.xpath("//td[text() = 'Keyword']"));
        boolean actualResult = statusLabel.isDisplayed();
        Assert.assertTrue(actualResult , " Keyword label isn't displayed");

    }
}
