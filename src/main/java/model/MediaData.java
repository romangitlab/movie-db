package model;

import com.google.gson.JsonElement;
import lombok.Data;

import java.util.ArrayList;

@Data
public class MediaData {
    //Media
    private String id;
    private String title;
    private String name;

    //Playlist
    private String description;
    private String favorite_count;
    private String item_count;
    private String list_type;
    private String iso_639_1;
    private String poster_path;
    private String created_by;

    //Playlist items
    private ArrayList<JsonElement> items;
    private String popularity;
    private String vote_count;
    private String video;
    private String media_type;
    private String adult;
    private String backdrop_path;
    private String original_language;
    private String original_title;
    private String vote_average;
    private String overview;
    private ArrayList<String> genre_ids;
    private String release_date;

    private String response;
}
