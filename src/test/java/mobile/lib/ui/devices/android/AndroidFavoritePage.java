package mobile.lib.ui.devices.android;

import mobile.lib.ui.devices.DeviceFavoritePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidFavoritePage extends DeviceFavoritePage {

    static {
        MOVIES_SECTION = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[1]";
        TV_SECTION = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[2]";
        ELEMENTS = "id:com.csovan.themoviedb:id/constraint_layout_item_card_small";
    }

    public AndroidFavoritePage(RemoteWebDriver driver) {
        super(driver);
    }

}
