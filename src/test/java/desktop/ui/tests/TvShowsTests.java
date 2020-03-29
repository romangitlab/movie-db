package desktop.ui.tests;

import desktop.rest.api.TvShowsApi;
import desktop.ui.base.TestBase;
import desktop.ui.pages.Login.LoginPage;
import desktop.ui.pages.Media.TvShows.TvShowPage;
import desktop.ui.pages.Media.TvShows.TvShowsPage;
import desktop.ui.pages.Profile.ProfileFavoritesPage;
import model.TvShowData.TvShow;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TvShowsTests extends TestBase {

    ProfileFavoritesPage profileFavoritesPage;
    TvShowsPage tvShowsPage;
    TvShowPage tvShowPage;

    @BeforeTest()
    public void beforeTest() {
        new LoginPage().login();
    }

    @AfterTest()
    public void afterTest() {
        if(TvShowsApi.getTvShowsFromFavorites().size() != 0){
            TvShowsApi.removeAllTvShowsFromFavorites();
        }
    }

    @Test
    public void checkDesktopAddingTvShowToFavoriteTest(){
        profileFavoritesPage = new ProfileFavoritesPage("tv");
        TvShow tvShowDataBefore = profileFavoritesPage.getTvShowFavoriteList();
        int moviesCountBefore = profileFavoritesPage.getFavoritesCount();
        tvShowsPage = new TvShowsPage();
        tvShowPage = tvShowsPage.openRandomTvShow().setTvShowData();
        tvShowPage.addToFavorites();
        profileFavoritesPage.openFavoritesPage("tv");
        TvShow tvShowDataAfter = profileFavoritesPage.getTvShowFavoriteList();
        int moviesCountAfter = profileFavoritesPage.getFavoritesCount();

        assertThat("", moviesCountAfter, equalTo(moviesCountBefore + 1));
        assertThat("", tvShowDataAfter, equalTo(tvShowDataBefore.withAdded(tvShowPage.getTvShowData())));
    }
}
