package application;

import core.application.TestBase;
import org.junit.Test;
import pages.application.DeviceFavoritePage;
import pages.application.DeviceHomePage;
import pages.application.DeviceTvShowPage;
import pages.application.DeviceTvShowsPage;
import pages.application.factories.HomePageFactory;

public class AndroidTvShowsTests extends TestBase {

    @Test
    public void androidAddingTvShowsToFavoriteTest() {
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
