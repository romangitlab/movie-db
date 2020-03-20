package desktop.ui.pages.Search;

import desktop.ui.base.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends HelperBase {

    private String searchPath = "#search_form input[name='query']";


    public SearchPage() {
        webDriver.get(getProductWebAddress() + "search");
    }

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
            click(By.cssSelector("a#movie"));
        } else if(mediaType.equals("tv")){
            click(By.cssSelector("a#tv"));
        } else {
            click(By.cssSelector("a#movie"));
        }

        return this;
    }

    private ArrayList<WebElement> getSearchResults() {
        ArrayList<WebElement> searchResult = new ArrayList<WebElement>();

        List<WebElement> searchElements = webDriver.findElements(By.cssSelector("div.search_results div.item.poster"));

        for (WebElement result : searchElements) {
            searchResult.add(result);
        }

        return searchResult;
    }

    public int getSearchResultCount() {
        return getSearchResults().size();
    }

    public Boolean SearchResultContains(String searchText) {
        return getSearchResults().get(0).getText().contains(searchText);
    }
}
