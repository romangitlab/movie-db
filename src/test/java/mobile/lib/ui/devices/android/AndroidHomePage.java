package mobile.lib.ui.devices.android;

import mobile.lib.ui.devices.DeviceHomePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidHomePage extends DeviceHomePage {

    static {
        NAVIGATION_BTN = "xpath://android.widget.ImageButton[@content-desc='Open navigation drawer']";
        MOVIES_BTN = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[2]";
        TV_BTN = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[1]/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.TextView";
        FAVORITES_BTN = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.TextView[1]";
    }

    public AndroidHomePage(RemoteWebDriver driver) {
        super(driver);
    }

}
