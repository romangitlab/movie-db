package api;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import constants.Category;
import constants.Type;
import helpers.WebHelper;
import model.Media;
import model.MediaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class MediaApi extends CommonApi {
    static Logger logger = LoggerFactory.getLogger(MediaApi.class);

    public static Media getMediaFromFavorites(Type type) {
        logger.info("Run: getMediaFromFavorites()");

        String mediaType = type.get();
        if(mediaType.equals("movie")) mediaType = "movies";

        WebHelper.sleepFor(2000);

        String json = CommonApi.requestSpecification()
                .get(CommonApi.baseApiUrl + "account/1/favorite/" + mediaType).asString();

        return new Gson().fromJson(CommonApi.getJsonElement(json, "results"), new TypeToken<Media>(){}.getType());
    }

    public static MediaData addRandomMediaToFavorite(Type type, Category category) {
        logger.info("Run: addRandomMediaToFavorite()");

        MediaData mediaData = getRandomMedia(type, category);

        String result = CommonApi.requestSpecification(CommonApi.favoriteBody(type.get(), true, mediaData.getId()))
                .post(CommonApi.baseApiUrl + "account/1/favorite").asString().toLowerCase();

        Assert.isTrue(result.contains("success"), "Failed -> addRandomMediaToFavorite()");

        return mediaData;
    }

    public static MediaData getRandomMedia(Type type, Category category) {
        logger.info("Run: getRandomMedia()");

        List<MediaData> mediaList = getCategoryMedia(type, category);
        int mediaCount = mediaList.size();
        int randomMedia = new Random().nextInt(mediaCount);

        return mediaList.get(randomMedia);
    }

    public static List<MediaData> getCategoryMedia(Type type, Category category) {
        logger.info("Run: getCategoryMedia(" + type.get()+"/"+category.get()+")");

        String json = CommonApi.requestSpecification()
                .get(CommonApi.baseApiUrl + type.get() + "/" + category.get()).asString();

        return new Gson().fromJson(CommonApi.getJsonElement(json, "results"), new TypeToken<List<MediaData>>(){}.getType());
    }

    public static void removeAllMediaFromFavorites(Type type) {
        logger.info("Run: removeAllMediaFromFavorites()");

        Set<MediaData> medias = getMediaFromFavorites(type);

        medias.stream().forEach((media) ->{
            CommonApi.requestSpecification(CommonApi.favoriteBody(type.get(), false, media.getId()))
                    .post(CommonApi.baseApiUrl + "account/1/favorite");
        });
    }

    public static List<MediaData> searchMedia(String searchText, String mediaType) {
        logger.info("Run: searchMedia()");

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

    public static String rateRandomMedia(Type type, Category category, String rate) {
        logger.info("Run: rateRandomMedia()");

        String mediaId = getRandomMedia(type, category).id;

        String result = CommonApi.requestSpecification(CommonApi.rateBody(rate))
                .post(CommonApi.baseApiUrl + type.get()+"/"+mediaId+"/rating").asString().toLowerCase();
        logger.info("Rate media response: " + result);

        WebHelper.sleepFor(1000);

        Assert.isTrue(result.contains("success"), "Failed -> addRandomMediaToFavorite()");

        return mediaId;
    }

    public static String getRatedMedia(Type type) {
        logger.info("Run: getRatedMedia()");

        String media = type.get();
        if(type.get().equals("movie")) media = "movies" ;

        String result = CommonApi.requestSpecification()
                .get(CommonApi.baseApiUrl + "account/9109755/rated/"+media).asString().toLowerCase();
        logger.info("Get rate response: " + result);

        WebHelper.sleepFor(1000);

        return result;
    }

    public static void removeAllRatedMedia(Type type) {
        logger.info("Run: removeRatedMedia()");

        String ratedMedia = getRatedMedia(type);
        JsonArray mediaArray = new JsonParser().parse(ratedMedia).getAsJsonObject().get("results").getAsJsonArray();

        for (JsonElement media : mediaArray){
            String id = media.getAsJsonObject().get("id").toString();

            String response = CommonApi.requestSpecification()
                    .delete(CommonApi.baseApiUrl + type.get()+"/"+id+"/rating").asString();

            logger.info("Delete rate response: " + response);
        }
    }

}
