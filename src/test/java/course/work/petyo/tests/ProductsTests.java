package course.work.petyo.tests;

import base.TestUtilCW;
import course.work.petyo.pages.LoginPageCW;
import course.work.petyo.pages.ProductsPageCW;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends TestUtilCW {

    @Test
    public void addToCart(){
        LoginPageCW loginPageCW = new LoginPageCW(driver);
        String username = new String("standard_user");
        String password = new String("secret_sauce");
        ProductsPageCW productsPageCW = loginPageCW.login(username,password);
        productsPageCW.addToCart("backpack");
        productsPageCW.addToCart("bike-light");

        Assert.assertEquals(productsPageCW.getItemNumber(),2,"We have only two items in the cart");
    }

}
