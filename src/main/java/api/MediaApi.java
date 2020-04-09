package api;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import helpers.WebHelper;
import model.Media;
import model.MediaData;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class MediaApi extends CommonApi {

    public static Media getMediaFromFavorites(String mediaType) {

        if(mediaType.equals("movie")) mediaType = "movies";

        WebHelper.sleepFor(2000);

        String json = CommonApi.requestSpecification()
                .get(CommonApi.baseApiUrl + "account/1/favorite/" + mediaType).asString();

        return new Gson().fromJson(CommonApi.getJsonElement(json, "results"), new TypeToken<Media>(){}.getType());
    }

    public static MediaData addRandomMediaToFavorite(String mediaType) {

        MediaData mediaData = getRandomMedia(mediaType);

        String result = CommonApi.requestSpecification(CommonApi.favoriteBody(mediaType, true, mediaData.getId()))
                .post(CommonApi.baseApiUrl + "account/1/favorite").asString().toLowerCase();

        Assert.isTrue(result.contains("success"), "Failed -> addRandomMediaToFavorite()");

        return mediaData;
    }

    public static MediaData getRandomMedia(String mediaType) {

        int mediaCount = getPopularMedia(mediaType).size();
        int randomMedia = new Random().nextInt(mediaCount);

        return getPopularMedia(mediaType).get(randomMedia);
    }

    public static List<MediaData> getPopularMedia(String mediaType) {

        String json = CommonApi.requestSpecification()
                .get(CommonApi.baseApiUrl + mediaType + "/popular").asString();

        return new Gson().fromJson(CommonApi.getJsonElement(json, "results"), new TypeToken<List<MediaData>>(){}.getType());
    }

    public static void removeAllMediaFromFavorites(String mediaType) {

        Set<MediaData> medias = getMediaFromFavorites(mediaType);

        medias.stream().forEach((media) ->{
            CommonApi.requestSpecification(CommonApi.favoriteBody(mediaType, false, media.getId()))
                    .post(CommonApi.baseApiUrl + "account/1/favorite");
        });
    }

    public static List<MediaData> searchMedia(String searchText, String mediaType) {

        Gson gson = new Gson();
        List<MediaData> media;

        String json = CommonApi.requestSpecification()
                .queryParam("query", searchText)
                .get(CommonApi.baseApiUrl + "search/" + mediaType).asString();

        if(mediaType.equals("tv")) {
            media =  gson.fromJson(CommonApi.getJsonElement(json, "results"), new TypeToken<List<MediaData>>(){}.getType());
        } else if(mediaType.equals("movie")) {
            media = gson.fromJson(CommonApi.getJsonElement(json, "results"), new TypeToken<List<MediaData>>(){}.getType());
        } else if(mediaType.equals("multi")) {
            media = gson.fromJson(CommonApi.getJsonElement(json, "results"), new TypeToken<List<MediaData>>(){}.getType());
        } else {
            throw new IllegalArgumentException("Illegal media type");
        }

        return media;
    }
}
