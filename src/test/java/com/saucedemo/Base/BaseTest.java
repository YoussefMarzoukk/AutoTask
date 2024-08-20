package com.saucedemo.Base;

import com.saucedemo.Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = new DriverFactory().initDriver();

    }

    @AfterMethod
    public void teardown(){

        driver.quit();
    }




}