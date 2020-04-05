package pages.application.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.DeviceMoviesPage;

public class AndroidMoviesPage extends DeviceMoviesPage {

    static {
        NOW_PLAYING_MOVIE_BTN = "xpath://android.widget.ImageView[@content-desc='Image view backdrop desc'][1]";
    }

    public AndroidMoviesPage(RemoteWebDriver driver) {
        super(driver);
    }
}
