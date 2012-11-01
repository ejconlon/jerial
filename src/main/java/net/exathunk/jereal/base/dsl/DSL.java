package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 10/31/12 2:58 AM
 */
public interface DSL<T extends PushableContext<T, U>, U> {
    ObjectDSL<T, U> seeObject();
    ArrayDSL<T, U> seeArray();
    Writable<U> seeString(Ref<String> value);
    Writable<U> seeBoolean(Ref<Boolean> value);
    Writable<U> seeLong(Ref<Long> value);
    Writable<U> seeDouble(Ref<Double> value);
}
