package constants;

public enum Page {
    FAVORITE("favorite"),
    WATCHLIST("watchlist"),
    RATING("rating");

    private String page;

    Page(String page){
        this.page = page;
    }

    public String get() {
        return page;
    }
}
