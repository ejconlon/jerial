package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.jerializers.JerializerException;

/**
 * charolastra 10/31/12 3:04 PM
 */
public interface PushableContext<T extends PushableContext<T, U>, U> {
    T push(PathPart part);
    void writeObject(RefMapGroup<T, U> group, Ref<U> ref) throws JerializerException;
    void writeArray(RefMapGroup<T, U> group, Ref<U> ref) throws JerializerException;
    void writeString(Ref<String> value, Ref<U> ref) throws JerializerException;
    void writeBoolean(Ref<Boolean> value, Ref<U> ref) throws JerializerException;
    void writeLong(Ref<Long> value, Ref<U> ref) throws JerializerException;
    void writeDouble(Ref<Double> value, Ref<U> ref) throws JerializerException;
}
