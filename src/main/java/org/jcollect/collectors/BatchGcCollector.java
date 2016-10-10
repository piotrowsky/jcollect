package org.jcollect.collectors;

import org.jcollect.accessors.batch.Batch;
import org.jcollect.accessors.batch.BatchAccessor;
import org.jcollect.accessors.batch.ListBatchAccessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class BatchGcCollector<T> implements GcCollector {

    protected final BatchAccessor<T> accessor;
    protected final Predicate<Batch<T>> removalPredicate;

    public BatchGcCollector(BatchAccessor<T> accessor, Predicate<Batch<T>> removalPredicate) {
        this.accessor = accessor;
        this.removalPredicate = removalPredicate;
    }

    @Override
    public void collect() {
        for(Batch<T> batch = accessor.nextBatch(); !batch.isEmpty(); ) {
            if (removalPredicate.test(batch)) {
                accessor.remove(batch);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        new BatchGcCollector<List<Integer>>(
                new ListBatchAccessor(list, 2),
                batch -> batch.get().size() > 2).collect();

        System.out.println(list);
    }
}
