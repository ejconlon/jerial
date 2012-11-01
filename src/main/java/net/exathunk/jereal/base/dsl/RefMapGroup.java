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

    public static enum WModel {
        OBJECT, ARRAY, STRING, BOOLEAN, LONG, DOUBLE, WRITABLE
    }

    private final RefMap<PathPart, String> strings = new RefMap<PathPart, String>();
    private final RefMap<PathPart, Boolean> booleans = new RefMap<PathPart, Boolean>();
    private final RefMap<PathPart, Long> longs = new RefMap<PathPart, Long>();
    private final RefMap<PathPart, Double> doubles = new RefMap<PathPart, Double>();
    private final RefMap<PathPart, ObjectDSL<T, U>> objects = new RefMap<PathPart, ObjectDSL<T, U>>();
    private final RefMap<PathPart, ArrayDSL<T, U>> arrays = new RefMap<PathPart, ArrayDSL<T, U>>();
    private final RefMap<PathPart, Writable<U>> writables = new RefMap<PathPart, Writable<U>>();
    private final List<WModel> order = new ArrayList<WModel>();
    private final WModel model;

    public RefMapGroup(WModel model) {
        this.model = model;
    }

    public WModel getModel() {
        return model;
    }

    public void addObject(PathPart part, Ref<ObjectDSL<T, U>> value) {
        if (value.isEmptyRef()) return;
        objects.put(part, value);
        order.add(WModel.OBJECT);
    }

    public void addArray(PathPart part, Ref<ArrayDSL<T, U>> value) {
        if (value.isEmptyRef()) return;
        arrays.put(part, value);
        order.add(WModel.ARRAY);
    }

    public void addString(PathPart part, Ref<String> value) {
        if (value.isEmptyRef()) return;
        strings.put(part, value);
        order.add(WModel.STRING);
    }

    public void addBoolean(PathPart part, Ref<Boolean> value) {
        if (value.isEmptyRef()) return;
        booleans.put(part, value);
        order.add(WModel.BOOLEAN);
    }

    public void addDouble(PathPart part, Ref<Double> value) {
        if (value.isEmptyRef()) return;
        doubles.put(part, value);
        order.add(WModel.DOUBLE);
    }

    public void addLong(PathPart part, Ref<Long> value) {
        if (value.isEmptyRef()) return;
        longs.put(part, value);
        order.add(WModel.LONG);
    }

    public void addWritable(PathPart part, Ref<Writable<U>> value) {
        if (value.isEmptyRef()) return;
        writables.put(part, value);
        order.add(WModel.WRITABLE);
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

    public Iterable<Map.Entry<PathPart, Ref<Writable<U>>>> writableIterable() {
        return writables;
    }

    public Iterable<WModel> orderIterable() {
        return order;
    }

}
