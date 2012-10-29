package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.*;

import java.util.Map;

public class ObjectPartAdapter implements JMutableCollection<PathPart, JThing> {

    private final JObject object;

    public ObjectPartAdapter(JObject object) {
        this.object = object;
    }

    @Override
    public boolean set(PathPart key, JThing value) {
        if (key.hasLeft()) {
            return object.set(key.getLeft(), value);
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(PathPart key) {
        if (key.hasLeft()) {
            return object.remove(key.getLeft());
        } else {
            return false;
        }
    }

    @Override
    public Sequence<Map.Entry<PathPart, JThing>> seq() {
        return FuncUtils.fmap(new ResFunc1<Map.Entry<String, JThing>, Map.Entry<PathPart, JThing>>() {
            @Override
            public Map.Entry<PathPart, JThing> runResFunc(Map.Entry<String, JThing> entry) {
                return new Pair<PathPart, JThing>(PathPart.key(entry.getKey()), entry.getValue());
            }
        }, object.seq());
    }

    @Override
    public boolean containsKey(PathPart key) {
        if (key.hasLeft()) {
            return object.containsKey(key.getLeft());
        } else {
            return false;
        }
    }

    @Override
    public Maybe<JThing> get(PathPart key) {
        if (key.hasLeft()) {
            return object.get(key.getLeft());
        } else {
            return Maybe.nothing();
        }
    }
}