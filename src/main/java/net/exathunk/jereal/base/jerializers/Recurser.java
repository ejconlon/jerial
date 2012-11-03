package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Pipeable;
import net.exathunk.jereal.base.dsl.Questionable;
import net.exathunk.jereal.base.functional.Ref;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/31/12 3:37 PM
 */
public interface Recurser<T extends PushableContext<T, U>, U extends Questionable> {
    <V> Pipeable<U> seeCustom(DSL<T, U> dsl, Ref<V> domain, Class<V> klass) throws JerializerException;
    <V> Pipeable<U> seeCustomMap(DSL<T, U> dsl, Ref<Map<String, V>> domain, Class<V> klass) throws JerializerException;
    <V> Pipeable<U> seeCustomList(DSL<T, U> dsl, Ref<List<V>> domain, Class<V> klass) throws JerializerException;
    Pipeable<U> seeSimpleMap(DSL<T, U> dsl, Ref<Map<String, Ref<String>>> domain);
    Pipeable<U> seeThing(DSL<T, U> dsl, Ref<JThing> domain);
}
