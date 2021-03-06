package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.MapSequence;
import net.exathunk.jereal.base.functional.Maybe;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.functional.Sequence;

import java.util.ArrayList;
import java.util.List;
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
    public void acceptTyped(Path path, TypedVisitor visitor) throws VisitException {
        if (!visitor.visitObjectStart(path, this)) return;
        for (Map.Entry<String, JThing> entry : map.entrySet()) {
            entry.getValue().acceptTyped(path.cons(PathPart.key(entry.getKey())), visitor);
        }
        visitor.visitObjectEnd(path, this);
    }

    @Override
    public <A extends PushableContext<A, B>, B extends Questionable> Pipeable<B> acceptDSL(DSL<A, B> dsl) {
        ObjectDSL<A, B> objectDSL = dsl.seeObject();
        for (Map.Entry<String, JThing> entry : seq()) {
            Pipeable<B> pipeable = entry.getValue().acceptDSL(dsl);
            objectDSL.seeCustom(entry.getKey(), new RefImpl<Pipeable<B>>(pipeable));
        }
        return objectDSL;
    }

    @Override
    public Model getModel() {
        return Model.OBJECT;
    }

    @Override
    public JThing toJThing() {
        return JThing.make(this);
    }

    @Override
    public boolean hasMapSpec() {
        return true;
    }

    @Override
    public Map<String, ? extends Speclike> getMapSpec() {
        return map;
    }

    @Override
    public boolean hasListSpec() {
        return false;
    }

    @Override
    public List<? extends Speclike> getListSpec() {
        return null;
    }

    @Override
    public Speclike makeSpec() {
        return this;
    }

    public static JObject fromSpec(Map<String, ? extends Speclike> mapSpec) {
        final Map<String, JThing> map = new TreeMap<String, JThing>();
        for (Map.Entry<String, ? extends Speclike> entry : mapSpec.entrySet()) {
            map.put(entry.getKey(), JThing.fromSpec(entry.getValue()));
        }
        return new JObject(map);
    }
}
