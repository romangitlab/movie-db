package mobile.lib.ui.devices.android;

import mobile.lib.ui.devices.DeviceSearchPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPage extends DeviceSearchPage {

    static {
        SEARCH_BTN = "id:com.csovan.themoviedb:id/action_search";
        SEARCH_INPUT = "id:com.csovan.themoviedb:id/search_src_text";
        SEARCH_RESULT = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]";
    }

    public AndroidSearchPage(RemoteWebDriver driver) {
        super(driver);
    }
}
