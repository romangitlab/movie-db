package desktop.ui.pages.Media.Movies;

import desktop.ui.base.HelperBase;
import desktop.ui.pages.Search.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoviesPage extends HelperBase {

    public MoviesPage() {
        webDriver.get(getProductWebAddress() + "movie");
    }

    public MoviesPage openMoviesPage(){
        webDriver.get(getProductWebAddress() + "movie");

        return this;
    }

    private ArrayList<WebElement> geMoviesList(){
        ArrayList<WebElement> movies = new ArrayList<WebElement>();

        List<WebElement> movieElements = webDriver.findElements(By.cssSelector("div.media .results .item"));

        for (WebElement movie : movieElements) {
            movies.add(movie);
        }

        return movies;
    }

    public MoviePage openRandomMovie() {

        List<WebElement> movies = geMoviesList();

        int moviesCount = movies.size();
        int randomMovie = new Random().nextInt(moviesCount);

        WebElement movie = movies.get(randomMovie);
        movie.findElement(By.cssSelector("div.image_content>a")).click();

        return new MoviePage();
    }

    public SearchPage search(String searchText){
        return new SearchPage(searchText);
    }

    public SearchPage search(String searchText, String mediaType){
        return new SearchPage(searchText, mediaType);
    }


}
