package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 10/31/12 7:25 PM
 */
public class WritableImpl<U> implements Writable<U> {
    private final U value;

    public WritableImpl(U value) {
        this.value = value;
    }

    @Override
    public void writeTo(Ref<U> ref) {
        ref.setRef(value);
    }
}
