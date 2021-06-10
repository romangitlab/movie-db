package web;

import api.MediaApi;
import constants.MediaType;
import constants.Page;
import core.web.TestBase;
import model.Media;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.web.Login.LoginPage;
import pages.web.Media.MediaItemPage;
import pages.web.Media.MediaPage;
import pages.web.Profile.ProfileFavoritesPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class addTvShowToFavoriteTests extends TestBase {

    int amountBefore = 0;
    Media mediaDataBefore = new Media();

    @BeforeTest()
    public void beforeTest() {
        if(MediaApi.getMediaFrom(MediaType.TVSHOW, Page.FAVORITE).size() != 0){
            MediaApi.removeAllMediaFrom(MediaType.TVSHOW, Page.FAVORITE);
        }
    }

    @AfterTest()
    public void afterTest() {
        if(MediaApi.getMediaFrom(MediaType.TVSHOW, Page.FAVORITE).size() != 0){
            MediaApi.removeAllMediaFrom(MediaType.TVSHOW, Page.FAVORITE);
        }
    }

    @Test
    public void webAddingTvShowToFavoriteTest(){
        new LoginPage().login();
        MediaPage mediaPage = new MediaPage("tv");
        MediaItemPage mediaItemPage = mediaPage.openRandomMedia().setMediaData();
        mediaItemPage.addToFavorites();
        ProfileFavoritesPage profileFavoritesPage = new ProfileFavoritesPage("tv");
        Media mediaDataAfter = profileFavoritesPage.getFavoriteList();
        int amountAfter = profileFavoritesPage.getFavoritesCount();

        assertThat("",
                amountAfter, equalTo(amountBefore+1));
        assertThat("",
                mediaDataAfter, equalTo(mediaDataBefore.withAdded(mediaItemPage.getMediaData())));
    }
}
