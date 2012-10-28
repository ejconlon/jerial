package net.exathunk.jereal.base.functional;

import java.util.Iterator;
import java.util.Map;

/**
 * charolastra 10/28/12 1:11 AM
 */
public class ValueSequence<A, B> implements Sequence<B> {
    private final Map<A, B> map;

    public ValueSequence(Map<A, B> map) {
        this.map = map;
    }

    @Override
    public Iterator<B> iterator() {
        return map.values().iterator();
    }
}
