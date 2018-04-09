package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleMainPage;
import page.GoogleFirstSearchResultPage;
import page.GoogleSecondSearchResultPage;

import java.util.List;

public class TestForSecondSearchResultPage extends GoogleBaseTest {
    /**
     * Test that verifies basic Search by Specific Search term on the second page with search results
     * verify that each search result has "Selenium" word in it
     * verify number of search results
     */
    @Test
    public void searchTestOnSecondPage(){
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        GoogleFirstSearchResultPage searchResultsPage = mainPage.searchForTerm("Selenium");
        GoogleSecondSearchResultPage secondResultsPage = searchResultsPage.openNextPage();
        List<String> results = secondResultsPage.getResults();

        Assert.assertEquals(results.size(), 10, "Number of results is wrong");
        for(String result: results) {
            Assert.assertTrue(result.toLowerCase().contains("selenium"),
                    "Searchterm "+"'Selenium'"+ " not found in cart");
        }
    }
}
