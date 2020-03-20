package mobile.lib.ui.devices;

import mobile.lib.ui.MainPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DeviceFavoritePage extends MainPage {

    protected static String
            MOVIES_SECTION,
            TV_SECTION,
            ELEMENTS;

    public DeviceFavoritePage(RemoteWebDriver driver) {
        super(driver);
    }

    public DeviceFavoritePage openSectionMovies(){

        return this;
    }

    public DeviceFavoritePage openSectionTvShows(){
        waitForElementAndClick(TV_SECTION, "Element 'TV_SECTION' not exists", 5);

        return this;
    }

    public int getFavoritesCount(){
        return getAmountOfElements(ELEMENTS);
    }
}
