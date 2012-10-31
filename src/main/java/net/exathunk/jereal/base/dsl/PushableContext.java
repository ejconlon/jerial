package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.ResFunc1;

/**
 * charolastra 10/31/12 3:04 PM
 */
public interface PushableContext<T extends PushableContext<T, U>, U> extends ResFunc1<RefMapGroup<T, U>, U> {
    T push(PathPart part);
}
