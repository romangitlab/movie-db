package desktop.rest.api;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import desktop.rest.api.Common.CommonApi;
import model.CommonData.MediaData;
import model.MoviesData.MovieData;
import model.TvShowData.TvShowData;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SearchApi extends CommonApi {

    public static Collection<MediaData> search(String searchText, String mediaType) {
        JsonElement parsed;
        JsonElement results;
        Gson gson = new Gson();

        String json = requestSpecification()
                .queryParam("query", searchText)
                .get(baseApiUrl + "search/" + mediaType).asString();

        parsed = new JsonParser().parse(json);
        results = parsed.getAsJsonObject().get("results");

        if(mediaType.equals("tv")) {
            return gson.fromJson(results, new TypeToken<List<TvShowData>>(){}.getType());
        } else if(mediaType.equals("movie")) {
            return gson.fromJson(results, new TypeToken<Set<MovieData>>(){}.getType());
        }

        return gson.fromJson(results, new TypeToken<List<MediaData>>(){}.getType());
    }
}
