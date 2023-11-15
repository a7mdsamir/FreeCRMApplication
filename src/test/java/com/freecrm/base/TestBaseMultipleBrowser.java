package com.freecrm.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBaseMultipleBrowser {

    public static ChromeDriver driver;
    public static Properties prop;
    public TestBaseMultipleBrowser() throws IOException {

    }
    public void init(String browser){
        if(browser.equalsIgnoreCase("chrome")) {
           WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(browser);
            }
        else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
        }

    }

}
