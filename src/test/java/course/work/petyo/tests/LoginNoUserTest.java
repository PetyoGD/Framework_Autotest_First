package course.work.petyo.tests;

import base.TestUtilCW;
import course.work.petyo.pages.LoginPageCW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginNoUserTest extends TestUtilCW {


    @DataProvider(name = "missingUserData")
    public Object[][] inputWrongData() {
        return new Object[][]{
                {"standard_user", "sicret_sauce"},
                {"", "secret_sauce"},
        };
    }

    @Test(dataProvider = "missingUserData")

    public void unsuccessfulTestCW(String username, String password) {
        LoginPageCW loginPageCW = new LoginPageCW(driver);
        loginPageCW.tryToLogin(username, password);

        WebElement missingUserData = driver.findElement(By.xpath("//*[text()='Epic sadface: Username is required']"));
        Assert.assertTrue(missingUserData.isDisplayed());
    }
}