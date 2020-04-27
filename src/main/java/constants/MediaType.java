package constants;

public enum MediaType {
    MOVIE("movie"),
    TVSHOW("tv");

    private String media;

    MediaType(String media){
        this.media = media;
    }

    public String get() {
        return media;
    }
}
