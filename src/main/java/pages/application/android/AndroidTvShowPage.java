package pages.application.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.DeviceTvShowPage;

public class AndroidTvShowPage extends DeviceTvShowPage {

    static {
        NOW_PLAYING_MOVIE_BTN = "xpath://android.widget.ImageView[@content-desc='Image view backdrop desc'][1]";
        BACK_BTN = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        FAVORITE_BTN = "id:com.csovan.themoviedb:id/action_favorite";
    }

    public AndroidTvShowPage(RemoteWebDriver driver) {
        super(driver);
    }
}
