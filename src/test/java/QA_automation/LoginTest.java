package QA_automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;//not more usable
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //not more usable
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;//
import org.testng.Assert;
import org.testng.annotations.AfterTest;//
import org.testng.annotations.BeforeTest;//
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvHelper;

import java.io.IOException;

public class LoginTest extends TestUtil {
//    public WebDriver driver;
//
//    @BeforeTest
//    public void initializeDiver() {
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//    }
//
//    @AfterTest
//   public void tearDown(){
//        driver.quit();}

    @DataProvider(name = "wrongUserList")
    public Object [][] getWrongUsers(){
        return new Object[][]{
                {"standardUser","secret_sauce"},
                {"standard_user","wrong password"},
                {"blah","blah"},
                {"","secret_sauce"},
                {"blah",""},
        };
    }

    @DataProvider(name = "csvUserList")
    public static  Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/users.csv");
    }

    @Test (dataProvider = "wrongUserList") //That is linked with dataprovider and with Strings we determined U & P
    public void UnsuccessfulLogin(String userName,String password){
//      driver.get("https://www.saucedemo.com/");
//ew use both String parameters (userName & password below as username and pass
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys(userName); //from String r.36
        //find element using xpath and indexing the results
        WebElement passwordInput = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordInput.click();
        passwordInput.sendKeys(password); //from String r.36

        WebElement loginBtn = driver.findElement(By.cssSelector("[value=Login]"));
        loginBtn.click();

        WebElement errorLoginLabel = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));
        Assert.assertTrue(errorLoginLabel.isDisplayed());
    }

    @Test(dataProvider = "csvUserList")
    public void SuccessfilLogin(String userName,String password){
        driver.get("https://www.saucedemo.com/");
//ew use both String parameters (userName & password below as username and pass
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys(userName); //from String r.36
        //find element using xpath and indexing the results
        WebElement passwordInput = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordInput.click();
        passwordInput.sendKeys(password); //from String r.36

        WebElement loginBtn = driver.findElement(By.cssSelector("[value=Login]"));
        loginBtn.click();//copied from r.37 to r.48

        WebElement userAllPagesBtn = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(userAllPagesBtn.isDisplayed());//copied from FirstSTest r.42 to r.43
    }
}
