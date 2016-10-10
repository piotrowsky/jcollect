package org.jcollect.accessors.stream;

import java.util.Map;
import java.util.stream.Stream;

public class StreamMapAccessor<K, V> implements StreamAccessor<Map.Entry<K, V>> {

    private Map<K, V> map;

    public StreamMapAccessor(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public Stream<Map.Entry<K, V>> stream() {
        return map.entrySet().stream();
    }

    @Override
    public void gather(Stream<Map.Entry<K, V>> stream) {
        // TODO
    }
}
