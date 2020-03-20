package mobile.lib.ui.devices;

import mobile.lib.ui.MainPage;
import mobile.lib.ui.devices.factories.TvShowPageFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DeviceTvShowsPage extends MainPage {

    protected static String
            NOW_PLAYING_BTN;

    public DeviceTvShowsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public DeviceTvShowPage openNowPlayingMovie(){
        waitForElementAndClick(NOW_PLAYING_BTN, "Element 'NOW_PLAYING_MOVIE_BTN' not exists.", 5);

        return TvShowPageFactory.get(driver);
    }
}
