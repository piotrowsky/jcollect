package org.jcollect.accessors.iterative;

import java.util.List;
import java.util.stream.Stream;

public class IterativeListAccessor<T> implements IterativeAccessor<T> {

    private final List<T> list;
    private int idx = 0;
    private final int size;

    public IterativeListAccessor(List<T> list) {
        this.list = list;
        this.size = list.size();
    }

    public T next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < size;
    }

    public void remove() {
        list.remove(idx);
    }

    public Stream<T> stream() {
        return list.stream();
    }
}
