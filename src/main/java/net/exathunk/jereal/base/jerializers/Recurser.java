package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Writable;
import net.exathunk.jereal.base.functional.Ref;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/31/12 3:37 PM
 */
public interface Recurser<T extends PushableContext<T, U>, U> {
    <V> Ref<Writable<U>> seeCustom(DSL<T, U> dsl, Ref<V> domain) throws JerializerException;
    <V> Ref<Writable<U>> seeCustomMap(DSL<T, U> dsl, Ref<Map<String, V>> domain) throws JerializerException;
    <V> Ref<Writable<U>> seeCustomList(DSL<T, U> dsl, Ref<List<V>> domain) throws JerializerException;
    Ref<Writable<U>> seeSimpleMap(DSL<T, U> dsl, Ref<Map<String, String>> domain);
    Ref<Writable<U>> seeThing(DSL<T, U> dsl, Ref<JThing> domain);
}
