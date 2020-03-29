package mobile.lib.ui.mobile_web.pages.media;

import model.MoviesData.MovieData;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MoviePage extends CommonMediaPage {

    static {
        TITLE = "css:div.content>a>h2";
        FAVORITE = "id:favourite";
    }

    protected MovieData movieData;

    public MoviePage(RemoteWebDriver driver) {
        super(driver);
        this.movieData = new MovieData();
    }

    public MovieData getMovieData(){
        return this.movieData;
    }

    public MoviePage setMovieData() {
        this.movieData.setTitle(getMovieTitle());

        return this;
    }

    public String getMovieTitle(){
        return waitForElementPresent(TITLE, "Cannot find path to element").getText()
                .replaceAll("\\d", "")
                .replaceAll("\\(\\)", "")
                .trim();
    }

}
