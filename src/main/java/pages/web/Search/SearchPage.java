package pages.web.Search;

import helpers.WebHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends WebHelper {

    Logger logger = LoggerFactory.getLogger(SearchPage.class);
    private String searchPath = "#search_form input[name='query']";

    public SearchPage(String searchText) {
        logger.info("Run: SearchPage()");

        openSearchPage();
        search(searchText);
    }

    public SearchPage(String searchText, String mediaType) {
        openSearchPage();
        search(searchText, mediaType);
    }

    public SearchPage openSearchPage(){
        logger.info("Run: openSearchPage()");

        webDriver.get(getProductWebAddress() + "search");

        return this;
    }

    public SearchPage search(String searchText){
        logger.info("Run: search()");

        type(By.cssSelector(searchPath), searchText, Keys.ENTER);

        return this;
    }

    public SearchPage search(String searchText, String mediaType){
        logger.info("Run: search()");

        type(By.cssSelector(searchPath), searchText, Keys.ENTER);

        if (mediaType.equals("movie")) {
            clickAtElement(By.cssSelector("a#movie"));
        } else if(mediaType.equals("tv")){
            clickAtElement(By.cssSelector("a#tv"));
        } else {
            clickAtElement(By.cssSelector("a#movie"));
        }

        return this;
    }

    public int getSearchResultCount() {
        logger.info("Run: getSearchResultCount()");

        return getSearchResults().size();
    }

    public String searchResult() {
        logger.info("Run: searchResult()");

        return getSearchResults().get(0).getText();
    }

    private ArrayList<WebElement> getSearchResults() {
        logger.info("Run: getSearchResults()");

        ArrayList<WebElement> searchResult = new ArrayList<WebElement>();
        List<WebElement> searchElements = webDriver.findElements(By.cssSelector("div.results.flex>div"));

        searchElements.stream().map((element) -> searchResult.add(element)).collect(Collectors.toList());

        return searchResult;
    }
}
