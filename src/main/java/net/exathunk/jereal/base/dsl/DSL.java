package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 10/31/12 2:58 AM
 */
public interface DSL<T> {
    Ref<ObjectDSL<T>> seeObject();
    Ref<ArrayDSL<T>> seeArray();
}
