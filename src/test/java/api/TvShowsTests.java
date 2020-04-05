package api;

import model.Media;
import model.MediaData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TvShowsTests {

    @AfterTest()
    public void afterTest() {
        if(MediaApi.getMediaFromFavorites("tv").size() != 0){
            MediaApi.removeAllMediaFromFavorites("tv");
        }
    }

    @Test
    public void apiAddingTvShowsToFavoriteTest(){
        Media beforeMedia = MediaApi.getMediaFromFavorites("tv");
        MediaData mediaData = MediaApi.addRandomMediaToFavorite("tv");
        Media afterMedia = MediaApi.getMediaFromFavorites("tv");

        assertThat("",
                afterMedia, equalTo(beforeMedia.withAdded(mediaData)));
    }
}
