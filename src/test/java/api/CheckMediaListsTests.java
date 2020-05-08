package api;

import constants.Category;
import constants.MediaType;
import core.Logging;
import model.Media;
import model.MediaData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class CheckMediaListsTests extends Logging {

    @AfterTest
    public void afterTest() {
        MediaApi.deleteAllPlayLists();
    }

    @Test
    public void apiCreatePlayListTest(){
        String playList = MediaApi.createRandomPlayList();

        assertThat("'Play list' is created.",
                playList,  is(not(equalTo(""))));
    }

    @Test(priority = 0)
    public void apiGetDetailsPlayListTest(){
        String playList = MediaApi.createRandomPlayList();
        Media mediaList = MediaApi.getCreatedPlayList(playList, false);
        MediaApi.createRandomPlayList();
        MediaApi.createRandomPlayList();
        Media mediaLists = MediaApi.getCreatedPlayList("", true);

        assertThat("Got 'Play list' details.",
                mediaList.iterator().next().getDescription(),  containsString("Random list"));
        assertThat("Got more than one 'Play list'", mediaLists.size()>1);
    }

    @Test
    public void apiClearAllMediaFromListsTest(){
        String playList = MediaApi.createRandomPlayList();
        MediaApi.addRandomMediaToPlayList(MediaType.MOVIE, Category.POPULAR, playList);
        MediaApi.addRandomMediaToPlayList(MediaType.TVSHOW, Category.POPULAR, playList);
        MediaApi.clearAllMediaFromPlayList(playList);
        Media mediaList = MediaApi.getCreatedPlayList(playList, false);

        assertThat("'Play list' not empty.",
                mediaList.iterator().next().getItems(),  is((empty())));
    }

    @Test
    public void apiDeletePlayListTest(){
        String playList = MediaApi.createRandomPlayList();
        MediaApi.deletePlayList(playList);
        Media mediaList = MediaApi.getCreatedPlayList(playList, false);

        assertThat("'Play list' is deleted.",
                mediaList.iterator().next().getResponse(), containsString("The resource you requested could not be found."));
    }

    @Test
    public void apiAddMovieToPlayListTest(){
        String playList = MediaApi.createRandomPlayList();
        MediaData mediaData = MediaApi.addRandomMediaToPlayList(MediaType.MOVIE, Category.POPULAR, playList);
        Media mediaList = MediaApi.getCreatedPlayList(playList, false);

        assertThat("'Play list' not empty.",
                mediaList.iterator().next().getItems(),  is(not((empty()))));
        assertThat("'Play list' has media.",
                mediaList.iterator().next().getItems().get(0).getAsJsonObject().get("id").toString(),  equalTo(mediaData.getId()));
    }

    @Test
    public void apiAddTvShowToPlayListTest(){
        String playList = MediaApi.createRandomPlayList();
        MediaData mediaData = MediaApi.addRandomMediaToPlayList(MediaType.TVSHOW, Category.POPULAR, playList);
        Media mediaList = MediaApi.getCreatedPlayList(playList, false);

        assertThat("'Play list' not empty.",
                mediaList.iterator().next().getItems(),  is(not((empty()))));
        assertThat("'Play list' has media.",
                mediaList.iterator().next().getItems().get(0).getAsJsonObject().get("id").toString(),  equalTo(mediaData.getId()));
    }

    @Test
    public void apiRemoveTvShowFromPlayListTest(){
        String playList = MediaApi.createRandomPlayList();
        MediaData addedMedia = MediaApi.addRandomMediaToPlayList(MediaType.TVSHOW, Category.POPULAR, playList);
        MediaData removedMedia = MediaApi.removeRandomMediaFromPlayList(addedMedia, playList);
        Media mediaList = MediaApi.getCreatedPlayList(playList, false);

        assertThat("TvShow is removed from play list.",
                removedMedia.getResponse(), containsString("the item/record was deleted successfully"));
        assertThat("'Play list' has no added TvShow.",
                mediaList.iterator().next().getItems(),  empty());
    }

    @Test
    public void apiRemoveMovieFromPlayListTest(){
        String playList = MediaApi.createRandomPlayList();
        MediaData addedMedia = MediaApi.addRandomMediaToPlayList(MediaType.MOVIE, Category.TOP, playList);
        MediaData removedMedia = MediaApi.removeRandomMediaFromPlayList(addedMedia, playList);
        Media mediaList = MediaApi.getCreatedPlayList(playList, false);

        assertThat("Movie is removed from play list.",
                removedMedia.getResponse(), containsString("the item/record was deleted successfully"));
        assertThat("'Play list' has no added movie.",
                mediaList.iterator().next().getItems(),  empty());
    }
}
