package com.freecrm.testcases;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigExample {

    @Test
    public void printValues() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\ahmed\\New\\Automation Courses\\Selenium Java course in Arabic QAcart\\FreeCRMApplication\\src\\test\\java\\com\\freecrm\\config");
        prop.load(fis);

        String url = prop.getProperty("URL");
        System.out.println(url);
    }
}
