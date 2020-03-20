package mobile.lib.ui.devices;

import mobile.lib.ui.MainPage;
import mobile.lib.ui.devices.factories.FavoritePageFactory;
import mobile.lib.ui.devices.factories.MoviesPageFactory;
import mobile.lib.ui.devices.factories.TvShowsPageFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DeviceHomePage extends MainPage {

    protected static String
            NAVIGATION_BTN,
            MOVIES_BTN,
            TV_BTN,
            FAVORITES_BTN;

    public DeviceHomePage(RemoteWebDriver driver) {
        super(driver);
    }

    private void clickAtMenu(){
        waitForElementAndClick(NAVIGATION_BTN, "Element 'NAVIGATION_BTN' not exists", 10);
    }

    private void clickAtMovies(){
        waitForElementAndClick(MOVIES_BTN, "Element 'MOVIES_BTN' not exists", 10);
    }

    private void clickAtTvShows(){
        waitForElementAndClick(TV_BTN, "Element 'TV_BTN' not exists", 10);
    }

    private void clickAtFavorites(){
        waitForElementAndClick(FAVORITES_BTN, "Element 'FAVORITES_BTN' not exists", 10);
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
