package pages.web.Profile;

import helpers.WebHelper;
import model.Media;
import model.MediaData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProfileFavoritesPage extends WebHelper {

    Logger logger = LoggerFactory.getLogger(ProfileFavoritesPage.class);

    public ProfileFavoritesPage(String type){
        openFavoritesPage(type);
    }

    public void openFavoritesPage(String type) {
        logger.info("Run: openFavoritesPage()");

        switch (type) {
            case "movie":
                webDriver.get(getProductWebAddress() + "u/romang/favorites");
                webDriver.get(getProductWebAddress() + "u/romang/favorites");
            break;

            case "tv":
                webDriver.get(getProductWebAddress() + "u/romang/favorites/tv");
                webDriver.get(getProductWebAddress() + "u/romang/favorites/tv");
            break;

            default:
                throw new IllegalArgumentException("No valid media type was selected. Only allowed 'movie' or 'tv'");
        }
    }

    public Media getFavoriteList() {
        logger.info("Run: getFavoriteList()");

        Media media = new Media();
        List<WebElement> elements = webDriver.findElements(By.cssSelector(".results_page>.card"));

        elements.stream().forEach((element) -> {
            String title = element.findElement(By.cssSelector("div.title")).getText().split("\n")[0];
            MediaData mediaData = new MediaData();
            mediaData.setTitle(title);
            media.add(mediaData);
        });

        return media;
    }

    public int getFavoritesCount() {
        logger.info("Run: getFavoritesCount()");

        return webDriver.findElements(By.cssSelector(".results_page>.card")).size();
    }
}
