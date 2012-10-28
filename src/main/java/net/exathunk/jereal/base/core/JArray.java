package net.exathunk.jereal.base.core;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * charolastra 10/27/12 11:55 PM
 */
public class JArray implements Iterable<Map.Entry<Integer, Jitem>> {

    private final List<Jitem> array;

    public JArray(List<Jitem> array) {
        this.array = array;
    }

    @Override
    public Iterator<Map.Entry<Integer, Jitem>> iterator() {
        return null;
    }
}
