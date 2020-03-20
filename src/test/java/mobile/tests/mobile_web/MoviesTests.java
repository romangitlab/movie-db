package mobile.tests.mobile_web;

import desktop.rest.api.MoviesApi;
import mobile.lib.CoreTest;
import mobile.lib.ui.mobile_web.pages.login.AuthorizationPage;
import mobile.lib.ui.mobile_web.pages.media.MoviePage;
import mobile.lib.ui.mobile_web.pages.media.MoviesPage;
import model.MoviesData.Movies;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MoviesTests extends CoreTest {

    @After
    public void tearDown() {
        if(MoviesApi.getMoviesFromFavorites().size() != 0){
            MoviesApi.removeAllMoviesFromFavorites();
        }
    }

    @Test
    public void testMovies() {
        Movies beforeMovies = MoviesApi.getMoviesFromFavorites();
        int beforeMoviesCount = MoviesApi.getMoviesFromFavorites().size();

        new AuthorizationPage(driver).login();
        MoviesPage moviesPage = new MoviesPage(driver);
        MoviePage moviePage = moviesPage.openRandomMovie().setMovieData();
        moviePage.acceptCookiePolicy();
        moviePage.addToFavorites();

        Movies afterMovies = MoviesApi.getMoviesFromFavorites();
        int afterMoviesCount = MoviesApi.getMoviesFromFavorites().size();

        assertThat("", afterMoviesCount, equalTo(beforeMoviesCount + 1));
        assertThat("", afterMovies, equalTo(beforeMovies.withAdded(moviePage.getMovieData())));
    }
}
