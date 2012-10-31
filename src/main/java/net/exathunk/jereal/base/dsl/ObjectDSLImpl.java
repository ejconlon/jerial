package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.JDSL;

/**
 * charolastra 10/31/12 3:41 AM
 */
public class ObjectDSLImpl implements ObjectDSL<JThing> {
    private final JDSL jdsl;
    private final JerialContext context;
    private final RefMapGroup<JThing> refMapGroup;


    public ObjectDSLImpl(JDSL jdsl, JerialContext context) {
        this.jdsl = jdsl;
        this.context = context;
        refMapGroup = new RefMapGroup<JThing>();
    }

    private PathPart makePart(String key) {
        return PathPart.key(key);
    }

    @Override
    public Ref<ObjectDSL<JThing>> seeObjectStart(String key) {
        final PathPart part = makePart(key);
        Ref<ObjectDSL<JThing>> object = new RefImpl<ObjectDSL<JThing>>(new ObjectDSLImpl(jdsl, context.push(part)));
        refMapGroup.addObject(part, object);
        return object;
    }

    @Override
    public Ref<ArrayDSL<JThing>> seeArrayStart(String key) {
        final PathPart part = makePart(key);
        Ref<ArrayDSL<JThing>> array = new RefImpl<ArrayDSL<JThing>>(new ArrayDSLImpl(jdsl, context.push(part)));
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
    public Model getModel() {
        return Model.OBJECT;
    }

    @Override
    public JThing walk() throws WalkException {
        return (new Walker(context, Model.OBJECT, refMapGroup)).walk();
    }
}
