package desktop.ui.tests;

import desktop.ui.base.TestBase;
import desktop.ui.pages.Login.LoginPage;
import desktop.ui.pages.Media.Movies.MoviesPage;
import desktop.ui.pages.Search.SearchPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertTrue;

public class SearchTests extends TestBase {

    MoviesPage moviesPage;
    SearchPage searchPage;

    @BeforeTest()
    public void beforeTest() {
        new LoginPage().login();
    }

    @Test
    public void searchMovieTest() {
        moviesPage = new MoviesPage();
        searchPage = moviesPage.search("Joker", "movie");

        assertThat("", searchPage.getSearchResultCount(), is(not(0)));
        assertTrue(searchPage.SearchResultContains("Joker"), "");
    }

    @Test
    public void searchTvShowTest() {
        moviesPage = new MoviesPage();
        searchPage = moviesPage.search("Arrow", "tv");

        assertThat("", searchPage.getSearchResultCount(), is(not(0)));
        assertTrue(searchPage.SearchResultContains("Arrow"), "");
    }

    @Test
    public void emptySearchTest() {
        moviesPage = new MoviesPage();
        searchPage = moviesPage.search("@!@!@!");

        assertThat("", searchPage.getSearchResultCount(), is(0));
    }
}
