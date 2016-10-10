package org.jcollect.accessors.iterative;

import org.jcollect.accessors.batch.ListBatchAccessor;
import org.skife.jdbi.v2.DBI;

// TODO
public class IterativeDatabaseAccessor<T> implements IterativeAccessor<T> {

    private ListBatchAccessor<T> batchAccessor;

    public IterativeDatabaseAccessor(String url, String username, String pass, int batchSize) {
        DBI dbi = new DBI(url, username, pass);
        this.batchAccessor = new ListBatchAccessor<>(null, batchSize);
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void remove() {

    }
}
