package QA_automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstSelenTest {
    public WebDriver driver;

    @BeforeTest
    public void initializeDiver() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successfulTest() {
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");
        //find element using xpath and indexing the results
        WebElement password = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[value=Login]"));
        loginBtn.click();
        //so far we don't have a test
        WebElement userAllPagesBtn = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(userAllPagesBtn.isDisplayed());
    }
}
