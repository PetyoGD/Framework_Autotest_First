package course.work.petyo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageCW {
    protected WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[text()='Epic sadface: Username and password do not match any user in this service']")
    private WebElement userpassErrorMessage;

    @FindBy(xpath = "//*[text()='Epic sadface: Username is required']")
    private WebElement userMissErrorMessage;

    @FindBy(xpath =  "//*[text()='Epic sadface: Password is required']")
    private WebElement passMissErrorMessage;

    public LoginPageCW(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ProductsPageCW login(String username,String password){
        userNameInput.click();
        userNameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.sendKeys(password);

        loginBtn.click();

        return new ProductsPageCW(driver);
    }

    public void tryToLogin(String username,String password){
        userNameInput.click();
        userNameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.sendKeys(password);

        loginBtn.click();
    }

}
