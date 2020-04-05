package model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Media extends ForwardingSet<MediaData> {

    private Set<MediaData> delegate;

    public Media(){
        this.delegate = new HashSet<MediaData>();
    }

    @Override
    protected Set<MediaData> delegate() {
        return delegate;
    }

    public Media withAdded(MediaData media) {
        this.delegate.add(media);

        return this;
    }

    public Media without(MediaData media) {
        this.delegate.remove(media);

        return this;
    }
}
