package pages.application.factories;

import core.application.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.DeviceMoviesPage;
import pages.application.android.*;
import pages.application.ios.*;

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
