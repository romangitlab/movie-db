package desktop.ui.pages.Media.TvShows;

import desktop.ui.pages.Media.CommonPage;
import model.TvShowData.TvShowData;
import org.openqa.selenium.By;

public class TvShowPage extends CommonPage {

    private TvShowData tvShowData;

    public TvShowPage() {
        this.tvShowData = new TvShowData();
    }

    public TvShowData getTvShowData(){
        return tvShowData;
    }

    public TvShowPage setTvShowData() {
        this.tvShowData.setTitle(getTvShowTitle());

        return this;
    }

    public String getTvShowTitle(){
        return webDriver.findElement(By.cssSelector("div.title>h2>a")).getText();
    }

}
