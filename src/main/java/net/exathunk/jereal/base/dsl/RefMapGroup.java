package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * charolastra 10/31/12 1:22 PM
 */
public class RefMapGroup<T extends PushableContext<T, U>, U> {
    private final RefMap<PathPart, String> strings = new RefMap<PathPart, String>();
    private final RefMap<PathPart, Boolean> booleans = new RefMap<PathPart, Boolean>();
    private final RefMap<PathPart, Long> longs = new RefMap<PathPart, Long>();
    private final RefMap<PathPart, Double> doubles = new RefMap<PathPart, Double>();
    private final RefMap<PathPart, ObjectDSL<T, U>> objects = new RefMap<PathPart, ObjectDSL<T, U>>();
    private final RefMap<PathPart, ArrayDSL<T, U>> arrays = new RefMap<PathPart, ArrayDSL<T, U>>();
    private final List<Model> order = new ArrayList<Model>();
    private final Model model;

    public RefMapGroup(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void addObject(PathPart part, Ref<ObjectDSL<T, U>> value) {
        objects.put(part, value);
        order.add(Model.OBJECT);
    }

    public void addArray(PathPart part, Ref<ArrayDSL<T, U>> value) {
        arrays.put(part, value);
        order.add(Model.ARRAY);
    }

    public void addString(PathPart part, Ref<String> value) {
        strings.put(part, value);
        order.add(Model.STRING);
    }

    public void addBoolean(PathPart part, Ref<Boolean> value) {
        booleans.put(part, value);
        order.add(Model.BOOLEAN);
    }

    public void addDouble(PathPart part, Ref<Double> value) {
        doubles.put(part, value);
        order.add(Model.DOUBLE);
    }

    public void addLong(PathPart part, Ref<Long> value) {
        longs.put(part, value);
        order.add(Model.LONG);
    }

    public Iterable<Map.Entry<PathPart, Ref<ObjectDSL<T, U>>>> objectIterable() {
        return objects;
    }

    public Iterable<Map.Entry<PathPart, Ref<ArrayDSL<T, U>>>> arrayIterable() {
        return arrays;
    }

    public Iterable<Map.Entry<PathPart, Ref<String>>> stringIterable() {
        return strings;
    }

    public Iterable<Map.Entry<PathPart, Ref<Boolean>>> booleanIterable() {
        return booleans;
    }

    public Iterable<Map.Entry<PathPart, Ref<Long>>> longIterable() {
        return longs;
    }

    public Iterable<Map.Entry<PathPart, Ref<Double>>> doubleIterable() {
        return doubles;
    }

    public Iterable<Model> orderIterable() {
        return order;
    }

}
