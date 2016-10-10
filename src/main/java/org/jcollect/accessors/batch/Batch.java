package org.jcollect.accessors.batch;

public interface Batch<T> {

    T get();

    boolean isEmpty();
}
