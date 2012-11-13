package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 10/31/12 2:58 AM
 */
public interface ArrayDSL<T extends PushableContext<T, U>, U extends Questionable> extends Pipeable<U> {
    Ref<ObjectDSL<T, U>> seeObjectStart();
    Ref<ArrayDSL<T, U>> seeArrayStart();
    void seeString(Ref<String> value);
    void seeBoolean(Ref<Boolean> value);
    void seeLong(Ref<Long> value);
    void seeDouble(Ref<Double> value);
    // Grr
    void seeCustom(Ref<Pipeable<U>> value);
    void seeList(Ref<Pipeable<U>> value);
}
