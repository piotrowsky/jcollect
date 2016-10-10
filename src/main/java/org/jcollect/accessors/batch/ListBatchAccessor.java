package org.jcollect.accessors.batch;

import java.util.Collections;
import java.util.List;

public class ListBatchAccessor<T> implements BatchAccessor<List<T>> {

    private final List<T> list;
    private final int size;
    private final int batchSize;
    private int idx = 0;
    private boolean done = false;
    private final Batch<List<T>> EMPTY_BATCH = new ListBatch<>(Collections.<T>emptyList());

    public ListBatchAccessor(List<T> list, int batchSize) {
        this.list = list;
        this.size = list.size();
        this.batchSize = batchSize;
    }

    @Override
    public Batch<List<T>> nextBatch() {
        if (done) {
            return EMPTY_BATCH;
        }

        int start = idx;
        int end = idx + batchSize - 1;

        if (end < size) {
            idx += batchSize;
        } else {
            end = size - 1;
            idx = end;
            done = true;
        }

        return new ListBatch<>(list.subList(start, end));
    }

    @Override
    public void remove(Batch<List<T>> batch) {
        list.removeAll(batch.get());
    }

    public class ListBatch<T> implements Batch<List<T>> {

        private final List<T> list;

        private ListBatch(List<T> list) {
            this.list = list;
        }

        @Override
        public List<T> get() {
            return list;
        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
}