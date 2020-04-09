package pages.application.factories;

import core.application.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.DeviceMoviePage;
import pages.application.android.*;

public class MoviePageFactory {

    public static DeviceMoviePage get(RemoteWebDriver driver) {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidMoviePage(driver);
        } else  if(Platform.getInstance().isAndroid()) {
            return new AndroidMoviePage(driver);
        } else {
            return new AndroidMoviePage(driver);
        }
    }
}
