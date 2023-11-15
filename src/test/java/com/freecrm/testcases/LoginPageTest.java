package com.freecrm.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class LoginPageTest {
    ChromeDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.out.println("execute before any test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("execute after any test");
    //BeforeTest and AfterTest executed on all classes (LoginPageTest, HomePageTest)
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("execution will run soon");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("execution done");
    }

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

    @DataProvider
    public Object[][] myData(){
        Object[][] data = new Object[4][2];
        data[0][0] = "asamir";
        data[0][1] = "a7mdsamir";
        data[1][0] = "asamir";
        data[1][1] = "asamir";
        data[2][0] = "a7mdsamir";
        data[2][1] = "a7mdsamir";
        data[3][0] = "mohamed";
        data[3][1] = "mohamed";
        return data;
    }

    //**********Note
    // assertion msg appear in case failure of assert
    // Hard assertion if failed , exit code {}

    // Soft assertion if failed , complete code
    // exept .assertAll();
    // .assertAll(); written to know test result

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
    @Test (priority = 4 , dataProvider = "myData")
    public void loginTest( String userName, String password ) {

        WebElement usernameBtn = driver.findElement(By.name("username"));
        WebElement passwordBtn = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));

        usernameBtn.sendKeys(userName);
        passwordBtn.sendKeys(password);
        loginBtn.click();

        String expectedResult = "CRMPRO";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult, expectedResult, "username or password is wrong");

    }
    //@BeforeClass   Only 1 time before all tests in the class
    //@AfterClass    Only 1 time after all tests
    //@BeforeMethod  run before every test / run num of tests
    //@AfterMethod   run after every test / run num of tests
    //BeforeClass, AfterClass, BeforeMethod and AfterMethod executed only on this class (LoginPageTest)
}

