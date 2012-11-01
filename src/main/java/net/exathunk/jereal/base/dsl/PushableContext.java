package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 10/31/12 3:04 PM
 */
public interface PushableContext<T extends PushableContext<T, U>, U> {
    T push(PathPart part);
    void writeObject(RefMapGroup<T, U> group, Ref<U> ref);
    void writeArray(RefMapGroup<T, U> group, Ref<U> ref);
    void writeString(Ref<String> value, Ref<U> ref);
    void writeBoolean(Ref<Boolean> value, Ref<U> ref);
    void writeLong(Ref<Long> value, Ref<U> ref);
    void writeDouble(Ref<Double> value, Ref<U> ref);
}
