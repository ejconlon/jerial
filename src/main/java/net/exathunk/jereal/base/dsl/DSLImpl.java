package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

/**
 * charolastra 10/31/12 3:40 AM
 */
public class DSLImpl<T extends PushableContext<T, U>, U> implements DSL<T, U> {

    private final T context;

    public DSLImpl(T context) {
        this.context = context;
    }

    @Override
    public ObjectDSL<T, U> seeObject() {
        return new ObjectDSLImpl(context);
    }

    @Override
    public ArrayDSL<T, U> seeArray() {
        return new ArrayDSLImpl(context);
    }
}
