package mobile.lib.ui.devices.factories;

import mobile.lib.Platform;
import mobile.lib.ui.devices.DeviceTvShowPage;
import mobile.lib.ui.devices.android.AndroidTvShowPage;
import mobile.lib.ui.devices.ios.iOSTvShowPage;
import org.openqa.selenium.remote.RemoteWebDriver;

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
