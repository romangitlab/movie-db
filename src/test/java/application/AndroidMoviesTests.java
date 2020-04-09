package application;

import core.application.TestBase;
import org.junit.Test;
import pages.application.DeviceFavoritePage;
import pages.application.DeviceHomePage;
import pages.application.DeviceMoviePage;
import pages.application.DeviceMoviesPage;
import pages.application.factories.HomePageFactory;

public class AndroidMoviesTests extends TestBase {

    @Test
    public void androidAddingMovieToFavoriteTest() {
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
