package com.freecrm.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static ChromeDriver driver;
    public static Properties prop;
    public TestBase() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\ahmed\\New\\Automation Courses\\Selenium Java course in Arabic QAcart\\FreeCRMApplication\\src\\test\\java\\com\\freecrm\\config");
        prop.load(fis);
    }
    public void init(String URL){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);

    }

}
