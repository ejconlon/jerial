package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.jerializers.DejerializerRegistry;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;

/**
 * charolastra 10/27/12 3:36 PM
 */
public interface RegistryFactory {
    JerializerRegistry makeJerializerRegistry();
    DejerializerRegistry makeDejerializerRegistry();
}
