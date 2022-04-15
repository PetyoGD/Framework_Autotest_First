package course.work.petyo.tests;

import base.TestUtilCW;
import com.opencsv.exceptions.CsvException;
import course.work.petyo.pages.LoginPageCW;
import course.work.petyo.pages.ProductsPageCW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvHelperCW;

import java.io.IOException;

public class LoginTest extends TestUtilCW {

    @DataProvider(name = "csvUserCW")
    public Object [][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelperCW.readCsvFile("src/test/resources/users.csv");
    }

    @Test(dataProvider = "csvUserCW")
    public void successTestCW(String username,String password) throws InterruptedException {
        LoginPageCW loginPageCW = new LoginPageCW(driver);
        ProductsPageCW productsPageCW = loginPageCW.login(username, password);

        WebElement successfulTestAssertion = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(successfulTestAssertion.isDisplayed());
    }
}
