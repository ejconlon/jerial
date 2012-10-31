package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.JDSL;

/**
 * charolastra 10/31/12 3:40 AM
 */
public class DSLImpl implements DSL<JThing> {

    private final JDSL jdsl;
    private final JerialContext context;

    public DSLImpl(JDSL jdsl, JerialContext context) {
        this.jdsl = jdsl;
        this.context = context;
    }

    @Override
    public Ref<ObjectDSL<JThing>> seeObject() {
        return new RefImpl<ObjectDSL<JThing>>(new ObjectDSLImpl(jdsl, context));
    }

    @Override
    public Ref<ArrayDSL<JThing>> seeArray() {
        return new RefImpl<ArrayDSL<JThing>>(new ArrayDSLImpl(jdsl, context));
    }
}
