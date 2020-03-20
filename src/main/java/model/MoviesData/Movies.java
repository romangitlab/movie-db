package model.MoviesData;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Movies extends ForwardingSet<MovieData> {

    private Set<MovieData> delegate;

    public Movies(){
        this.delegate = new HashSet<MovieData>();
    }

    @Override
    protected Set<MovieData> delegate() {
        return delegate;
    }

    public Movies withAdded(MovieData movie) {
        this.delegate.add(movie);

        return this;
    }

    public Movies without(MovieData movie) {
        this.delegate.remove(movie);

        return this;
    }
}
