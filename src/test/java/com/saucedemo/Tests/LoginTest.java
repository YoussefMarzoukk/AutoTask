package com.saucedemo.Tests;

import com.saucedemo.Base.BaseTest;
import com.saucedemo.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(dataProvider ="Valid_Login_Data", dataProviderClass = com.saucedemo.DataProvider.Data.class, description = " Verifying that user can login using valid credentials")
    public void ValidLogin(String Username, String Password){
        LoginPage loginPage = new LoginPage(driver);
        boolean IsWelcomeMSGDisplayed =
                loginPage
                        .load()
                        .ValidLogin(Username,Password)
                        .isWelcomeMSGVisible();

        Assert.assertTrue(IsWelcomeMSGDisplayed);

    }

    @Test(dataProvider ="InValid_Login_Data", dataProviderClass = com.saucedemo.DataProvider.Data.class,description = " Verifying that user can't login using invalid credentials and error message pops up")
    public void InvalidLogin_InvalidCredentials(String Username, String Password){
        LoginPage loginPage = new LoginPage(driver);
        String ErrorMSG =
                loginPage
                        .load()
                        .InValidLogin(Username,Password).WrongCredentialsError();
        Assert.assertTrue(ErrorMSG.contains(" Username and password do not match any user in this service"));

    }

    @Test(dataProvider ="InValid_Login_Data_Empty_Username", dataProviderClass = com.saucedemo.DataProvider.Data.class,description = " Verifying that error message appears when username field is empty when user attempts to log in")
    public void InvalidLogin_UsernameFieldEmpty(String Username, String Password){
        LoginPage loginPage = new LoginPage(driver);
        String ErrorMSG =
                loginPage
                        .load()
                        .InValidLogin(Username,Password).WrongCredentialsError();
        Assert.assertTrue(ErrorMSG.contains(" Username is required"));

    }

    @Test(dataProvider ="InValid_Login_Data_Empty_Password", dataProviderClass = com.saucedemo.DataProvider.Data.class,description = " Verifying that error message appears when password field is empty when user attempts to log in")
    public void InvalidLogin_PasswordFieldEmpty(String Username,String Password){
        LoginPage loginPage = new LoginPage(driver);
        String ErrorMSG =
                loginPage
                        .load()
                        .InValidLogin(Username,Password).WrongCredentialsError();
        Assert.assertTrue(ErrorMSG.contains("Password is required"));

    }






}
