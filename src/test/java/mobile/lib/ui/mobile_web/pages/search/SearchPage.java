package mobile.lib.ui.mobile_web.pages.search;

import mobile.lib.ui.MainPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPage extends MainPage {

    protected static String
            SEARCH_INPUT = "css:input#search_v4",
            SEARCH_RESULT = "xpath://a[contains(@data-media-type,'movie')][contains(text(),'{SUBSTRING}')]",
            SEARCH_RESULT_ELEMENT = "css:h2#movie_results+div.results.flex>div";


    public SearchPage(RemoteWebDriver driver) {
        super(driver);
        driver.get(baseUrl + "search");
    }

    public void typeSeachText(String search_line) {
        waitForElementAndClick(SEARCH_INPUT, "Cannot find search element", 5);
        waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot type into search", 5);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        waitForElementPresent(search_result_xpath, "Cannot find search result: " + substring);
    }

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT.replace("{SUBSTRING}", substring);
    }

    public int getAmountOfFoundMovies() {
        return getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }
}
