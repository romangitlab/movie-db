package mobile.lib.ui.devices.factories;

import mobile.lib.Platform;
import mobile.lib.ui.devices.DeviceSearchPage;
import mobile.lib.ui.devices.android.AndroidSearchPage;
import mobile.lib.ui.devices.ios.iOSSearchPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageFactory {

    public static DeviceSearchPage get(RemoteWebDriver driver) {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidSearchPage(driver);
        } else  if(Platform.getInstance().isAndroid()) {
            return new iOSSearchPage(driver);
        } else {
            return new AndroidSearchPage(driver);
        }
    }
}
