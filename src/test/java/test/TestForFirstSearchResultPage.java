package test;
import org.testng.Assert;
import org.testng.annotations.*;
import page.GoogleFirstSearchResultPage;
import page.GoogleMainPage;
import page.GoogleFirstSearchResultPage;
import java.util.List;

public class TestForFirstSearchResultPage extends GoogleBaseTest{

    /**
     * Test that verifies basic Search by Specific Search term on the firs page with search results
     * verify that each search result has "Selenium" word in it
     * verify number of search results
     */
    @Test
    public void searchTestOnFirstPage(){
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        GoogleFirstSearchResultPage firstSearchResultsPage = mainPage.searchForTerm("Selenium");
        List<String> results = firstSearchResultsPage.getResults();

        Assert.assertEquals(results.size(), 10, "Number of results is wrong");
        for(String result: results) {
            Assert.assertTrue(result.toLowerCase().contains("selenium"),
                    "Searchterm "+"'Selenium'"+ " not found in card");
        }
    }
}