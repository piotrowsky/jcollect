package org.jcollect.accessors.batch;

public interface BatchAccessor<T> {

    Batch<T> nextBatch();

    void remove(Batch<T> batch);
}
