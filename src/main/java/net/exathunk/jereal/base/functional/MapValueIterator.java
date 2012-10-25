package net.exathunk.jereal.base.functional;

import java.util.Iterator;
import java.util.Map;

/**
 * charolastra 10/25/12 10:52 AM
 */
public class MapValueIterator<K, V> implements Iterator<V> {

    private final Iterator<Map.Entry<K, V>> it;

    public MapValueIterator(Iterator<Map.Entry<K, V>> it) {
        this.it = it;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public V next() {
        return it.next().getValue();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
