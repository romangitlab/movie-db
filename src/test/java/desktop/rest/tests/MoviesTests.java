package desktop.rest.tests;

import desktop.rest.api.MoviesApi;
import model.MoviesData.MovieData;
import model.MoviesData.Movies;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoviesTests {

    @AfterTest()
    public void afterTest() {
        if(MoviesApi.getMoviesFromFavorites().size() != 0){
            MoviesApi.removeAllMoviesFromFavorites();
        }
    }

    @Test
    public void checkRestAddingMovieToFavoriteTest(){
        Movies beforeMovies = MoviesApi.getMoviesFromFavorites();
        MovieData movieData = MoviesApi.addRandomMovieToFavorite();
        Movies afterMovies = MoviesApi.getMoviesFromFavorites();

        assertThat("", afterMovies, equalTo(beforeMovies.withAdded(movieData)));
    }
}
