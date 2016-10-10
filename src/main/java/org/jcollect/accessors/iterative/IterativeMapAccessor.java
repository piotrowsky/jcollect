package org.jcollect.accessors.iterative;

import java.util.Iterator;
import java.util.Map;

public class IterativeMapAccessor<K, V> implements IterativeAccessor<Map.Entry<K,V>> {

    private final Iterator<Map.Entry<K, V>> entries;

    public IterativeMapAccessor(Map<K, V> map) {
        this.entries = map.entrySet().iterator();
    }

    @Override
    public Map.Entry<K,V> next() {
        return entries.next();
    }

    @Override
    public boolean hasNext() {
        return entries.hasNext();
    }

    @Override
    public void remove() {
        entries.remove();
    }
}
