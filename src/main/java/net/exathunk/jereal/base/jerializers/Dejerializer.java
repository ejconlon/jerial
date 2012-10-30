package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JObject;

/**
 * charolastra 10/27/12 2:26 PM
 */
public interface Dejerializer<T> {
    void dejerialize(DejerializerRegistry registry, JObject jobject, T domain) throws JerializerException;
}
