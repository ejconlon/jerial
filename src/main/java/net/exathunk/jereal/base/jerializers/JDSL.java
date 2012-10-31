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
public interface JDSL {

    void addThing(String key, Ref<JThing> thing, JerialContext context);

    void addBoolean(String key, Ref<Boolean> value, JerialContext context);

    void addLong(String key, Ref<Long> value, JerialContext context);

    void addDouble(String key, Ref<Double> value, JerialContext context);

    void addString(String key, Ref<String> value, JerialContext context);

    <T> void add(JerializerRegistry registry, PathPart part, Ref<T> value, JerialContext context) throws JerializerException;

    void addTypes(String key, List<Schema.TYPE> types, JerialContext context);

    <T> void addMap(JerializerRegistry registry, PathPart part, Ref<Map<String, Ref<T>>> subObjectMap, JerialContext context) throws JerializerException;

    <T> void addSinglyList(JerializerRegistry registry, PathPart part, Ref<List<Ref<T>>> subObjectList, JerialContext context) throws JerializerException;

    <T> void addList(JerializerRegistry registry, PathPart part, Ref<List<Ref<T>>> subObjectList, JerialContext context) throws JerializerException;
}
