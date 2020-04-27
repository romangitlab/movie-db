package api;

import constants.Category;
import constants.MediaType;
import core.Logging;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class RateTvShowTests extends Logging {

    @AfterTest
    public void afterTest() {
        MediaApi.removeAllRatedMedia(MediaType.TVSHOW);
    }

    @Test
    public void apiRateMovieTest(){
        String mediaId = MediaApi.rateRandomMedia(MediaType.TVSHOW, Category.TOP, "8.5");

        assertThat("",
                MediaApi.getRatedMedia(MediaType.TVSHOW), containsString(mediaId));
    }
}
