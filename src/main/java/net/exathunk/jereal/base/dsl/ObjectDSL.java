package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 10/31/12 2:58 AM
 */
public interface ObjectDSL<T extends PushableContext<T, U>, U> extends Pipeable<U> {
    Ref<ObjectDSL<T, U>> seeObjectStart(String key);
    Ref<ArrayDSL<T, U>> seeArrayStart(String key);
    void seeString(String key, Ref<String> value);
    void seeBoolean(String key, Ref<Boolean> value);
    void seeLong(String key, Ref<Long> value);
    void seeDouble(String key, Ref<Double> value);
    void seeWritable(String key, Ref<Pipeable<U>> value);
}
