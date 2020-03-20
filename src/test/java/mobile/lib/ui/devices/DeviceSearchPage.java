package mobile.lib.ui.devices;

import mobile.lib.ui.MainPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DeviceSearchPage extends MainPage {

    protected static String
            SEARCH_BTN,
            SEARCH_INPUT,
            SEARCH_RESULT;

    public DeviceSearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void typeSeachText(String search_line) {
        waitForElementAndClick(SEARCH_BTN, "Cannot find 'SEARCH_BTN' element", 5);
        waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find 'SEARCH_INPUT' element", 5);
    }

    public String getSearchResult() {
        return waitForElementPresent(SEARCH_RESULT, "Cannot find 'SEARCH_RESULT' element").getText();
    }

    public int getAmountOfSearchResult() {
        return getAmountOfElements(SEARCH_RESULT);
    }
}
