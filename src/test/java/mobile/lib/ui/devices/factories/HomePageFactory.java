package mobile.lib.ui.devices.factories;

import mobile.lib.Platform;
import mobile.lib.ui.devices.DeviceHomePage;
import mobile.lib.ui.devices.android.AndroidHomePage;
import mobile.lib.ui.devices.ios.iOSHomePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePageFactory {

    public static DeviceHomePage get(RemoteWebDriver driver) {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidHomePage(driver);
        } else if(Platform.getInstance().isIOS()) {
            return new iOSHomePage(driver);
        } else {
            return new AndroidHomePage(driver);
        }
    }
}
