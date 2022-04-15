package course.work.petyo.tests;

import base.TestUtilCW;
import course.work.petyo.pages.LoginPageCW;
import course.work.petyo.pages.ProductsPageCW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyingItemsProcess extends TestUtilCW {
    @Test
    public void buyingProcess() throws InterruptedException {
        LoginPageCW loginPageCW = new LoginPageCW(driver);
        String username = new String("standard_user");
        String password = new String("secret_sauce");
        ProductsPageCW productsPageCW = loginPageCW.login(username, password);
        productsPageCW.addToCart("backpack");
        productsPageCW.addToCart("bike-light");
        productsPageCW.items();
        productsPageCW.checkout();
        productsPageCW.checkoutProcess();

        WebElement successfulAddingTestAssertion = driver.findElement(By.id("checkout_complete_container"));
        Assert.assertTrue(successfulAddingTestAssertion.isDisplayed());

    }
}
