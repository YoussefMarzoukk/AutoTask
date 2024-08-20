package com.saucedemo.Pages;

import com.saucedemo.Base.BasePage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By welcomeMSG = By.cssSelector("div[class^='app']");
    private By hamburgerMenu = By.cssSelector("#react-burger-menu-btn");
    private By logoutButton = By.cssSelector("a[data-test='logout-sidebar-link']");
    private By productItems = By.cssSelector(".inventory_item");
    private By productName = By.cssSelector(".inventory_item_name");
    private By productPrice = By.cssSelector(".inventory_item_price");
    private By productDescription = By.cssSelector(".inventory_item_desc");
    private By sortDropdown = By.cssSelector(".product_sort_container");
    WebElement dropdownElement = driver.findElement(sortDropdown);
    Select sort = new Select(dropdownElement);




    public boolean isWelcomeMSGVisible(){
        return driver.findElement(welcomeMSG).isDisplayed();
    }

    public LoginPage logout(){
        driver.findElement(hamburgerMenu).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();


        return new LoginPage(driver);
    }


    public int  areAllProductsDisplayed(){

        List<WebElement> products = driver.findElements(productItems);
        return products.size();

    }

    public HomePage sortLowHigh(){
        driver.findElement(sortDropdown).click();
        sort.selectByVisibleText("Price (low to high)");
        return this;
    }


    public HomePage sortHighLow(){
        driver.findElement(sortDropdown).click();
        sort.selectByVisibleText("Price (high to low)");
        return this;
    }

    public List<Double> sortPricesLowHigh(List<Double> prices) {
        List<Double> sortedPrices = new ArrayList<>(prices); // Create a copy of the list
        Collections.sort(sortedPrices);
        return sortedPrices;
    }

    public List<Double> sortPricesHighLow(List<Double> prices) {
        List<Double> sortedPrices = new ArrayList<>(prices); // Create a copy of the list
        Collections.sort(sortedPrices, Comparator.reverseOrder());
        return sortedPrices;
    }

    public List<Double> getProductPrices() {
        List<WebElement> priceElements = driver.findElements(productPrice);
        return priceElements.stream()
                .map(price -> Double.parseDouble(price.getText().replace("$", "")))
                .collect(Collectors.toList());
    }


    public List<String> getAllNames(){
        List<WebElement> AllNames = driver.findElements(productName);
        return AllNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Double> getAllPrices(){
        List<Double> AllPrices = getProductPrices();
        return AllPrices;
    }

    public List<String> getAllDescriptions(){
        List<WebElement> AllDescriptions = driver.findElements(productDescription);
        return AllDescriptions.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());








}}