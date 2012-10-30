package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;

public interface Jerializer<T> {
    void jerialize(JerializerRegistry registry, T object, JerialContext context) throws JerializerException;
}
