package mobile.lib.ui.devices.android;

import mobile.lib.ui.devices.DeviceMoviePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMoviePage extends DeviceMoviePage {

    static {
        NOW_PLAYING_MOVIE_BTN = "xpath://android.widget.ImageView[@content-desc='Image view backdrop desc'][1]";
        BACK_BTN = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        FAVORITE_BTN = "id:com.csovan.themoviedb:id/action_favorite";
    }

    public AndroidMoviePage(RemoteWebDriver driver) {
        super(driver);
    }
}
