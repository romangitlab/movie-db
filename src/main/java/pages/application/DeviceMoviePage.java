package pages.application;

import helpers.AppHelper;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.factories.HomePageFactory;

public class DeviceMoviePage extends AppHelper {

    protected static String
            NOW_PLAYING_MOVIE_BTN,
            BACK_BTN,
            FAVORITE_BTN;

    public DeviceMoviePage(RemoteWebDriver driver) {
        super(driver);
    }

    public DeviceHomePage clickBackToHomePage(){
        clickAtElement(BACK_BTN, "Element 'BACK_BTN' not exists.", 5);

        return HomePageFactory.get(driver);
    }


    public DeviceMoviePage addToFavorite() {
        clickAtElement(FAVORITE_BTN, "Element 'FAVORITE_BTN' not exists.", 5);

        return this;
    }
}
