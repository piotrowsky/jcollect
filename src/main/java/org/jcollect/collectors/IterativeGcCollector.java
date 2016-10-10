package org.jcollect.collectors;

import org.jcollect.accessors.iterative.IterativeAccessor;

import java.util.function.Predicate;

public class IterativeGcCollector<T> implements GcCollector {

    protected final IterativeAccessor<T> accessor;
    protected final Predicate<T> removalPredicate;

    public IterativeGcCollector(IterativeAccessor<T> accessor, Predicate<T> removalPredicate) {
        this.accessor = accessor;
        this.removalPredicate = removalPredicate;
    }

    public void collect() {
        while (accessor.hasNext()) {
            T element = accessor.next();
            if (removalPredicate.test(element)) {
                accessor.remove();
            }
        }
    }
}
