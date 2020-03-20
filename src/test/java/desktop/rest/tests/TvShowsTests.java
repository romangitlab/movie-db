package desktop.rest.tests;

import desktop.rest.api.TvShowsApi;
import model.TvShowData.TvShow;
import model.TvShowData.TvShowData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TvShowsTests {

    @AfterTest()
    public void afterTest() {
        if(TvShowsApi.getTvShowsFromFavorites().size() != 0){
            TvShowsApi.removeAllTvShowsFromFavorites();
        }
    }

    @Test
    public void checkAddingTvShowToFavoriteTest(){
        TvShow beforeTvShows = TvShowsApi.getTvShowsFromFavorites();
        TvShowData tvShowData = TvShowsApi.addRandomTvShowToFavorite();
        TvShow afterTvShows = TvShowsApi.getTvShowsFromFavorites();

        assertThat("", afterTvShows, equalTo(beforeTvShows.withAdded(tvShowData)));
    }
}
