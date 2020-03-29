package desktop.rest.tests;

import desktop.rest.api.SearchApi;
import model.CommonData.MediaData;
import model.MoviesData.MovieData;
import model.TvShowData.TvShowData;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertTrue;

public class SearchTests {

    @Test
    public void checkRestSearchMovieTest() {
        Set<MovieData> searchResult = (Set) SearchApi.search("Joker", "movie");
        MovieData movie = searchResult.iterator().next();

        assertThat("", searchResult.size(), is(not(0)));
        assertTrue(movie.getTitle().contains("Joker"), "");
    }

    @Test
    public void checkRestSearchTvShowTest() {
        List<TvShowData> searchResult = (List) SearchApi.search("Arrow", "tv");
        TvShowData tv = searchResult.iterator().next();

        assertThat("", searchResult.size(), is(not(0)));
        assertTrue(tv.getName().contains("Arrow"), "");
    }

    @Test
    public void checkRestNegativeSearchTest() {
        List<MediaData> searchResult = (List) SearchApi.search("@!@!@!@!", "multi");

        assertThat("", searchResult.size(), is(0));
    }
}
