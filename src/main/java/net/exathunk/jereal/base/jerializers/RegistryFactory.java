package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.jerializers.DejerializerRegistry;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;

/**
 * charolastra 10/27/12 3:36 PM
 */
public interface RegistryFactory<T extends PushableContext<T, U>, U> {
    JerializerRegistry<T, U> makeJerializerRegistry();
    DejerializerRegistry makeDejerializerRegistry();
}
