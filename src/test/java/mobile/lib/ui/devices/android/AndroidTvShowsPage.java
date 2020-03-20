package mobile.lib.ui.devices.android;

import mobile.lib.ui.devices.DeviceTvShowsPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidTvShowsPage extends DeviceTvShowsPage {

    static {
        NOW_PLAYING_BTN = "xpath://android.widget.ImageView[@content-desc='Image view backdrop desc'][1]";
    }

    public AndroidTvShowsPage(RemoteWebDriver driver) {
        super(driver);
    }
}
