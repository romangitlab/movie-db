package pages.application;

import helpers.AppHelper;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DeviceSearchPage extends AppHelper {

    protected static String
            SEARCH_BTN,
            SEARCH_INPUT,
            SEARCH_RESULT;

    public DeviceSearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void typeSeachText(String search_line) {
        clickAtElement(SEARCH_BTN, "Cannot find 'SEARCH_BTN' element", 5);
        sendKeys(SEARCH_INPUT, search_line, "Cannot find 'SEARCH_INPUT' element", 5);
    }

    public String getSearchResult() {
        return waitForElementPresent(SEARCH_RESULT, "Cannot find 'SEARCH_RESULT' element", 5).getText();
    }

    public int getAmountOfSearchResult() {
        return getAmountOfElements(SEARCH_RESULT);
    }
}
