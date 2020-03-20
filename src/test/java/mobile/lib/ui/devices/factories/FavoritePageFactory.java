package mobile.lib.ui.devices.factories;

import mobile.lib.Platform;
import mobile.lib.ui.devices.DeviceFavoritePage;
import mobile.lib.ui.devices.android.AndroidFavoritePage;
import mobile.lib.ui.devices.ios.iOSFavoritePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FavoritePageFactory {

    public static DeviceFavoritePage get(RemoteWebDriver driver) {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidFavoritePage(driver);
        } else if(Platform.getInstance().isIOS()) {
            return new iOSFavoritePage(driver);
        } else {
            return new AndroidFavoritePage(driver);
        }
    }
}
