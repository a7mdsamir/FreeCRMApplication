package com.freecrm.testcases;

import org.testng.annotations.*;

public class BeforeAndAfter {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod");
    }
    @Test
    public void testCase1(){
        System.out.println("TestCase 1 ");
    }
    @Test
    public void testCase2(){
        System.out.println("TestCase 2 ");
    }
    @Test
    public void testCase3(){
        System.out.println("TestCase 3 ");
    }
}
