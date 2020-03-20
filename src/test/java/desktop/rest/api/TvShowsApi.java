package desktop.rest.api;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import desktop.rest.api.Common.CommonApi;
import model.TvShowData.TvShow;
import model.TvShowData.TvShowData;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;

public class TvShowsApi extends CommonApi {

    public static List<TvShowData> getPopularTvShows() {
        JsonElement parsed;
        JsonElement movies;

        String json = requestSpecification()
                .get(baseApiUrl + "tv/popular").asString();

        parsed = new JsonParser().parse(json);
        movies = parsed.getAsJsonObject().get("results");

        return new Gson().fromJson(movies, new TypeToken<List<TvShowData>>(){}.getType());
    }

    public static TvShow getTvShowsFromFavorites() {
        JsonElement parsed;
        JsonElement tvShows;
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String json = requestSpecification()
                .get(baseApiUrl + "account/1/favorite/tv").asString();

        parsed = new JsonParser().parse(json);
        tvShows = parsed.getAsJsonObject().get("results");

        return new Gson().fromJson(tvShows, new TypeToken<TvShow>(){}.getType());
    }

    public static TvShowData getRandomTvShow() {

        int tvCount = getPopularTvShows().size();
        int randomTv = new Random().nextInt(tvCount);

        return getPopularTvShows().get(randomTv);
    }

    public static void removeAllTvShowsFromFavorites() {
        Set<TvShowData> tvShows = getTvShowsFromFavorites();

        for (TvShowData tv : tvShows) {
            requestSpecification(favoriteBody("tv", false, tv.getId()))
                    .post(baseApiUrl + "account/1/favorite");
        }
    }

    public static TvShowData addRandomTvShowToFavorite() {

        TvShowData tvShowData = getRandomTvShow();

        String result = requestSpecification(favoriteBody("tv", true, tvShowData.getId()))
                .post(baseApiUrl + "account/1/favorite").asString().toLowerCase();

        assertTrue(result.contains("success"), "Failed -> addRandomTvShowToFavorite()");

        return tvShowData;
    }
}
