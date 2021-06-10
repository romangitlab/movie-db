package pages.web.Media;

import core.web.WebManager;
import helpers.WebHelper;
import model.MediaData;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MediaItemPage extends WebHelper {

    Logger logger = LoggerFactory.getLogger(MediaItemPage.class);
    private MediaData mediaData;

    public MediaItemPage() {
        this.mediaData = new MediaData();
    }

    public MediaData getMediaData(){
        return mediaData;
    }

    public MediaItemPage setMediaData() {
        this.mediaData.setTitle(getTitle());

        return this;
    }

    public String getTitle(){
        logger.info("Run: getTitle()");
        String title;

        if (WebManager.isMW()) {
            title = webDriver.findElement(By.cssSelector("div.content>a>h2")).getText()
                    .replaceAll("\\d", "")
                    .replaceAll("\\(\\)", "")
                    .trim();
        } else {
            title = webDriver.findElement(By.cssSelector("div.title>h2>a")).getText();;
        }

        return title;
    }

    public MediaItemPage addToFavorites() {
        logger.info("Run: addToFavorites()");

        acceptCookiePolicy();
        scrollWebPageTo(webDriver.findElement(By.id("favourite")));
        clickAtElement(By.id("favourite"));

        return this;
    }

    public MediaItemPage acceptCookiePolicy(){
        if (WebManager.isMW()) {
            scrollWebPageTo(webDriver.findElement(By.cssSelector("a.accept")));
            clickAtElement(By.cssSelector("a.accept"));
        }

        return this;
    }

}
