package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.ResFunc0;

/**
 * charolastra 10/31/12 3:40 AM
 */
public class DSLImpl<T extends PushableContext<T, U>, U> implements DSL<T, U> {

    private final ResFunc0<T> contextFactory;

    public DSLImpl(ResFunc0<T> contextFactory) {
        this.contextFactory = contextFactory;
    }

    @Override
    public ObjectDSL<T, U> seeObject() {
        return new ObjectDSLImpl(contextFactory.runResFunc());
    }

    @Override
    public ArrayDSL<T, U> seeArray() {
        return new ArrayDSLImpl(contextFactory.runResFunc());
    }

    @Override
    public Writable<U> seeString(Ref<String> value) {
        return new WritableImpl<U>(contextFactory.runResFunc().writeString(value));
    }

    @Override
    public Writable<U> seeBoolean(Ref<Boolean> value) {
        return new WritableImpl<U>(contextFactory.runResFunc().writeBoolean(value));
    }

    @Override
    public Writable<U> seeLong(Ref<Long> value) {
        return new WritableImpl<U>(contextFactory.runResFunc().writeLong(value));
    }

    @Override
    public Writable<U> seeDouble(Ref<Double> value) {
        return new WritableImpl<U>(contextFactory.runResFunc().writeDouble(value));
    }
}
