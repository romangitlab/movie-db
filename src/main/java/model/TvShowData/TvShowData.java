package model.TvShowData;

import model.CommonData.MediaData;

public class TvShowData extends MediaData{

    public TvShowData(){}

    public String getName() {
        return name;
    }

    public TvShowData setName(String name) {
        this.name = name;

        return this;
    }

    public String getTitle() {
        return title;
    }

    public TvShowData setTitle(String title) {
        this.title = title;

        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TvShowData{" +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TvShowData that = (TvShowData) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
