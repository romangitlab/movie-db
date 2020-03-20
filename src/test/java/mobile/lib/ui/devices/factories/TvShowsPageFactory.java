package mobile.lib.ui.devices.factories;

import mobile.lib.Platform;
import mobile.lib.ui.devices.DeviceTvShowsPage;
import mobile.lib.ui.devices.android.AndroidTvShowsPage;
import mobile.lib.ui.devices.ios.iOSTvShowsPage;
import org.openqa.selenium.remote.RemoteWebDriver;

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
