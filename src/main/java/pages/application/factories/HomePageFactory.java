package pages.application.factories;

import core.application.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.DeviceHomePage;
import pages.application.android.*;
import pages.application.ios.*;

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
