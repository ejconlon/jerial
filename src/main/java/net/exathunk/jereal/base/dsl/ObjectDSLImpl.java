package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

/**
 * charolastra 10/31/12 3:41 AM
 */
public class ObjectDSLImpl<T extends PushableContext<T, U>, U> implements ObjectDSL<T, U> {

    private final T context;
    private final RefMapGroup<T, U> refMapGroup;

    public ObjectDSLImpl(T context) {
        this.context = context;
        refMapGroup = new RefMapGroup<T, U>(Model.OBJECT);
    }

    private PathPart makePart(String key) {
        return PathPart.key(key);
    }

    @Override
    public Ref<ObjectDSL<T, U>> seeObjectStart(String key) {
        final PathPart part = makePart(key);
        Ref<ObjectDSL<T, U>> object = new RefImpl<ObjectDSL<T, U>>(new ObjectDSLImpl(context.push(part)));
        refMapGroup.addObject(part, object);
        return object;
    }

    @Override
    public Ref<ArrayDSL<T, U>> seeArrayStart(String key) {
        final PathPart part = makePart(key);
        Ref<ArrayDSL<T, U>> array = new RefImpl<ArrayDSL<T, U>>(new ArrayDSLImpl(context.push(part)));
        refMapGroup.addArray(part, array);
        return array;
    }

    @Override
    public void seeString(String key, Ref<String> value) {
        refMapGroup.addString(PathPart.key(key), value);
    }

    @Override
    public void seeBoolean(String key, Ref<Boolean> value) {
        refMapGroup.addBoolean(PathPart.key(key), value);
    }

    @Override
    public void seeLong(String key, Ref<Long> value) {
        refMapGroup.addLong(PathPart.key(key), value);
    }

    @Override
    public void seeDouble(String key, Ref<Double> value) {
        refMapGroup.addDouble(PathPart.key(key), value);
    }

    @Override
    public U seeObjectEnd() {
        return context.runResFunc(refMapGroup);
    }
}
