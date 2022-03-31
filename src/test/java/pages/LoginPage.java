package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;   //1. Driver

    @FindBy(id="user-name")
    private WebElement userNameInput;

    @FindBy(css="[placeholder=Password]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver){      //2.Which is initialized in constructor
        this.driver = driver;                            //this 3r are veri important
        PageFactory.initElements(driver,this); //3.With factory to be possible to initialized upper part
    }
    //4.Then we have to create methods we need to execute test
    public ProductsPage login(String username, String password){
        userNameInput.click();
        userNameInput.sendKeys(password);

        loginBtn.click();
                                    //5.Wait method have to be created on this page
        return new ProductsPage(driver);
    }
}
