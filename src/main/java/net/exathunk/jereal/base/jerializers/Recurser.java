package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.functional.Ref;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/31/12 3:37 PM
 */
public interface Recurser<T extends PushableContext<T, U>, U> {
    <V> void seeCustom(ObjectDSL<T, U> dsl, String key, Ref<V> domain) throws JerializerException;
    <V> void seeCustomMap(ObjectDSL<T, U> dsl, String key, Ref<Map<String, V>> domain) throws JerializerException;
    <V> void seeCustomList(ObjectDSL<T, U> dsl, String key, Ref<List<V>> domain) throws JerializerException;
    void seeSimpleMap(ObjectDSL<T, U> dsl, String key, Ref<Map<String, String>> domain);
    void seeThing(ObjectDSL<T, U> dsl, String key, Ref<JThing> domain);
}
