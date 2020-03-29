package mobile.lib.ui.mobile_web.pages.media;

import mobile.lib.ui.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoviesPage extends MainPage {

    protected static String
            MOVIES_LIST = "css:div.media_items.results>div>div",
            MOVIE_TITLE = "css:div.wrapper div.title";

    public MoviesPage(RemoteWebDriver driver) {
        super(driver);
        driver.get(baseUrl + "movie");
    }

    public ArrayList<WebElement> geMoviesList(){
        ArrayList<WebElement> movies = new ArrayList<WebElement>();

        List<WebElement> movieElements = driver.findElements(getLocatorByString(MOVIES_LIST));

        for (WebElement movie : movieElements) {
            movies.add(movie);
        }

        return movies;
    }

    public MoviePage openRandomMovie() {

        List<WebElement> movies = geMoviesList();

        int moviesCount = movies.size();
        int randomMovie = new Random().nextInt(moviesCount-1);
        WebElement movie = movies.get(randomMovie);

        scrollWebPageTo(movie);
        movie.findElement(getLocatorByString(MOVIE_TITLE)).click();

        return new MoviePage(driver);
    }
}
