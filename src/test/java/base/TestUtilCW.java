package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class
TestUtilCW {
    public WebDriver driver;
    private String browser;
    private String url;
    private int implicitWait;

    @BeforeMethod
    public void setUp(){
        setupBrowserDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void setupBrowserDriver(){
        try(FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")){
            Properties config = new Properties();
            config.load(configFile);
            browser = config.getProperty("browser");
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));

        }catch (IOException e){
        System.out.println("Something went wrong");
        }
        switch (browser){
            case "chrome":
                getChromeDriver(url, implicitWait);
                break;
            case "firefox":
                getFirefoxDriver(url, implicitWait);
                break;
            default:
                throw new IllegalStateException("Check browser");
        }
    }

    public void loadUrl(String url){
        driver.get(url);
    }
    private void getChromeDriver(String url,int implicitWait){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        loadUrl(url);
    }
    private void getFirefoxDriver(String url,int implicitWait){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        loadUrl(url);
    }
}