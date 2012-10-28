package net.exathunk.jereal.base.functional;

import java.util.Iterator;
import java.util.Map;

/**
 * charolastra 10/28/12 1:11 AM
 */
public class KeySequence<A, B> implements Sequence<A> {
    private final Map<A, B> map;

    public KeySequence(Map<A, B> map) {
        this.map = map;
    }

    @Override
    public Iterator<A> iterator() {
        return map.keySet().iterator();
    }
}
