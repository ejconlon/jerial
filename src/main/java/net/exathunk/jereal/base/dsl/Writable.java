package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.jerializers.JerializerException;

/**
 * charolastra 10/31/12 7:21 PM
 */
public interface Writable<U> {
    void writeTo(Ref<U> ref) throws JerializerException;
}
