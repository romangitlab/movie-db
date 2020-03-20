package model.TvShowData;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class TvShow extends ForwardingSet<TvShowData> {

    private Set<TvShowData> delegate;

    public TvShow(){
        this.delegate = new HashSet<TvShowData>();
    }

    @Override
    protected Set<TvShowData> delegate() {
        return delegate;
    }

    public TvShow withAdded(TvShowData tv) {
        this.delegate.add(tv);

        return this;
    }

    public TvShow without(TvShowData tv) {
        this.delegate.remove(tv);

        return this;
    }
}
