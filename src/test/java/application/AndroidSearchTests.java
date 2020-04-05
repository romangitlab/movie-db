package application;

import core.application.TestBase;
import org.junit.Test;
import pages.application.DeviceSearchPage;
import pages.application.factories.SearchPageFactory;

public class AndroidSearchTests extends TestBase {

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
