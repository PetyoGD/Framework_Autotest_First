package course.work.petyo.tests;

import base.TestUtilCW;
import course.work.petyo.pages.LoginPageCW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginNoPassTest extends TestUtilCW {
    @DataProvider(name = "missingUserData")
    public Object[][] inputWrongData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"standard_user", ""},
        };
    }

    @Test(dataProvider = "missingUserData")

    public void unsuccessfulTestCW(String username, String password) {
        LoginPageCW loginPageCW = new LoginPageCW(driver);
        loginPageCW.tryToLogin(username, password);

        WebElement missingPassData = driver.findElement(By.xpath("//*[text()='Epic sadface: Password is required']"));
        Assert.assertTrue(missingPassData.isDisplayed());

    }
}