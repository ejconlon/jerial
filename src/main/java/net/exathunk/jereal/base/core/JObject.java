package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.MapSequence;
import net.exathunk.jereal.base.functional.Maybe;
import net.exathunk.jereal.base.functional.Sequence;

import java.util.Map;
import java.util.TreeMap;

/**
 * charolastra 10/28/12 1:34 AM
 */
public class JObject implements JMutableCollection<String, JThing> {

    private final Map<String, JThing> map;

    @Override
    public String toString() {
        return "JObject{" +
                "map=" + map +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JObject jObject = (JObject) o;

        if (map != null ? !map.equals(jObject.map) : jObject.map != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return map != null ? map.hashCode() : 0;
    }

    public JObject() {
        this.map = new TreeMap<String, JThing>();
    }

    public JObject(Map<String, JThing> map) {
        this.map = map;
    }

    @Override
    public boolean set(String key, JThing value) {
        map.put(key, value);
        return true;
    }

    @Override
    public boolean remove(String key) {
        map.remove(key);
        return true;
    }

    @Override
    public Sequence<Map.Entry<String, JThing>> seq() {
        return new MapSequence<String, JThing>(map);
    }

    @Override
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    @Override
    public Maybe<JThing> get(String key) {
        JThing value = map.get(key);
        if (value != null) {
            return Maybe.just(value);
        } else {
            return Maybe.nothing();
        }
    }

    @Override
    public void accept(Path path, TypedVisitor visitor) throws VisitException {
        visitor.visitObjectStart(path, this);
        for (Map.Entry<String, JThing> entry : map.entrySet()) {
            entry.getValue().accept(path.cons(PathPart.key(entry.getKey())), visitor);
        }
        visitor.visitObjectEnd(path, this);
    }
}
