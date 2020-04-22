package api;

import constants.Category;
import constants.Type;
import core.Logging;
import model.MediaData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddMovieToFavoriteTests extends Logging {

    @AfterTest()
    public void afterTest() {
        if(MediaApi.getMediaFromFavorites(Type.MOVIE).size() != 0){
            MediaApi.removeAllMediaFromFavorites(Type.MOVIE);
        }
    }

    @Test
    public void apiAddingMovieToFavoriteTest(){
        model.Media beforeMedia = MediaApi.getMediaFromFavorites(Type.MOVIE);
        MediaData mediaData = MediaApi.addRandomMediaToFavorite(Type.MOVIE, Category.POPULAR);
        model.Media afterMedia = MediaApi.getMediaFromFavorites(Type.MOVIE);

        assertThat("",
                afterMedia, equalTo(beforeMedia.withAdded(mediaData)));
    }
}
