package desktop.ui.pages.Profile;

import desktop.ui.base.HelperBase;
import org.openqa.selenium.By;

public class ProfileCommonPage extends HelperBase {

    public int getFavoritesCount() {
        return webDriver.findElements(By.cssSelector(".results_page>.card")).size();
    }
}
