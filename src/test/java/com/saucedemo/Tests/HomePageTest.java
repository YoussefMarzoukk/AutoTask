package com.saucedemo.Tests;

import com.saucedemo.Base.BaseTest;
import com.saucedemo.Pages.HomePage;
import com.saucedemo.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTest {

    @Test(dataProvider ="Valid_Login_Data", dataProviderClass = com.saucedemo.DataProvider.Data.class, description = "Logout")
    public void Logout(String Username, String Password){
        LoginPage loginPage = new LoginPage(driver);
        boolean LogoutSuccessful = loginPage.load().ValidLogin(Username, Password).logout().isLoginLogoVisible();
        Assert.assertTrue(LogoutSuccessful, "Logout was not successful, login logo not visible.");


    }
//Question: Can I use 2 Data Providers?
    @Test(dataProvider ="Valid_Login_Data", dataProviderClass = com.saucedemo.DataProvider.Data.class, description = "Are all products displayed?")
    public void allProductsDisplayed(String Username, String Password){
        LoginPage loginPage = new LoginPage(driver);
        int ProductNo = loginPage.load().ValidLogin(Username, Password).areAllProductsDisplayed();

        Assert.assertEquals(ProductNo, 6, "Not all Products are Displayed");


    }

    @Test(dataProvider ="Valid_Login_Data", dataProviderClass = com.saucedemo.DataProvider.Data.class, description = "SortLowHigh")
    public void sortLowHighTest(String Username, String Password) {
        LoginPage loginPage = new LoginPage(driver);

        List<Double> PriceAfterSorting = loginPage.load().ValidLogin(Username, Password).sortLowHigh().getProductPrices();

        HomePage homePage = new HomePage(driver);
        List<Double> ExpectedLH = homePage.sortPricesLowHigh(PriceAfterSorting);

        Assert.assertEquals(PriceAfterSorting, ExpectedLH, "Items not sorted correctly(Low to High)");


    }
    @Test(dataProvider ="Valid_Login_Data", dataProviderClass = com.saucedemo.DataProvider.Data.class, description = "SortHighLowTest")
    public void sortHighLowTest(String Username, String Password) {
        LoginPage loginPage = new LoginPage(driver);

        List<Double> PriceAfterSorting = loginPage.load().ValidLogin(Username, Password).sortHighLow().getProductPrices();

        HomePage homePage = new HomePage(driver);
        List<Double> ExpectedHL = homePage.sortPricesHighLow(PriceAfterSorting);

        Assert.assertEquals(PriceAfterSorting, ExpectedHL, "Items not sorted correctly(High to Low)");


    }


    @Test(dataProvider ="productData", dataProviderClass = com.saucedemo.DataProvider.Data.class, description = "Checking Product Details")
    public void ProductDetailsTest(String[] ExpectedNames, Double[] ExpectedPrices, String[] ExpectedDescriptions) {
        LoginPage loginPage = new LoginPage(driver);

        HomePage homePage = loginPage.load().ValidLogin("standard_user","secret_sauce");

        List<String> ActualNames = homePage.getAllNames();
        List<Double> ActualPrices = homePage.getAllPrices();
        List<String> ActualDescriptions = homePage.getAllDescriptions();

        for (int i = 0; i < ExpectedNames.length; i++) {
            Assert.assertEquals(ActualNames.get(i), ExpectedNames[i], "Product name mismatch at product number:" + i);
            Assert.assertEquals(ActualPrices.get(i), ExpectedPrices[i], "Product price mismatch at product number:" + i);
            Assert.assertEquals(ActualDescriptions.get(i), ExpectedDescriptions[i], "Product description mismatch at product number:" + i);
        }




    }




    }









