package desktop.ui.pages.Profile;

import model.MoviesData.MovieData;
import model.MoviesData.Movies;
import model.TvShowData.TvShow;
import model.TvShowData.TvShowData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfileFavoritesPage extends ProfileCommonPage {

    public ProfileFavoritesPage(){}

    public ProfileFavoritesPage(String type){
        openFavoritesPage(type);
    }

    public void openFavoritesPage(String type) {
        if(type.equals("movies")) {
            webDriver.get(getProductWebAddress() + "u/romang/favorites");
            webDriver.get(getProductWebAddress() + "u/romang/favorites");
        } else if(type.equals("tv")) {
            webDriver.get(getProductWebAddress() + "u/romang/favorites/tv");
            webDriver.get(getProductWebAddress() + "u/romang/favorites/tv");
        } else {
            throw new IllegalArgumentException("No valid media type selected. Try 'movie' or 'tv'");
        }
    }

    public Movies getMoviesFavoriteList() {
        Movies movies = new Movies();

        List<WebElement> movieElements = webDriver.findElements(By.cssSelector(".results_page>.card"));

        for (WebElement movie : movieElements) {
            String title = movie.findElement(By.cssSelector("div.title")).getText().split("\n")[0];
            movies.add(new MovieData().setTitle(title));
        }

        return movies;
    }

    public TvShow getTvShowFavoriteList() {
        TvShow tvShow = new TvShow();

        List<WebElement> tvShowElements = webDriver.findElements(By.cssSelector(".results_page>.card"));

        for (WebElement movie : tvShowElements) {
            String title = movie.findElement(By.cssSelector("div.title")).getText().split("\n")[0];
            tvShow.add(new TvShowData().setTitle(title));
        }

        return tvShow;
    }
}
