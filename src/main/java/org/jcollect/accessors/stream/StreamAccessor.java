package org.jcollect.accessors.stream;

import java.util.stream.Stream;

public interface StreamAccessor<T> {

    Stream<T> stream();

    void gather(Stream<T> stream);
}
