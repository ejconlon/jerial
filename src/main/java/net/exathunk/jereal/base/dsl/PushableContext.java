package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 10/31/12 3:04 PM
 */
public interface PushableContext<T extends PushableContext<T, U>, U> {
    T push(PathPart part);
    U writeObject(RefMapGroup<T, U> group);
    U writeArray(RefMapGroup<T, U> group);
    U writeString(Ref<String> value);
    U writeBoolean(Ref<Boolean> value);
    U writeLong(Ref<Long> value);
    U writeDouble(Ref<Double> value);
}
