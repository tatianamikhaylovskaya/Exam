package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleFirstSearchResultPage extends GoogleBasePage {
    /**
     * web elements with search results shown after search
     */
    @FindBy(xpath = "//*[@class='srg']//h3/a")
    private List<WebElement> searchResults;

    /**
     * link clicking on which opens another page with search results
     */
    @FindBy(id = "pnnext")
    private WebElement nextPageLink;

    /**
     *Web Element which shows number of search results
     */
    @FindBy(id = "resultStats")
    private WebElement resutlsNumber;

    /**
     * Constructor of GoogleFirstSearchResultPage class that takes WebDriver instance from GoogleBasePage class
     * and initialise GoogleFirstSearchResultPage WebElements via PageFactory.
     * @param driver - WebDriver instance
     */
    public GoogleFirstSearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Creates list of search results: scrolls all search results and adds text from each card title to the search results list
     * @return the list of search results
     */
    public List<String> getResults(){
        waitUntilElementIsVisible(resutlsNumber,10);
        List<String> resultsStringList = new ArrayList();
        for (WebElement result : searchResults) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", result);
            String cardTitle = result.getText().toLowerCase();
            resultsStringList.add(cardTitle);
        }
        return resultsStringList;
    }

    /**
     * Scrolls down the page  and clicks on the link to open next page
     * @return  next page with Search results
     */
    public GoogleSecondSearchResultPage openNextPage(){
        waitUntilElementIsVisible(resutlsNumber,10);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", nextPageLink);
        nextPageLink.click();
        return new GoogleSecondSearchResultPage(driver);
    }
}