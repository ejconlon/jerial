package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.Path;

/**
 * charolastra 10/30/12 2:09 PM
 */
public class ArgContext<J> {
    public final Path path;
    public final J thing;

    public ArgContext(Path path, J thing) {
        this.path = path;
        this.thing = thing;
    }

    public <K> ArgContext<K> withThing(K thing) {
        return new ArgContext<K>(path, thing);
    }
}
