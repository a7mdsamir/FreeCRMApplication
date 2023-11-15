package com.freecrm.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Snapshot {
    ChromeDriver driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://classic.crmpro.com/index.html");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




    @Test (priority = 1)
    public void titleTest(Method method) throws IOException {

        SoftAssert softAssert = new SoftAssert();
        String expectedResult = "Free CRM software for customer relationship management, sales, and support." ;
        String actualResult = driver.getTitle();
        System.out.println( actualResult );
        //Assert.assertEquals(actualResult,expectedResult , "msg appear in case failure of assert");
        softAssert.assertEquals(actualResult,expectedResult , "msg appear in case failure of assert");
        System.out.println("Complete code in case failure of assert");
        softAssert.assertAll();
        System.out.println("Complete only in case success of all assertions, Exit code in case failure of any assert");

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("D:\\ahmed\\New\\Automation Courses\\Selenium Java course in Arabic QAcart\\FreeCRMApplication\\Snapshots\\"+method.getName()+".png"));
    }
    @Test (priority = 2)
    public void urlCheck(Method method) throws IOException {

        String expectedResult = "https://classic.freecrm.com/index.html" ;
        String actualResult = driver.getCurrentUrl();
        System.out.println( actualResult );
        Assert.assertNotEquals(actualResult,expectedResult ,"Failed https://classic.crmpro.com/index.html");
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("D:\\ahmed\\New\\Automation Courses\\Selenium Java course in Arabic QAcart\\FreeCRMApplication\\Snapshots\\"+method.getName()+".png"));

    }
    @Test (priority = 3)
    public void logoTest(Method method) throws IOException {

        WebElement logo = driver.findElement(By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']"));
        //boolean expectedResult = true ;
        boolean actualResult = logo.isDisplayed();
        System.out.println( actualResult );
        //Assert.assertEquals(actualResult,expectedResult);
        Assert.assertTrue(actualResult);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("D:\\ahmed\\New\\Automation Courses\\Selenium Java course in Arabic QAcart\\FreeCRMApplication\\Snapshots\\"+method.getName()+".png"));

    }

    }

