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
    public Writable<U> seeString(final Ref<String> value) {
        return new Writable<U>() {
            @Override
            public void writeTo(Ref<U> ref) {
                contextFactory.runResFunc().writeString(value, ref);
            }
        };
    }

    @Override
    public Writable<U> seeBoolean(final Ref<Boolean> value) {
        return new Writable<U>() {
            @Override
            public void writeTo(Ref<U> ref) {
                contextFactory.runResFunc().writeBoolean(value, ref);
            }
        };
    }

    @Override
    public Writable<U> seeLong(final Ref<Long> value) {
        return new Writable<U>() {
            @Override
            public void writeTo(Ref<U> ref) {
                contextFactory.runResFunc().writeLong(value, ref);
            }
        };
    }

    @Override
    public Writable<U> seeDouble(final Ref<Double> value) {
        return new Writable<U>() {
            @Override
            public void writeTo(Ref<U> ref) {
                contextFactory.runResFunc().writeDouble(value, ref);
            }
        };
    }
}
