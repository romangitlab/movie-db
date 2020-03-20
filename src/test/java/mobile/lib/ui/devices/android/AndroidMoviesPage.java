package mobile.lib.ui.devices.android;

import mobile.lib.ui.devices.DeviceMoviesPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMoviesPage extends DeviceMoviesPage {

    static {
        NOW_PLAYING_MOVIE_BTN = "xpath://android.widget.ImageView[@content-desc='Image view backdrop desc'][1]";
    }

    public AndroidMoviesPage(RemoteWebDriver driver) {
        super(driver);
    }
}
