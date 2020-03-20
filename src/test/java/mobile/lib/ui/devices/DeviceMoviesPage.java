package mobile.lib.ui.devices;

import mobile.lib.ui.MainPage;
import mobile.lib.ui.devices.factories.MoviePageFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DeviceMoviesPage extends MainPage {

    protected static String
            NOW_PLAYING_MOVIE_BTN;

    public DeviceMoviesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public DeviceMoviePage openNowPlayingMovie(){
        waitForElementAndClick(NOW_PLAYING_MOVIE_BTN, "Element 'NOW_PLAYING_MOVIE_BTN' not exists.", 5);

        return MoviePageFactory.get(driver);
    }
}
