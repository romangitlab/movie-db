package api;

import constants.Category;
import constants.MediaType;
import constants.Page;
import core.Logging;
import model.MediaData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddTvShowToWatchlistTests extends Logging {

    @AfterTest()
    public void afterTest() {
        if(MediaApi.getMediaFrom(MediaType.TVSHOW, Page.WATCHLIST).size() != 0){
            MediaApi.removeAllMediaFrom(MediaType.TVSHOW, Page.WATCHLIST);
        }
    }

    @Test
    public void apiAddingMovieToFavoriteTest(){
        model.Media beforeMedia = MediaApi.getMediaFrom(MediaType.TVSHOW, Page.WATCHLIST);
        MediaData mediaData = MediaApi.addRandomMediaTo(MediaType.TVSHOW, Page.WATCHLIST, Category.TOP);
        model.Media afterMedia = MediaApi.getMediaFrom(MediaType.TVSHOW, Page.WATCHLIST);

        assertThat("",
                afterMedia, equalTo(beforeMedia.withAdded(mediaData)));
    }
}
