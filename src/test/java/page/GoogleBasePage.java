package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GoogleBasePage {
    WebDriver driver;

    /**
     *Constructor of GoogleBasePage class which takes Web Driver instance in @BeforeMethod for reuse in  GoogleBasePage class methods
     * @param driver - WebDriver instance
     */
        public GoogleBasePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Wait until WebElement is Clickable on Web page
     * @param webElement - WebElement to wait for
     * @param timeOutInSeconds - period of time for waiting WebElement
     * @return - WebElement after wait
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    /**
     * Wait until WebElement appears on the Web Page
     * @param webElement - Web Element to Wait for
     * @param timeOutInSeconds - period of time for waiting WebElement
     */
    public void waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }



}
