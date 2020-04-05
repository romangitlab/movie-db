package pages.application;

import helpers.AppHelper;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.factories.TvShowPageFactory;

public class DeviceTvShowsPage extends AppHelper {

    protected static String
            NOW_PLAYING_BTN;

    public DeviceTvShowsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public DeviceTvShowPage openNowPlayingMovie(){
        clickAtElement(NOW_PLAYING_BTN, "Element 'NOW_PLAYING_MOVIE_BTN' not exists.", 5);

        return TvShowPageFactory.get(driver);
    }
}
