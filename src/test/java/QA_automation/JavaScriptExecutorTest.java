package QA_automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends TestUtil {

    @Test
    public void LoginWithJSAction() throws InterruptedException {
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");

       WebElement loginBtn = driver.findElement(By.cssSelector("[value=Login]"));
       loginBtn.click();  //v1- if we are unable to make such a click
       // loginBtn.sendKeys(Keys.ENTER); v2
        JavascriptExecutor script = (JavascriptExecutor) driver;      //-JvaScript example
       script.executeScript("arguments[0].scrollIntoView()",
                driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']")));

 //       WebElement linkedInLink = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']"));
 //       linkedInLink.click();

    }
}
