package desktop.ui.tests;

import desktop.rest.api.MoviesApi;
import desktop.ui.base.TestBase;
import desktop.ui.pages.Login.LoginPage;
import desktop.ui.pages.Media.Movies.MoviePage;
import desktop.ui.pages.Media.Movies.MoviesPage;
import desktop.ui.pages.Profile.ProfileFavoritesPage;
import model.MoviesData.Movies;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoviesTests extends TestBase {

    ProfileFavoritesPage profileFavoritesPage;
    MoviePage moviePage;
    MoviesPage moviesPage;

    @BeforeTest()
    public void beforeTest() {
        new LoginPage().login();
    }

    @AfterTest()
    public void afterTest() {
        if(MoviesApi.getMoviesFromFavorites().size() != 0){
            MoviesApi.removeAllMoviesFromFavorites();
        }
    }

    @Test
    public void checkDesktopAddingMovieToFavoriteTest(){
        profileFavoritesPage = new ProfileFavoritesPage("movies");
        Movies movieDataBefore = profileFavoritesPage.getMoviesFavoriteList();
        int moviesCountBefore = profileFavoritesPage.getFavoritesCount();
        moviesPage = new MoviesPage();
        moviePage = moviesPage.openRandomMovie().setMovieData();
        moviePage.addToFavorites();
        profileFavoritesPage.openFavoritesPage("movies");
        Movies movieDataAfter = profileFavoritesPage.getMoviesFavoriteList();
        int moviesCountAfter = profileFavoritesPage.getFavoritesCount();

        assertThat("", moviesCountAfter, equalTo(moviesCountBefore + 1));
        assertThat("", movieDataAfter, equalTo(movieDataBefore.withAdded(moviePage.getMovieData())));
    }
}
