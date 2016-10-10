package org.jcollect.accessors.iterative;

public interface IterativeAccessor<T> {

    T next();

    boolean hasNext();

    void remove();
}
