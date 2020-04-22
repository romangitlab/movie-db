package api;

import constants.Category;
import constants.Type;
import core.Logging;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class RateTvShowTests extends Logging {

    @AfterTest
    public void afterTest() {
        MediaApi.removeAllRatedMedia(Type.TVSHOW);
    }

    @Test
    public void apiRateMovieTest(){
        String mediaId = MediaApi.rateRandomMedia(Type.TVSHOW, Category.TOP, "8.5");

        assertThat("",
                MediaApi.getRatedMedia(Type.TVSHOW), containsString(mediaId));
    }
}
