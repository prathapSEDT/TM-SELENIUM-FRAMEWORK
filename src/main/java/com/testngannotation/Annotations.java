package com.testngannotation;

import com.genericmethods.WebUtils;
import org.testng.annotations.*;

import java.io.IOException;

public class Annotations {
    @BeforeSuite
    public void beforesuite() throws IOException {
        WebUtils webUtils=new WebUtils();
        WebUtils.browser=webUtils.getConfigDetails("BROWSER");
        WebUtils.url=webUtils.getConfigDetails("APP_URL");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("after Test");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Before method execution");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }

}
