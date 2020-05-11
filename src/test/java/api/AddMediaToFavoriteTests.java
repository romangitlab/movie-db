package api;

import constants.Category;
import constants.MediaType;
import constants.Page;
import core.Logging;
import model.Media;
import model.MediaData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddMediaToFavoriteTests extends Logging {

    @AfterTest()
    public void afterTest() {
        if(MediaApi.getMediaFrom(MediaType.MOVIE, Page.FAVORITE).size() != 0){
            MediaApi.removeAllMediaFrom(MediaType.MOVIE, Page.FAVORITE);
        }

        if(MediaApi.getMediaFrom(MediaType.TVSHOW, Page.FAVORITE).size() != 0){
            MediaApi.removeAllMediaFrom(MediaType.TVSHOW, Page.FAVORITE);
        }
    }

    @Test
    public void apiAddingMovieToFavoriteTest(){
        model.Media beforeMedia = MediaApi.getMediaFrom(MediaType.MOVIE, Page.FAVORITE);
        MediaData mediaData = MediaApi.addRandomMediaTo(MediaType.MOVIE, Page.FAVORITE, Category.POPULAR);
        model.Media afterMedia = MediaApi.getMediaFrom(MediaType.MOVIE, Page.FAVORITE);

        assertThat("",
                afterMedia, equalTo(beforeMedia.withAdded(mediaData)));
    }

    @Test
    public void apiAddingTvShowsToFavoriteTest(){
        Media beforeMedia = MediaApi.getMediaFrom(MediaType.TVSHOW, Page.FAVORITE);
        MediaData mediaData = MediaApi.addRandomMediaTo(MediaType.TVSHOW, Page.FAVORITE, Category.POPULAR);
        Media afterMedia = MediaApi.getMediaFrom(MediaType.TVSHOW, Page.FAVORITE);

        assertThat("",
                afterMedia, equalTo(beforeMedia.withAdded(mediaData)));
    }
}
