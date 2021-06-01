package api;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import constants.Category;
import constants.MediaType;
import constants.Page;
import helpers.Helper;
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

    public static Media getMediaFrom(MediaType type, Page page) {
        logger.info("Run: getMediaFrom()");

        String mediaType = type.get();

        if(mediaType.equals("movie")) mediaType = "movies";

        Helper.sleepFor(1000);

        String json = request()
                .get(baseApiUrl + "account/1/"+page.get()+"/" + mediaType).asString();

        return new Gson().fromJson(getJsonElement(json, "results"), new TypeToken<Media>(){}.getType());
    }

    public static MediaData getRandomMedia(MediaType type, Category category) {
        logger.info("Run: getRandomMedia()");

        List<MediaData> mediaList = getCategoryMedia(type, category);
        int mediaCount = mediaList.size();
        int randomMedia = new Random().nextInt(mediaCount);

        return mediaList.get(randomMedia);
    }

    public static List<MediaData> getCategoryMedia(MediaType type, Category category) {
        logger.info("Run: getCategoryMedia(" + type.get()+"/"+category.get()+")");

        String json = request()
                .get(baseApiUrl + type.get() + "/" + category.get()).asString();

        Helper.sleepFor(1000);

        return new Gson().fromJson(getJsonElement(json, "results"), new TypeToken<List<MediaData>>(){}.getType());
    }

    public static void removeAllMediaFrom(MediaType type, Page page) {
        logger.info("Run: removeAllMediaFromWatchlist()");

        Set<MediaData> medias = getMediaFrom(type, page);

        medias.stream().forEach((media) ->{
            request(pageBody(type.get(), false, media.getId(), page.get()))
                    .post(baseApiUrl + "account/1/"+page.get());
        });
    }

    public static List<MediaData> searchMedia(String searchText, String mediaType) {
        logger.info("Run: searchMedia()");

        Gson gson = new Gson();
        List<MediaData> media;

        String json = request()
                .queryParam("query", searchText)
                .get(baseApiUrl + "search/" + mediaType).asString();

        if(mediaType.equals("tv")) {
            media =  gson.fromJson(getJsonElement(json, "results"), new TypeToken<List<MediaData>>(){}.getType());
        } else if(mediaType.equals("movie")) {
            media = gson.fromJson(getJsonElement(json, "results"), new TypeToken<List<MediaData>>(){}.getType());
        } else if(mediaType.equals("multi")) {
            media = gson.fromJson(getJsonElement(json, "results"), new TypeToken<List<MediaData>>(){}.getType());
        } else {
            throw new IllegalArgumentException("Illegal media type");
        }

        return media;
    }

    public static String rateRandomMedia(MediaType type, Category category, String rate) {
        logger.info("Run: rateRandomMedia()");

        String mediaId = getRandomMedia(type, category).getId();
        String result = request(rateBody(rate))
                .post(baseApiUrl + type.get()+"/"+mediaId+"/rating").asString().toLowerCase();

        logger.info("Rate media response: " + result);
        Helper.sleepFor(1000);

        Assert.isTrue(result.contains("success"), "Failed -> addRandomMediaToFavorite()");

        return mediaId;
    }

    public static String getRatedMedia(MediaType type) {
        logger.info("Run: getRatedMedia()");

        String media = type.get();

        if(type.get().equals("movie")) media = "movies" ;

        String result = request()
                .get(baseApiUrl + "account/9109755/rated/"+media).asString().toLowerCase();

        logger.info("Got rate response: " + result);
        Helper.sleepFor(1000);

        return result;
    }

    public static void removeAllRatedMedia(MediaType type) {
        logger.info("Run: removeRatedMedia()");

        String ratedMedia = getRatedMedia(type);

        for (JsonElement media : getAsJsonArray(ratedMedia, "results")){
            String id = media.getAsJsonObject().get("id").toString();
            String response = request()
                    .delete(baseApiUrl + type.get()+"/"+id+"/rating").asString();

            logger.info("Delete rate response: " + response);
        }
    }

    public static MediaData addRandomMediaTo(MediaType type, Page page, Category category) {
        logger.info("Run: addRandomMediaTo()");

        MediaData mediaData = getRandomMedia(type, category);
        String result = request(pageBody(type.get(), true, mediaData.getId(), page.get()))
                .post(baseApiUrl + "account/9109755/"+page.get()).asString().toLowerCase();

        logger.info("Got rate response: " + result);

        Assert.isTrue(result.contains("success"), "Failed -> addRandomMediaTo()");

        return mediaData;
    }

    public static String createRandomPlayList() {
        logger.info("Run: createRandomPlayList()");

        String result = request(listBody())
                .post(baseApiUrl + "list").asString();
        logger.info("Got response: " + result);

        Assert.isTrue(result.contains("The item/record was created successfully"), "Failed -> addRandomMediaToPlayList()");

        return getJsonElement(result, "list_id").toString();
    }

    public static void deleteAllPlayLists() {
        logger.info("Run: deleteAllPlayLists()");

        Media lists = getCreatedPlayList("", true);

        for (MediaData list : lists){
            String response = request()
                    .delete(baseApiUrl + "list/"+list.getId()).asString();
            logger.info("Delete list response: " + response);
        }
    }

    public static String deletePlayList(String playList) {
        logger.info("Run: deletePlayList()");
        String result = request(listBody())
                .delete(baseApiUrl + "list/" + playList).asString();

        logger.info("Got response: " + result);

        return result;
    }

    public static Media getCreatedPlayList(String list_id, Boolean getAllLists) {
        logger.info("Run: getCreatedPlayList()" + list_id + "/" + getAllLists);

        Media media;
        String response;

        if(!getAllLists) {
            response = request()
                    .get(baseApiUrl + "list/" + list_id).asString();
            logger.info("Got 'list' response: " + response);

            media = new Gson().fromJson(getJsonArray(response, "results"), new TypeToken<Media>() {}.getType());
            media.iterator().next().setResponse(response);

        } else {

            response = request()
                    .get(baseApiUrl + "account/9109755/lists").asString().toLowerCase();

            logger.info("Got 'lists' response: " + response);

            media = new Gson().fromJson(getJsonElement(response, "results"), new TypeToken<Media>(){}.getType());
        }

        return media;
    }

    public static MediaData addRandomMediaToPlayList(MediaType type, Category category, String list_id) {
        logger.info("Run: addRandomMediaToPlayList()");

        MediaData mediaData = getRandomMedia(type, category);

        String result = request(mediaBody(mediaData.getId()))
                .post(baseApiUrl + "list/"+list_id+"/add_item").asString().toLowerCase();

        logger.info("Request to: " + baseApiUrl + "list/"+list_id+"/add_item");
        logger.info("Got response: " + result);

        Helper.sleepFor(1500);

        Assert.isTrue(result.contains("record was updated successfully"), "Failed -> addRandomMediaToPlayList()");

        return mediaData;
    }

    public static String clearAllMediaFromPlayList(String list_id) {
        logger.info("Run: clearAllMediaFromPlayList()");

        String response = request()
                .queryParam("confirm", true)
                .post(baseApiUrl + "list/"+list_id+"/clear").asString().toLowerCase();

        logger.info("Request to: " + baseApiUrl + "list/"+list_id+"/clear");
        logger.info("Got response: " + response);

        Assert.isTrue(response.contains("item/record was updated successfully."), "Failed -> clearAllMediaFromPlayList()");

        return response;
    }

    public static MediaData removeRandomMediaFromPlayList(MediaData mediaData, String list_id) {
        logger.info("Run: removeRandomMediaToPlayList()");

        String response = request(mediaBody(mediaData.getId()))
                .post(baseApiUrl + "list/"+list_id+"/remove_item").asString().toLowerCase();

        mediaData.setResponse(response);

        logger.info("Got rate response: " + response);

        Assert.isTrue(response.contains("the item/record was deleted successfully."), "Failed -> removeRandomMediaToPlayList()");

        return mediaData;
    }
}
