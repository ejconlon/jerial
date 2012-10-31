package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.schema.domain.Schema;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/30/12 8:57 PM
 */
public interface JDSL<C> {

    void addThing(PathPart part, Ref<JThing> thing, C context);

    void addBoolean(String key, Ref<Boolean> value, C context);

    void addLong(String key, Ref<Long> value, C context);

    void addDouble(String key, Ref<Double> value, C context);

    void addString(String key, Ref<String> value, C context);

    <T> void add(JerializerRegistry<C> registry, PathPart part, Ref<T> value, C context) throws JerializerException;

    void addTypes(String key, List<Schema.TYPE> types, C context);

    <T> void addMap(JerializerRegistry<C> registry, PathPart part, Ref<Map<String, Ref<T>>> subObjectMap, C context) throws JerializerException;

    <T> void addSinglyList(JerializerRegistry<C> registry, PathPart part, Ref<List<Ref<T>>> subObjectList, C context) throws JerializerException;

    <T> void addList(JerializerRegistry<C> registry, PathPart part, Ref<List<Ref<T>>> subObjectList, C context) throws JerializerException;
}
