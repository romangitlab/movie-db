package mobile.tests.mobile_web;

import desktop.rest.api.TvShowsApi;
import mobile.lib.CoreTest;
import mobile.lib.ui.mobile_web.pages.login.AuthorizationPage;
import mobile.lib.ui.mobile_web.pages.media.TvShowPage;
import mobile.lib.ui.mobile_web.pages.media.TvShowsPage;
import model.TvShowData.TvShow;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TvShowsTests extends CoreTest {

    @After
    public void tearDown() {
        if(TvShowsApi.getTvShowsFromFavorites().size() != 0){
            TvShowsApi.removeAllTvShowsFromFavorites();
        }
    }

    @Test
    public void testMovies() {
        TvShow beforeTvShows = TvShowsApi.getTvShowsFromFavorites();
        int beforeTvShowsCount = TvShowsApi.getTvShowsFromFavorites().size();

        new AuthorizationPage(driver).login();
        TvShowsPage tvShowsPage = new TvShowsPage(driver);
        TvShowPage tvshowPage = tvShowsPage.openRandomTv().setTvShowData();
        tvshowPage.acceptCookiePolicy();
        tvshowPage.addToFavorites();

        TvShow afterTvShows = TvShowsApi.getTvShowsFromFavorites();
        int afterTvShowsCount = TvShowsApi.getTvShowsFromFavorites().size();

        assertThat("", afterTvShowsCount, equalTo(beforeTvShowsCount + 1));
        assertThat("", afterTvShows, equalTo(beforeTvShows.withAdded(tvshowPage.getTvShowData())));
    }
}
