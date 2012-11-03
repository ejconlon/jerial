package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * charolastra 10/27/12 11:55 PM
 */
public class JArray implements JMutableCollection<Integer, JThing> {

    private final List<JThing> array;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JArray jArray = (JArray) o;

        if (array != null ? !array.equals(jArray.array) : jArray.array != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return array != null ? array.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "JArray{" +
                "array=" + array +
                '}';
    }

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

    @Override
    public void acceptTyped(Path path, TypedVisitor visitor) throws VisitException {
        if (!visitor.visitArrayStart(path, this)) return;
        for (Map.Entry<Integer, JThing> entry : seq()) {
            entry.getValue().acceptTyped(path.cons(PathPart.index(entry.getKey())), visitor);
        }
        visitor.visitArrayEnd(path, this);
    }

    @Override
    public <A extends PushableContext<A, B>, B extends Questionable> Pipeable<B> acceptDSL(DSL<A, B> dsl) {
        ArrayDSL<A, B> arrayDSL = dsl.seeArray();
        for (Map.Entry<Integer, JThing> entry : seq()) {
            Pipeable<B> pipeable = entry.getValue().acceptDSL(dsl);
            arrayDSL.seeWritable(new RefImpl<Pipeable<B>>(pipeable));
        }
        return arrayDSL;
    }

    @Override
    public Model getModel() {
        return Model.ARRAY;
    }

    @Override
    public JThing toJThing() {
        return JThing.make(this);
    }

    @Override
    public boolean hasMapSpec() {
        return false;
    }

    @Override
    public Map<String, ? extends Speclike> getMapSpec() {
        return null;
    }

    @Override
    public boolean hasListSpec() {
        return true;
    }

    @Override
    public List<? extends Speclike> getListSpec() {
        return array;
    }

    @Override
    public Speclike makeSpec() {
        return this;
    }

    public static JArray fromSpec(List<? extends Speclike> listSpec) {
        final List<JThing> list = new ArrayList<JThing>(listSpec.size());
        for (Speclike value : listSpec) {
            list.add(JThing.fromSpec(value));
        }
        return new JArray(list);
    }
}
