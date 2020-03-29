package desktop.ui.pages.Media.Movies;

import desktop.ui.pages.Media.CommonPage;
import model.MoviesData.MovieData;
import org.openqa.selenium.By;

public class MoviePage extends CommonPage {

    private MovieData movieData;

    public MoviePage() {
        this.movieData = new MovieData();
    }

    public MovieData getMovieData(){
        return movieData;
    }

    public MoviePage setMovieData() {
        this.movieData.setTitle(getMovieTitle());

        return this;
    }

    public String getMovieTitle(){
        return webDriver.findElement(By.cssSelector("div.title>h2>a")).getText();
    }

}
