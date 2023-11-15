package com.freecrm.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestBase extends com.freecrm.base.TestBase {

    public TestBase() throws IOException {
    }

    @BeforeMethod
    public void setup(){

        init(prop.getProperty("URL"));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



    @Test (priority = 1)
    public void titleTest(){

        SoftAssert softAssert = new SoftAssert();
        String expectedResult = "Free CRM software for customer relationship management, sales, and support." ;
        String actualResult = driver.getTitle();
        System.out.println( actualResult );
        //Assert.assertEquals(actualResult,expectedResult , "msg appear in case failure of assert");
        softAssert.assertEquals(actualResult,expectedResult , "msg appear in case failure of assert");
        System.out.println("Complete code in case failure of assert");
        softAssert.assertAll();
        System.out.println("Complete only in case success of all assertions, Exit code in case failure of any assert");
    }
    @Test (priority = 2)
    public void urlCheck(){

        String expectedResult = "https://classic.freecrm.com/index.html" ;
        String actualResult = driver.getCurrentUrl();
        System.out.println( actualResult );
        Assert.assertNotEquals(actualResult,expectedResult ,"Failed https://classic.crmpro.com/index.html");
    }
    @Test (priority = 3)
    public void logoTest()  {

        WebElement logo = driver.findElement(By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']"));
        //boolean expectedResult = true ;
        boolean actualResult = logo.isDisplayed();
        System.out.println( actualResult );
        //Assert.assertEquals(actualResult,expectedResult);
        Assert.assertTrue(actualResult);
    }
    @Test (priority = 4 )
    public void loginTest() {

        WebElement usernameBtn = driver.findElement(By.name("username"));
        WebElement passwordBtn = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));

        usernameBtn.sendKeys("asamir");
        passwordBtn.sendKeys("a7mdsamir");
        loginBtn.click();

        String expectedResult = "CRMPRO";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult, expectedResult, "username or password is wrong");

    }
    }