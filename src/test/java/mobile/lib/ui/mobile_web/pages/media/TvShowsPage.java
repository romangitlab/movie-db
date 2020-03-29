package mobile.lib.ui.mobile_web.pages.media;

import mobile.lib.ui.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TvShowsPage extends MainPage {

    protected static String
            TV_LIST = "css:div.media_items.results>div>div",
            TV_TITLE = "css:div.wrapper div.title";

    public TvShowsPage(RemoteWebDriver driver) {
        super(driver);
        driver.get(baseUrl + "tv");
    }

    public ArrayList<WebElement> geTvList(){
        ArrayList<WebElement> tvs = new ArrayList<WebElement>();

        List<WebElement> tvElements = driver.findElements(getLocatorByString(TV_LIST));

        for (WebElement movie : tvElements) {
            tvs.add(movie);
        }

        return tvs;
    }

    public TvShowPage openRandomTv() {

        List<WebElement> movies = geTvList();

        int moviesCount = movies.size();
        int randomTv = new Random().nextInt(moviesCount-1);
        WebElement movie = movies.get(randomTv);

        scrollWebPageTo(movie);
        movie.findElement(getLocatorByString(TV_TITLE)).click();

        return new TvShowPage(driver);
    }
}
