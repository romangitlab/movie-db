package mobile.lib.ui.devices.factories;

import mobile.lib.Platform;
import mobile.lib.ui.devices.DeviceMoviePage;
import mobile.lib.ui.devices.android.AndroidMoviePage;
import org.openqa.selenium.remote.RemoteWebDriver;

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
