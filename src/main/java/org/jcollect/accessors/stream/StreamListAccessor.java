package org.jcollect.accessors.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamListAccessor<T> implements StreamAccessor<T> {

    private List<T> list;

    public StreamListAccessor(List<T> list) {
        this.list = list;
    }

    @Override
    public Stream<T> stream() {
        return list.stream();
    }

    @Override
    public void gather(Stream<T> stream) {
        list = stream.collect(Collectors.<T>toList());
    }

}
