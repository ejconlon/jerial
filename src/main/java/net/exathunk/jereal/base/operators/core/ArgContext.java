package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.Path;

/**
 * charolastra 10/30/12 2:09 PM
 */
public class ArgContext {
    public final Path path;

    public ArgContext(Path path) {
        this.path = path;
    }

    public ArgContext push(Integer index) {
        return new ArgContext(path.consIndex(index));
    }

    public ArgContext push(String key) {
        return new ArgContext(path.consKey(key));
    }
}
