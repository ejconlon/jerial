package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.jerializers.JerializerException;

/**
 * charolastra 10/31/12 7:21 PM
 */
public interface Pipeable<U extends Questionable> {
    void pipe(Ref<U> ref) throws JerializerException;
}
