package mobile.tests.mobile_web;

import mobile.lib.CoreTest;
import mobile.lib.ui.mobile_web.pages.search.SearchPage;
import org.junit.Test;

public class SearchTests extends CoreTest {

    @Test
    public void testSearch() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.typeSeachText("Joker");
        searchPage.waitForSearchResult("Joker");
    }

    @Test
    public void testAmountOfNotEmptySearch() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.typeSeachText("Joker");

        assertTrue(
                "No movies were found",
                searchPage.getAmountOfFoundMovies() > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.typeSeachText("@!@!@!@!");

        assertTrue(
                "Movies were found",
                searchPage.getAmountOfFoundMovies() == 0
        );
    }
}
