package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 10/31/12 2:58 AM
 */
public interface ArrayDSL<T> extends Walkable<T> {
    Ref<ObjectDSL<T>> seeObjectStart();
    Ref<ArrayDSL<T>> seeArrayStart();
    void seeString(Ref<String> value);
    void seeBoolean(Ref<Boolean> value);
    void seeLong(Ref<Long> value);
    void seeDouble(Ref<Double> value);
}
