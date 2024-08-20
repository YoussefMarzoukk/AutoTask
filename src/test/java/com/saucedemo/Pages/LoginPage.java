package com.saucedemo.Pages;

import com.saucedemo.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By UserNameField = By.id("user-name");
    private By PasswordField = By.id("password");
    private By Login_Button = By.id("login-button");
    private By InvalidCredintials_Error = By.cssSelector("h3[data-test='error']");
    private By LoginLogo = By.cssSelector("div[class*='logo']");



    public LoginPage load(){
        driver.get("https://www.saucedemo.com/");
        return new LoginPage(driver);
    }

    public HomePage ValidLogin(String Username, String Password){
        driver.findElement(UserNameField).sendKeys(Username);
        driver.findElement(PasswordField).sendKeys(Password);
        driver.findElement(Login_Button).click();

        return new HomePage(driver);
    }

    public LoginPage InValidLogin(String Username, String Password){
        driver.findElement(UserNameField).sendKeys(Username);
        driver.findElement(PasswordField).sendKeys(Password);
        driver.findElement(Login_Button).click();
        return this;
    }

    public String WrongCredentialsError(){
        return driver.findElement(InvalidCredintials_Error).getText();
    }

    public boolean isLoginLogoVisible(){
        return driver.findElement(LoginLogo).isDisplayed();
    }



}