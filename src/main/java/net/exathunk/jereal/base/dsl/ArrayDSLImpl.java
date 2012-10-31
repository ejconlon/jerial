package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

/**
 * charolastra 10/31/12 3:41 AM
 */
public class ArrayDSLImpl<T extends PushableContext<T, U>, U> implements ArrayDSL<T, U> {
    private final T context;
    private int index;
    private final RefMapGroup<T, U> refMapGroup;

    public ArrayDSLImpl(T context) {
        this.context = context;
        this.index = 0;
        refMapGroup = new RefMapGroup<T, U>(Model.ARRAY);
    }

    private PathPart makePart() {
        return PathPart.index(index++);
    }

    @Override
    public Ref<ObjectDSL<T, U>> seeObjectStart() {
        final PathPart part = makePart();
        Ref<ObjectDSL<T, U>> object = new RefImpl<ObjectDSL<T, U>>(new ObjectDSLImpl(context.push(part)));
        refMapGroup.addObject(part, object);
        return object;
    }

    @Override
    public Ref<ArrayDSL<T, U>> seeArrayStart() {
        final PathPart part = makePart();
        Ref<ArrayDSL<T, U>> array = new RefImpl<ArrayDSL<T, U>>(new ArrayDSLImpl(context.push(part)));
        refMapGroup.addArray(part, array);
        return array;
    }

    @Override
    public void seeString(Ref<String> value) {
        refMapGroup.addString(makePart(), value);
    }

    @Override
    public void seeBoolean(Ref<Boolean> value) {
        refMapGroup.addBoolean(makePart(), value);
    }

    @Override
    public void seeLong(Ref<Long> value) {
        refMapGroup.addLong(makePart(), value);
    }

    @Override
    public void seeDouble(Ref<Double> value) {
        refMapGroup.addDouble(makePart(), value);
    }

    @Override
    public U seeArrayEnd() {
        return context.runResFunc(refMapGroup);
    }
}
