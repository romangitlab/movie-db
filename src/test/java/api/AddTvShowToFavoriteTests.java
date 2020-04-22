package api;

import constants.Category;
import constants.Type;
import core.Logging;
import model.Media;
import model.MediaData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddTvShowToFavoriteTests extends Logging {

    @AfterTest()
    public void afterTest() {
        if(MediaApi.getMediaFromFavorites(Type.TVSHOW).size() != 0){
            MediaApi.removeAllMediaFromFavorites(Type.TVSHOW);
        }
    }

    @Test
    public void apiAddingTvShowsToFavoriteTest(){
        Media beforeMedia = MediaApi.getMediaFromFavorites(Type.TVSHOW);
        MediaData mediaData = MediaApi.addRandomMediaToFavorite(Type.TVSHOW, Category.POPULAR);
        Media afterMedia = MediaApi.getMediaFromFavorites(Type.TVSHOW);

        assertThat("",
                afterMedia, equalTo(beforeMedia.withAdded(mediaData)));
    }
}
