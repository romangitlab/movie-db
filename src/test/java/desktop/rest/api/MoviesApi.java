package desktop.rest.api;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import desktop.rest.api.Common.CommonApi;
import model.MoviesData.MovieData;
import model.MoviesData.Movies;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;

public class MoviesApi extends CommonApi {

    public static List<MovieData> getPopularMovies() {
        JsonElement parsed;
        JsonElement movies;

        String json = requestSpecification()
                .get(baseApiUrl + "movie/popular").asString();

        parsed = new JsonParser().parse(json);
        movies = parsed.getAsJsonObject().get("results");

        return new Gson().fromJson(movies, new TypeToken<List<MovieData>>(){}.getType());
    }

    public static Movies getMoviesFromFavorites() {
        JsonElement parsed;
        JsonElement movies;
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String json = requestSpecification()
                .get(baseApiUrl + "account/1/favorite/movies").asString();

        parsed = new JsonParser().parse(json);
        movies = parsed.getAsJsonObject().get("results");

        return new Gson().fromJson(movies, new TypeToken<Movies>(){}.getType());
    }

    public static MovieData getRandomMovie() {

        int moviesCount = getPopularMovies().size();
        int randomMovie = new Random().nextInt(moviesCount);

        return getPopularMovies().get(randomMovie);
    }

    public static void removeAllMoviesFromFavorites() {
        Set<MovieData> movies = getMoviesFromFavorites();

        for (MovieData movie : movies) {
            requestSpecification(favoriteBody("movie", false, movie.getId()))
                    .post(baseApiUrl + "account/1/favorite");
        }
    }

    public static MovieData addRandomMovieToFavorite() {

        MovieData movieData = getRandomMovie();

        String result = requestSpecification(favoriteBody("movie", true, movieData.getId()))
                .post(baseApiUrl + "account/1/favorite").asString().toLowerCase();

        assertTrue(result.contains("success"), "Failed -> addRandomMovieToFavorite()");

        return movieData;
    }
}
