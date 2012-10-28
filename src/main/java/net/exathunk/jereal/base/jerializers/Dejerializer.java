package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.Jerial;

/**
 * charolastra 10/27/12 2:26 PM
 */
public interface Dejerializer<T> {
    void dejerialize(DejerializerRegistry registry, JObject jobject, T domain) throws JerializerException;
}
