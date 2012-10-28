package net.exathunk.jereal.base.functional;

import java.util.Iterator;
import java.util.Map;

/**
 * charolastra 10/28/12 12:47 AM
 */
public class MapSequence<A, B> implements Sequence<Map.Entry<A, B>> {

    private final Map<A, B> map;

    public MapSequence(Map<A, B> map) {
        this.map = map;
    }

    @Override
    public Iterator<Map.Entry<A, B>> iterator() {
        return map.entrySet().iterator();
    }
}
