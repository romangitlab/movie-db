package api;

import model.MediaData;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchTests {

    @Test
    public void webSearchMovieTest() {
        List<MediaData> searchResult = MediaApi.searchMedia("Joker", "movie");

        assertThat("",
                searchResult.size(), is(not(0)));
        assertThat("",
                searchResult.iterator().next().getTitle(), containsString("Joker"));
    }

    @Test
    public void webSearchTvShowTest() {
        List<MediaData> searchResult = MediaApi.searchMedia("Arrow", "tv");

        assertThat("",
                searchResult.size(), is(not(0)));
        assertThat("",
                searchResult.iterator().next().getName(), containsString("Arrow"));
    }

    @Test
    public void webEmptySearchTest() {
        List<MediaData> searchResult = MediaApi.searchMedia("@!@!@!@!", "multi");

        assertThat("",
                searchResult.size(), is(0));
    }
}
