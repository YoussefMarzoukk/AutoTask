package com.saucedemo.Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver initDriver(){

        String browser = System.getProperty("browser","Edge");
        switch (browser){

            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Unable to find entered browser");

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }





}
