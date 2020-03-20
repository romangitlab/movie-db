package mobile.tests.android;

import mobile.lib.CoreTest;
import mobile.lib.ui.devices.DeviceSearchPage;
import mobile.lib.ui.devices.factories.SearchPageFactory;
import org.junit.Test;

public class AndroidSearchTests extends CoreTest {

    @Test
    public void testAndroidSearch() {
        DeviceSearchPage searchPage = SearchPageFactory.get(driver);
        searchPage.typeSeachText("Bloodshot");

        assertTrue("Search has empty result",
                   searchPage.getSearchResult().contains("Bloodshot")
        );
    }

    @Test
    public void testAndroidAmountOfEmptySearch() {
        DeviceSearchPage searchPage = SearchPageFactory.get(driver);
        searchPage.typeSeachText("@!@!@!");

        assertEquals("Search should be empty",
                0,
                searchPage.getAmountOfSearchResult()
        );
    }
}
