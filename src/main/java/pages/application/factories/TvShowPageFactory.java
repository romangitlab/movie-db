package pages.application.factories;

import core.application.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.DeviceTvShowPage;
import pages.application.android.*;
import pages.application.ios.*;

public class TvShowPageFactory {

    public static DeviceTvShowPage get(RemoteWebDriver driver) {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidTvShowPage(driver);
        } else  if(Platform.getInstance().isIOS()) {
            return new iOSTvShowPage(driver);
        } else {
            return new AndroidTvShowPage(driver);
        }
    }
}
