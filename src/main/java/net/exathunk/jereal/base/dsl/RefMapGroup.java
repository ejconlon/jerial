package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Pair;
import net.exathunk.jereal.base.functional.Ref;

import java.util.*;

/**
 * charolastra 10/31/12 1:22 PM
 */
public class RefMapGroup<T extends PushableContext<T, U>, U extends Questionable> {

    public static enum WModel {
        OBJECT, ARRAY, STRING, BOOLEAN, LONG, DOUBLE, WRITABLE;

        public static WModel fromModel(Model model) {
            switch (model) {
                case OBJECT:
                    return WModel.OBJECT;
                case ARRAY:
                    return WModel.ARRAY;
                case STRING:
                    return WModel.STRING;
                case BOOLEAN:
                    return WModel.BOOLEAN;
                case LONG:
                    return WModel.LONG;
                case DOUBLE:
                    return WModel.DOUBLE;
            }
            throw new IllegalArgumentException("Unmapped model: "+model);
        }
    }

    private final RefMap<PathPart, String> strings = new RefMap<PathPart, String>();
    private final RefMap<PathPart, Boolean> booleans = new RefMap<PathPart, Boolean>();
    private final RefMap<PathPart, Long> longs = new RefMap<PathPart, Long>();
    private final RefMap<PathPart, Double> doubles = new RefMap<PathPart, Double>();
    private final RefMap<PathPart, ObjectDSL<T, U>> objects = new RefMap<PathPart, ObjectDSL<T, U>>();
    private final RefMap<PathPart, ArrayDSL<T, U>> arrays = new RefMap<PathPart, ArrayDSL<T, U>>();
    private final RefMap<PathPart, Pipeable<U>> writables = new RefMap<PathPart, Pipeable<U>>();
    private final List<Map.Entry<PathPart, WModel>> order = new ArrayList<Map.Entry<PathPart, WModel>>();
    private final Map<PathPart, Set<WModel>> parts = new TreeMap<PathPart, Set<WModel>>();
    private final WModel model;

    public RefMapGroup(WModel model) {
        this.model = model;
    }

    public WModel getModel() {
        return model;
    }

    public Set<WModel> getModels(PathPart part) {
        return parts.get(part);
    }

    private void add(PathPart part, WModel model) {
        Set<WModel> models = parts.get(part);
        if (models == null) {
            models = new TreeSet<WModel>();
            parts.put(part, models);
        }
        if (models.contains(model)) {
            throw new IllegalArgumentException("Cannot add duplicate key: "+part+" "+model);
        }
        models.add(model);
        order.add(new Pair<PathPart, WModel>(part, model));
    }

    public void addObject(PathPart part, Ref<ObjectDSL<T, U>> value) {
        objects.put(part, value);
        add(part, WModel.OBJECT);
    }


    public void addArray(PathPart part, Ref<ArrayDSL<T, U>> value) {
        arrays.put(part, value);
        add(part, WModel.ARRAY);
    }

    public void addString(PathPart part, Ref<String> value) {
        strings.put(part, value);
        add(part, WModel.STRING);
    }

    public void addBoolean(PathPart part, Ref<Boolean> value) {
        booleans.put(part, value);
        add(part, WModel.BOOLEAN);
    }

    public void addDouble(PathPart part, Ref<Double> value) {
        doubles.put(part, value);
        add(part, WModel.DOUBLE);
    }

    public void addLong(PathPart part, Ref<Long> value) {
        longs.put(part, value);
        add(part, WModel.LONG);
    }

    public void addWritable(PathPart part, Ref<Pipeable<U>> value) {
        writables.put(part, value);
        add(part, WModel.WRITABLE);
    }

    public RefMap<PathPart, ObjectDSL<T, U>>  getObjects() {
        return objects;
    }

    public RefMap<PathPart, ArrayDSL<T, U>> getArrays() {
        return arrays;
    }

    public RefMap<PathPart, String> getStrings() {
        return strings;
    }

    public RefMap<PathPart, Boolean> getBooleans() {
        return booleans;
    }

    public RefMap<PathPart, Long> getLongs() {
        return longs;
    }

    public RefMap<PathPart, Double> getDoubles() {
        return doubles;
    }

    public RefMap<PathPart, Pipeable<U>> getWritables() {
        return writables;
    }

    public List<Map.Entry<PathPart, WModel>> getOrders() {
        return order;
    }

}
