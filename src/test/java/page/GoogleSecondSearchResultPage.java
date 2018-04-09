package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSecondSearchResultPage extends GoogleFirstSearchResultPage {
    /**
     * Constructor of GoogleSecondSearchResultPage class that takes WebDriver instance from GoogleBasePage class
     * and initialise GoogleSecondSearchResultsPage WebElements via PageFactory.
     * @param driver - WebDriver instance
     */
    public GoogleSecondSearchResultPage(WebDriver driver){
        super(driver);
    }
}