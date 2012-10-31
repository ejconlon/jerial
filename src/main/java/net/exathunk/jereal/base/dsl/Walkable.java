package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.Model;

/**
 * charolastra 10/31/12 1:39 PM
 */
public interface Walkable<T> {
    Model getModel();
    T walk() throws WalkException;
}
