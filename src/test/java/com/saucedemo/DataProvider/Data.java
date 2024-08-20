package com.saucedemo.DataProvider;

import org.testng.annotations.DataProvider;

public class Data {
    ///***VALID Login Data**///

    @DataProvider(name = "Valid_Login_Data")
    public static Object[][] ValidLogin() {
        return new Object[][]{{"standard_user","secret_sauce"}};

        ///***INVALID Login Data**///
    }
    @DataProvider(name = "InValid_Login_Data")
    public static Object[][] InValidLogin() {
        return new Object[][]{{"Invalid_User","secret_sauce"}};
    }
    @DataProvider(name = "InValid_Login_Data_Empty_Username")
    public static Object[][] InValidLogin_Username() {
        return new Object[][]{{"","secret_sauce"}};
    }
    @DataProvider(name = "InValid_Login_Data_Empty_Password")
    public static Object[][] InValidLogin_Password() {
        return new Object[][]{{"standard_user",""}};
    }


    @DataProvider(name = "productData")
    public Object[][] provideProductData() {
        return new Object[][] {
                {
                        // Expected names
                        new String[] { "Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)" },
                        // Expected prices
                        new Double[] { 29.99, 9.99, 15.99, 49.99, 7.99, 15.99 },
                        // Expected descriptions
                        new String[] {
                                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
                                , "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."
                                , "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."
                                , "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."
                                , "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."
                                , "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton." }
                }
        };
    }

}