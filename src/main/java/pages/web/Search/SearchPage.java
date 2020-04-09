package pages.web.Search;

import helpers.WebHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends WebHelper {

    private String searchPath = "#search_form input[name='query']";

    public SearchPage(String searchText) {
        openSearchPage();
        search(searchText);
    }

    public SearchPage(String searchText, String mediaType) {
        openSearchPage();
        search(searchText, mediaType);
    }

    public SearchPage openSearchPage(){
        webDriver.get(getProductWebAddress() + "search");

        return this;
    }

    public SearchPage search(String searchText){

        type(By.cssSelector(searchPath), searchText, Keys.ENTER);

        return this;
    }

    public SearchPage search(String searchText, String mediaType){

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
        return getSearchResults().size();
    }

    public String SearchResult() {
        return getSearchResults().get(0).getText();
    }

    private ArrayList<WebElement> getSearchResults() {

        ArrayList<WebElement> searchResult = new ArrayList<WebElement>();
        List<WebElement> searchElements = webDriver.findElements(By.cssSelector("div.results.flex>div"));

        searchElements.stream().map((element) -> searchResult.add(element)).collect(Collectors.toList());

        return searchResult;
    }
}
