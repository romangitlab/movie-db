package mobile.lib.ui.devices;

import mobile.lib.ui.MainPage;
import mobile.lib.ui.devices.factories.HomePageFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DeviceTvShowPage extends MainPage {

    protected static String
            NOW_PLAYING_MOVIE_BTN,
            BACK_BTN,
            FAVORITE_BTN;

    public DeviceTvShowPage(RemoteWebDriver driver) {
        super(driver);
    }

    public DeviceHomePage clickBackToHomePage(){
        waitForElementAndClick(BACK_BTN, "Element 'BACK_BTN' not exists.", 5);

        return HomePageFactory.get(driver);
    }


    public DeviceTvShowPage addToFavorite() {
        waitForElementAndClick(FAVORITE_BTN, "Element 'FAVORITE_BTN' not exists.", 5);

        return this;
    }
}
