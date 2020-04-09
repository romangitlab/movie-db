package pages.application.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.DeviceTvShowsPage;

public class AndroidTvShowsPage extends DeviceTvShowsPage {

    static {
        NOW_PLAYING_BTN = "xpath://android.widget.ImageView[@content-desc='Image view backdrop desc'][1]";
    }

    public AndroidTvShowsPage(RemoteWebDriver driver) {
        super(driver);
    }
}
