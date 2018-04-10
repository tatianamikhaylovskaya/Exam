package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleMainPage extends GoogleBasePage {
    /**
     *  field for entering text for searching
     */
    @FindBy(id = "lst-ib")
    private WebElement searchInputField;

    /**
     * Button clicking on which start search process
     */
    @FindBy(name = "btnK")
    private WebElement searchInGoogleButton;

    /**
     * Constructor of GoogleMainPage class that takes WebDriver instance from GoogleBasePage class
     * and initialise GoogleMainPage WebElements via PageFactory.
     * @param driver - WebDriver instance that was
     */
    public GoogleMainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Searches  elements for entered  search term
     * @param searchTerm - text for search into google
     * @return first page of search results
     */
    public GoogleFirstSearchResultPage searchForTerm (String searchTerm){
        searchInputField.sendKeys(searchTerm);
        waitUntilElementIsClickable(searchInGoogleButton,10);
        searchInGoogleButton.submit();
        return new GoogleFirstSearchResultPage(driver);
    }
}
