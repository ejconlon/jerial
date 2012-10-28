package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.Jerial;

/**
 * charolastra 10/27/12 2:26 PM
 */
public interface Dejerializer<T> {
    void dejerialize(DejerializerRegistry registry, Jerial jerial, T domain) throws JerializerException;
}
