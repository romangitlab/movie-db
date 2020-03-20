package model.MoviesData;

import model.CommonData.MediaData;

public class MovieData extends MediaData {

    public MovieData(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public MovieData setTitle(String title) {
        this.title = title;

        return this;
    }

    @Override
    public String toString() {
        return "MovieData{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieData movieData = (MovieData) o;

        return title != null ? title.equals(movieData.title) : movieData.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
