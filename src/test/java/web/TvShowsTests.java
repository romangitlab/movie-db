package web;

import api.MediaApi;
import core.web.TestBase;
import model.Media;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.web.Login.LoginPage;
import pages.web.Media.MediaItemPage;
import pages.web.Media.MediaPage;
import pages.web.Profile.ProfileFavoritesPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TvShowsTests extends TestBase {

    @AfterTest()
    public void afterTest() {
        if(MediaApi.getMediaFromFavorites("tv").size() != 0){
            MediaApi.removeAllMediaFromFavorites("tv");
        }
    }

    @Test
    public void webAddingTvShowToFavoriteTest(){
        new LoginPage().login();
        ProfileFavoritesPage profileFavoritesPage = new ProfileFavoritesPage("tv");
        Media mediaDataBefore = profileFavoritesPage.getFavoriteList();
        int сountBefore = profileFavoritesPage.getFavoritesCount();
        MediaPage mediaPage = new MediaPage("tv");
        MediaItemPage mediaItemPage = mediaPage.openRandomMedia().setMediaData();
        mediaItemPage.addToFavorites();
        profileFavoritesPage.openFavoritesPage("tv");
        Media mediaDataAfter = profileFavoritesPage.getFavoriteList();
        int сountAfter = profileFavoritesPage.getFavoritesCount();

        assertThat("",
                сountAfter, equalTo(сountBefore + 1));
        assertThat("",
                mediaDataAfter, equalTo(mediaDataBefore.withAdded(mediaItemPage.getMediaData())));
    }
}
