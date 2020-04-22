package api;

import constants.Category;
import constants.Type;
import core.Logging;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class RateMovieTests extends Logging {

    @AfterTest
    public void afterTest() {
        MediaApi.removeAllRatedMedia(Type.MOVIE);
    }

    @Test
    public void apiRateMovieTest(){
        String mediaId = MediaApi.rateRandomMedia(Type.MOVIE, Category.NOW, "8.5");

        assertThat("",
                MediaApi.getRatedMedia(Type.MOVIE), containsString(mediaId));
    }
}
