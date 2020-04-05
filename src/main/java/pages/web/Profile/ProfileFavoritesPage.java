package pages.web.Profile;

import helpers.WebHelper;
import model.Media;
import model.MediaData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfileFavoritesPage extends WebHelper {

    public ProfileFavoritesPage(String type){
        openFavoritesPage(type);
    }

    public void openFavoritesPage(String type) {

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
        return webDriver.findElements(By.cssSelector(".results_page>.card")).size();
    }
}
