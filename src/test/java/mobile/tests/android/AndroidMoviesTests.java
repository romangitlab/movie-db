package mobile.tests.android;

import mobile.lib.CoreTest;
import mobile.lib.ui.devices.DeviceFavoritePage;
import mobile.lib.ui.devices.DeviceHomePage;
import mobile.lib.ui.devices.DeviceMoviePage;
import mobile.lib.ui.devices.DeviceMoviesPage;
import mobile.lib.ui.devices.factories.HomePageFactory;
import org.junit.Test;

public class AndroidMoviesTests extends CoreTest {

    @Test
    public void testAddTOFavoriteMovie() {
        DeviceHomePage homePage = HomePageFactory.get(driver);
        DeviceMoviesPage moviesPage = homePage.openMoviesPage();
        DeviceMoviePage moviePage = moviesPage.openNowPlayingMovie().addToFavorite();
        moviePage.clickBackToHomePage();
        DeviceFavoritePage favoritePage = homePage.openFavoritesPage();

        assertTrue(
                "No favorites found",
                favoritePage.getFavoritesCount() > 0
        );
      }
}
