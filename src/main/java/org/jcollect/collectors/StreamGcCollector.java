package org.jcollect.collectors;

import org.jcollect.accessors.stream.StreamAccessor;
import java.util.function.Predicate;

public class StreamGcCollector<T> implements GcCollector {

    protected final StreamAccessor<T> accessor;
    protected final Predicate<T> removalPredicate;

    public StreamGcCollector(StreamAccessor<T> accessor, Predicate<T> removalPredicate) {
        this.accessor = accessor;
        this.removalPredicate = removalPredicate;
    }

    @Override
    public void collect() {
         accessor.gather(
                 accessor.stream()
                         .filter(removalPredicate));
    }
}
