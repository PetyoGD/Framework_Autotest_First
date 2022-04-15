package course.work.petyo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ProductsPageCW{
    protected WebDriver driver;

    private static final String ADD_TO_CART = "//button[@id='add-to-cart-sauce-labs-%s']";

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(className = "shopping_cart_badge")
    private WebElement numberItemsInCart;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "finish")
    private WebElement finishBtn;


    public ProductsPageCW(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart(String itemName) {
        String xpathOfItem = String.format(ADD_TO_CART, itemName);
        WebElement addToCartBtn = driver.findElement(By.xpath(xpathOfItem));
        addToCartBtn.click();

    }

    public int getItemNumber() {
        if (numberItemsInCart.getText().isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(numberItemsInCart.getText());
        }
    }

    public ProductsPageCW items() {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2)).ignoreAll(Collections.singleton(NoClassDefFoundError.class));
        wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        cartLink.click();
        return new ProductsPageCW(driver);
    }

    public ProductsPageCW checkout() {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2)).ignoreAll(Collections.singleton(NoClassDefFoundError.class));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        checkoutBtn.click();
        return new ProductsPageCW(driver);
    }

    public ProductsPageCW checkoutProcess() {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2)).ignoreAll(Collections.singleton(NoSuchElementException.class));

        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        firstNameInput.click();
        firstNameInput.sendKeys("Petyo");

        wait.until(ExpectedConditions.elementToBeClickable(lastNameInput));
        lastNameInput.click();
        lastNameInput.sendKeys("Dimitrov");

        wait.until(ExpectedConditions.elementToBeClickable(postalCodeInput));
        postalCodeInput.click();
        postalCodeInput.sendKeys("1220");

        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        finishBtn.click();

        return new ProductsPageCW(driver);
    }
}
