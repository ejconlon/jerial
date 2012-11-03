package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Questionable;

/**
 * charolastra 10/27/12 3:36 PM
 */
public interface RegistryFactory<T extends PushableContext<T, U>, U extends Questionable> {
    JerializerRegistry<T, U> makeJerializerRegistry();
}
