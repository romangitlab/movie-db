package pages.application.factories;

import core.application.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.DeviceSearchPage;
import pages.application.android.*;
import pages.application.ios.*;

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
