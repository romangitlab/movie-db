package mobile.lib.ui.devices.factories;

import mobile.lib.Platform;
import mobile.lib.ui.devices.DeviceMoviesPage;
import mobile.lib.ui.devices.android.AndroidMoviesPage;
import mobile.lib.ui.devices.ios.iOSMoviesPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MoviesPageFactory {

    public static DeviceMoviesPage get(RemoteWebDriver driver) {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidMoviesPage(driver);
        } else if(Platform.getInstance().isIOS()) {
            return new iOSMoviesPage(driver);
        } else {
            return new AndroidMoviesPage(driver);
        }
    }
}
