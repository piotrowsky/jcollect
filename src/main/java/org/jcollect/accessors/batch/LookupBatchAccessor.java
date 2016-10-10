package org.jcollect.accessors.batch;

public interface LookupBatchAccessor<T> extends BatchAccessor<T> {

    boolean hasNext();
}
