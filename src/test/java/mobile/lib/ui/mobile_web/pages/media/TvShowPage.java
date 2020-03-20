package mobile.lib.ui.mobile_web.pages.media;

import model.TvShowData.TvShowData;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TvShowPage extends CommonMediaPage {

    static {
        TITLE = "css:div.title>div>div>a>h2";
        FAVORITE = "id:favourite";
    }

    protected TvShowData tvShow;

    public TvShowPage(RemoteWebDriver driver) {
        super(driver);
        this.tvShow = new TvShowData();
    }

    public TvShowData getTvShowData(){
        return this.tvShow;
    }

    public TvShowPage setTvShowData() {
        this.tvShow.setName(getTvShowTitle());

        return this;
    }

    public String getTvShowTitle(){
        return waitForElementPresent(TITLE, "Cannot find path to element").getText()
                .replaceAll("\\d", "")
                .replaceAll("\\(\\)", "")
                .trim();
    }

}
