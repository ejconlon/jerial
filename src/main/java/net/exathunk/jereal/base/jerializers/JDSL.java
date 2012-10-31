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

    void addThing(PathPart part, Ref<JThing> thing);

    void addBoolean(String key, Ref<Boolean> value);

    void addLong(String key, Ref<Long> value);

    void addDouble(String key, Ref<Double> value);

    void addString(String key, Ref<String> value);

    <T> void add(PathPart part, Ref<T> value) throws JerializerException;

    void addTypes(String key, List<Schema.TYPE> types);

    <T> void addMap(PathPart part, Ref<Map<String, T>> subObjectMap) throws JerializerException;

    <T> void addSinglyList(PathPart part, Ref<List<T>> subObjectList) throws JerializerException;

    <T> void addList(PathPart part, Ref<List<T>> subObjectList) throws JerializerException;
}
