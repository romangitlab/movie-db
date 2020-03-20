package mobile.lib.ui.mobile_web.pages.media;

import mobile.lib.Platform;
import mobile.lib.ui.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CommonMediaPage extends MainPage {

    protected static String
            TITLE,
            FAVORITE,
            ACCEPT_COOKIES_BTN;

    public CommonMediaPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void acceptCookiePolicy(){
        if (Platform.getInstance().isMW()) {
            ACCEPT_COOKIES_BTN = "css:p>a.accept";
            waitForElementAndClick(ACCEPT_COOKIES_BTN, "Cannot find path to element", 5);
        }
    }

    public void addToFavorites() {
        WebElement element = waitForElementPresent(FAVORITE, "Cannot find path to 'favorite' element", 5);
        scrollWebPageTo(element);
        waitForElementAndClick(FAVORITE, "Cannot find path to 'favorite' element", 5);
    }

    public void AddToList() {
    }

    public void AddToWatchList() {
    }

    public void Rate() {
    }
}
