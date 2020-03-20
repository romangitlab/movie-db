package mobile.tests.android;

import mobile.lib.CoreTest;
import mobile.lib.ui.devices.DeviceFavoritePage;
import mobile.lib.ui.devices.DeviceHomePage;
import mobile.lib.ui.devices.DeviceTvShowPage;
import mobile.lib.ui.devices.DeviceTvShowsPage;
import mobile.lib.ui.devices.factories.HomePageFactory;
import org.junit.Test;

public class AndroidTvShowsTests extends CoreTest {

    @Test
    public void testAddTOFavoriteTvShow() {
        DeviceHomePage homePage = HomePageFactory.get(driver);
        DeviceTvShowsPage tvShowsPage = homePage.openTvShowsPage();
        DeviceTvShowPage tvShowPage = tvShowsPage.openNowPlayingMovie().addToFavorite();
        tvShowPage.clickBackToHomePage();
        DeviceFavoritePage favoritePage = homePage.openFavoritesPage();
        favoritePage.openSectionTvShows();

        assertTrue(
                "No favorites found",
                favoritePage.getFavoritesCount() > 0
        );
      }
}
