package pages.application;

import helpers.AppHelper;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.factories.MoviePageFactory;

public class DeviceMoviesPage extends AppHelper {

    protected static String
            NOW_PLAYING_MOVIE_BTN;

    public DeviceMoviesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public DeviceMoviePage openNowPlayingMovie(){
        clickAtElement(NOW_PLAYING_MOVIE_BTN, "Element 'NOW_PLAYING_MOVIE_BTN' not exists.", 5);

        return MoviePageFactory.get(driver);
    }
}
