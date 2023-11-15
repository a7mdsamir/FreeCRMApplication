package com.freecrm.testcases;

import com.freecrm.base.TestBaseMultipleBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class MultipleBrowser extends com.freecrm.base.TestBaseMultipleBrowser {
    ChromeDriver driver;

    public MultipleBrowser() throws IOException {
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setup( String browser ){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(browser);
        driver.manage().window().maximize();
        WebElement usernameBtn = driver.findElement(By.name("username"));
        WebElement passwordBtn = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        usernameBtn.sendKeys("asamir");
        passwordBtn.sendKeys("a7mdsamir");
        loginBtn.click();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test (priority = 1)
    public void contacts(){
        driver.switchTo().frame("mainpanel");
        WebElement contactsBtn = driver.findElement(By.xpath("//a[text() = 'Contacts']"));
        contactsBtn.click();
        WebElement statusLabel = driver.findElement(By.xpath("//td[text() = 'Status']"));
        boolean actualResult = statusLabel.isDisplayed();
        Assert.assertTrue(actualResult , " status label isn't displayed");

    }
    @Test (priority = 2)
    public void tasks(){
        driver.switchTo().frame("mainpanel");
        WebElement contactsBtn = driver.findElement(By.xpath("//a[text() = 'Tasks']"));
        contactsBtn.click();
        WebElement statusLabel = driver.findElement(By.xpath("//td[text() = 'Keyword']"));
        boolean actualResult = statusLabel.isDisplayed();
        Assert.assertTrue(actualResult , " Keyword label isn't displayed");

    }
    @Test (priority = 3 )
    public void Deals(){
        driver.switchTo().frame("mainpanel");
        WebElement contactsBtn = driver.findElement(By.xpath("//a[text() = 'Deals']"));
        contactsBtn.click();
        WebElement statusLabel = driver.findElement(By.xpath("//td[text() = 'Keyword']"));
        boolean actualResult = statusLabel.isDisplayed();
        Assert.assertTrue(actualResult , " Keyword label isn't displayed");

    }
}
