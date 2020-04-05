package pages.application.factories;

import core.application.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.DeviceFavoritePage;
import pages.application.android.AndroidFavoritePage;
import pages.application.ios.iOSFavoritePage;

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
