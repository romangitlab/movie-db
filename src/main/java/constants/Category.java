package constants;

public enum Category {
    TOP("top_rated"),
    POPULAR("popular"),
    UPCOMING("upcoming"),
    NOW("now_playing");

    private String media;

    Category(String media){
        this.media = media;
    }

    public String get() {
        return media;
    }
}
