package pages.application.factories;

import core.application.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.DeviceTvShowsPage;
import pages.application.android.*;
import pages.application.ios.*;

public class TvShowsPageFactory {

    public static DeviceTvShowsPage get(RemoteWebDriver driver) {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidTvShowsPage(driver);
        } else if(Platform.getInstance().isIOS()) {
            return new iOSTvShowsPage(driver);
        } else {
            return new AndroidTvShowsPage(driver);
        }
    }
}
