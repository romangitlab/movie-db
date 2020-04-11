package pages.web.Media;

import helpers.WebHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.web.Search.SearchPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MediaPage extends WebHelper {

    Logger logger = LoggerFactory.getLogger(MediaPage.class);

    public MediaPage(String mediaType) {
        openMediaPage(mediaType);
    }

    public void openMediaPage(String mediaType) {
        logger.info("Run: openMediaPage()");

        switch (mediaType) {
            case "movie":
                webDriver.get(getProductWebAddress() + "movie");
                break;

            case "tv":
                webDriver.get(getProductWebAddress() + "tv");
                break;

            default:
                webDriver.get(getProductWebAddress() + "movie");
        }
    }

    private ArrayList<WebElement> geMediaList(){
        logger.info("Run: geMediaList()");

        ArrayList<WebElement> media = new ArrayList<>();
        List<WebElement> elements = webDriver.findElements(By.cssSelector("div.media_items.results>div>div"));

        elements.stream().map((element)->media.add(element)).collect(Collectors.toList());

        return media;
    }

    public MediaItemPage openRandomMedia() {
        logger.info("Run: openRandomMedia()");

        List<WebElement> medias = geMediaList();
        int mediaCount = medias.size();
        int randomMedia = new Random().nextInt(mediaCount);
        WebElement media = medias.get(randomMedia);
        scrollWebPageTo(media);
        media.findElement(By.cssSelector("div.image>div>a")).click();

        return new MediaItemPage();
    }

    public SearchPage search(String searchText){
        logger.info("Run: search()");

        return new SearchPage(searchText);
    }

    public SearchPage search(String searchText, String mediaType){
        logger.info("Run: search()");

        return new SearchPage(searchText, mediaType);
    }
}
