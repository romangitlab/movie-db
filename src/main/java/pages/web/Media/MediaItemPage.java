package pages.web.Media;

import core.web.WebManager;
import helpers.WebHelper;
import model.MediaData;
import org.openqa.selenium.By;

public class MediaItemPage extends WebHelper {

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

        //acceptCookiePolicy();
        scrollWebPageTo(webDriver.findElement(By.id("favourite")));
        clickAtElement(By.id("favourite"));

        return this;
    }

    /*
    public MediaItemPage acceptCookiePolicy(){
        if (WebManager.isMW()) {
            clickAtElement(By.cssSelector("p>a.accept"));
        }

        return this;
    }
     */

}
