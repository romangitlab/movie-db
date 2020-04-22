package constants;

public enum Type {
    MOVIE("movie"),
    TVSHOW("tv");

    private String media;

    Type(String media){
        this.media = media;
    }

    public String get() {
        return media;
    }
}
