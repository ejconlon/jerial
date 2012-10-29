package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.*;

import java.util.Map;

/**
 * charolastra 10/28/12 4:58 AM
 */
public class ArrayPartAdapter implements JMutableCollection<PathPart, JThing> {

    private final JArray array;

    public ArrayPartAdapter(JArray array) {
        this.array = array;
    }

    @Override
    public boolean set(PathPart key, JThing value) {
        if (key.hasRight()) {
            return array.set(key.getRight(), value);
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(PathPart key) {
        if (key.hasRight()) {
            return array.remove(key.getRight());
        } else {
            return false;
        }
    }

    @Override
    public Sequence<Map.Entry<PathPart, JThing>> seq() {
        return FuncUtils.fmap(new ResFunc1<Map.Entry<Integer, JThing>, Map.Entry<PathPart, JThing>>() {
            @Override
            public Map.Entry<PathPart, JThing> runResFunc(Map.Entry<Integer, JThing> entry) {
                return new Pair<PathPart, JThing>(PathPart.index(entry.getKey()), entry.getValue());
            }
        }, array.seq());
    }

    @Override
    public boolean containsKey(PathPart key) {
        if (key.hasRight()) {
            return array.containsKey(key.getRight());
        } else {
            return false;
        }
    }

    @Override
    public Maybe<JThing> get(PathPart key) {
        if (key.hasRight()) {
            return array.get(key.getRight());
        } else {
            return Maybe.nothing();
        }
    }
}
