package web;

import core.web.TestBase;
import org.testng.annotations.Test;
import pages.web.Login.LoginPage;
import pages.web.Media.MediaPage;
import pages.web.Search.SearchPage;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class searchMediaTests extends TestBase {

    @Test
    public void webSearchMovieTest() {
        new LoginPage().login();
        MediaPage mediaPage = new MediaPage("movie");
        SearchPage searchPage = mediaPage.search("Joker", "movie");

        assertThat("",
                searchPage.getSearchResultCount(), is(not(0)));
        assertThat("",
                searchPage.searchResult(), containsString("Joker"));
    }

    @Test
    public void webSearchTvShowTest() {
        new LoginPage().login();
        MediaPage mediaPage = new MediaPage("tv");
        SearchPage searchPage = mediaPage.search("Arrow", "tv");

        assertThat("",
                searchPage.getSearchResultCount(), is(not(0)));
        assertThat("",
                searchPage.searchResult(), containsString("Arrow"));
    }

    @Test
    public void webEmptySearchTest() {
        new LoginPage().login();
        MediaPage mediaPage = new MediaPage("movie");
        SearchPage searchPage = mediaPage.search("@!@!@!");

        assertThat("",
                searchPage.getSearchResultCount(), is(0));
    }
}
