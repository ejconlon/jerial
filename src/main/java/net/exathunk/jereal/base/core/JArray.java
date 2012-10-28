package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * charolastra 10/27/12 11:55 PM
 */
public class JArray implements JMutableCollection<Integer, JThing> {

    private final List<JThing> array;

    public JArray() {
        this.array = new ArrayList<JThing>();
    }

    public JArray(List<JThing> array) {
        this.array = array;
    }

    @Override
    public boolean set(Integer key, JThing value) {
        final int len = array.size();
        if (key == null || key == len) {
            array.add(value);
            return true;
        } else if (key >= 0 && key < len) {
            array.set(key, value);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Integer key) {
        if (containsKey(key)) {
            array.remove((int)key);
            return true;
        }
        return false;
    }

    @Override
    public Sequence<Map.Entry<Integer, JThing>> seq() {
        return new IndexedSequence<JThing>(new ListSequence<JThing>(array));
    }

    @Override
    public boolean containsKey(Integer key) {
        return (key != null && key >= 0 && key < array.size());
    }

    @Override
    public Maybe<JThing> get(Integer key) {
        if (containsKey(key)) {
            return Maybe.just(array.get(key));
        } else {
            return Maybe.nothing();
        }
    }
}
