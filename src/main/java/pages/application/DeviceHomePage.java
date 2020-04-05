package pages.application;

import helpers.AppHelper;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.application.factories.FavoritePageFactory;
import pages.application.factories.MoviesPageFactory;
import pages.application.factories.TvShowsPageFactory;

public class DeviceHomePage extends AppHelper {

    protected static String
            NAVIGATION_BTN,
            MOVIES_BTN,
            TV_BTN,
            FAVORITES_BTN;

    public DeviceHomePage(RemoteWebDriver driver) {
        super(driver);
    }

    private void clickAtMenu(){
        clickAtElement(NAVIGATION_BTN, "Element 'NAVIGATION_BTN' not exists", 10);
    }

    private void clickAtMovies(){
        clickAtElement(MOVIES_BTN, "Element 'MOVIES_BTN' not exists", 10);
    }

    private void clickAtTvShows(){
        clickAtElement(TV_BTN, "Element 'TV_BTN' not exists", 10);
    }

    private void clickAtFavorites(){
        clickAtElement(FAVORITES_BTN, "Element 'FAVORITES_BTN' not exists", 10);
    }

    public DeviceMoviesPage openMoviesPage(){
        clickAtMenu();
        clickAtMovies();

        return MoviesPageFactory.get(driver);
    }

    public DeviceTvShowsPage openTvShowsPage(){
        clickAtMenu();
        clickAtTvShows();

        return TvShowsPageFactory.get(driver);
    }

    public DeviceFavoritePage openFavoritesPage(){
        clickAtMenu();
        clickAtFavorites();

        return FavoritePageFactory.get(driver);
    }
}
