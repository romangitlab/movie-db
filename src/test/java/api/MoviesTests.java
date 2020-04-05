package api;

import model.Media;
import model.MediaData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoviesTests {

    @AfterTest()
    public void afterTest() {
        if(MediaApi.getMediaFromFavorites("movie").size() != 0){
            MediaApi.removeAllMediaFromFavorites("movie");
        }
    }

    @Test
    public void apiAddingMovieToFavoriteTest(){
        Media beforeMedia = MediaApi.getMediaFromFavorites("movie");
        MediaData mediaData = MediaApi.addRandomMediaToFavorite("movie");
        Media afterMedia = MediaApi.getMediaFromFavorites("movie");

        assertThat("",
                afterMedia, equalTo(beforeMedia.withAdded(mediaData)));
    }
}
