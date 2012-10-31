package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.JDSL;

import java.util.ArrayList;
import java.util.List;

/**
 * charolastra 10/31/12 3:41 AM
 */
public class ArrayDSLImpl implements ArrayDSL<JThing> {
    private final JDSL jdsl;
    private final JerialContext context;
    private int index;
    private final RefMapGroup<JThing> refMapGroup;

    public ArrayDSLImpl(JDSL jdsl, JerialContext context) {
        this.jdsl = jdsl;
        this.context = context;
        this.index = 0;
        refMapGroup = new RefMapGroup<JThing>();
    }

    private PathPart makePart() {
        return PathPart.index(index++);
    }

    @Override
    public Ref<ObjectDSL<JThing>> seeObjectStart() {
        final PathPart part = makePart();
        Ref<ObjectDSL<JThing>> object = new RefImpl<ObjectDSL<JThing>>(new ObjectDSLImpl(jdsl, context.push(part)));
        refMapGroup.addObject(part, object);
        return object;
    }

    @Override
    public Ref<ArrayDSL<JThing>> seeArrayStart() {
        final PathPart part = makePart();
        Ref<ArrayDSL<JThing>> array = new RefImpl<ArrayDSL<JThing>>(new ArrayDSLImpl(jdsl, context.push(part)));
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
    public Model getModel() {
        return Model.ARRAY;
    }

    @Override
    public JThing walk() throws WalkException {
        return (new Walker(context, Model.ARRAY, refMapGroup)).walk();
    }
}
