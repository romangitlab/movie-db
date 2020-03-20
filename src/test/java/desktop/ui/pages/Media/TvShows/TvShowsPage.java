package desktop.ui.pages.Media.TvShows;

import desktop.ui.pages.Media.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TvShowsPage extends CommonPage {

    public TvShowsPage() {
        webDriver.get(getProductWebAddress() + "tv");
    }

    private ArrayList<WebElement> geTvShowList(){
        ArrayList<WebElement> tvShows = new ArrayList<WebElement>();

        List<WebElement> tvShowElements = webDriver.findElements(By.cssSelector("div.media .results .item"));

        for (WebElement tvShow : tvShowElements) {
            tvShows.add(tvShow);
        }

        return tvShows;
    }

    public TvShowPage openRandomTvShow() {

        List<WebElement> tvShows = geTvShowList();

        int tvShowCount = tvShows.size();

        int randomTvShow = new Random().nextInt(tvShowCount);

        WebElement movie = tvShows.get(randomTvShow);
        movie.findElement(By.cssSelector("div.image_content>a")).click();

        return new TvShowPage();
    }
}
