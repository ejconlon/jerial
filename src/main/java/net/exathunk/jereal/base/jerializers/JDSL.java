package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/30/12 8:57 PM
 */
public interface JDSL {

    void addThing(PathPart part, Ref<JThing> thing);

    void addBoolean(PathPart part, Ref<Boolean> value);

    void addLong(PathPart part, Ref<Long> value);

    void addDouble(PathPart part, Ref<Double> value);

    void addString(PathPart part, Ref<String> value);

    <T> void add(PathPart part, Ref<T> value) throws JerializerException;

    <T> void addMap(PathPart part, Ref<Map<String, T>> subObjectMap) throws JerializerException;

    <T> void addSinglyList(PathPart part, Ref<List<T>> subObjectList) throws JerializerException;

    <T> void addList(PathPart part, Ref<List<T>> subObjectList) throws JerializerException;
}
