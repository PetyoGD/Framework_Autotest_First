package course.work.petyo.tests;

import base.TestUtilCW;
import course.work.petyo.pages.LoginPageCW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginUnTest extends TestUtilCW {

    @DataProvider(name = "wrongUserPassData")
    public Object [][] inputWrongData(){
        return new Object[][]{
                {"standar_user","secret_sauce"},
                {"standard_user","sicret_sauce"},
        };
    }

    @Test(dataProvider = "wrongUserPassData")

    public void unsuccessfulTestCW(String username,String password){
        LoginPageCW loginPageCW = new LoginPageCW(driver);
        loginPageCW.tryToLogin(username,password);

        WebElement wrongUserOrPassData = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));
        Assert.assertTrue(wrongUserOrPassData.isDisplayed());
    }

}
