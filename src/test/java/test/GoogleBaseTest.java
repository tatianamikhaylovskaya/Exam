package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class GoogleBaseTest {
    WebDriver driver;

    /**
     * Rruns before each test method
     * Switching between different browsers
     * opens defined environment link
     * @param browserType browser to be used for tests runs in TestNG xml (Firefox, Chrome)
     * @param urlType  url to start test page
     */

    @Parameters({"browserType","urlType"})
    @BeforeMethod
    public void beforeTest(@Optional("firefox")String browserType, @Optional("https://www.google.com") String urlType){
        switch(browserType.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Unsupported browser");
                break;
        }
        driver.get(urlType);
    }

    /**
     * Runs after each test method
     * closes browser page when test is finished
     */
    @AfterMethod
    public void afterTest() { driver.close(); }
}
