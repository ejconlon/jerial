package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 10/31/12 7:25 PM
 */
public class PipeableImpl<U> implements Pipeable<U> {
    private final U value;

    public PipeableImpl(U value) {
        this.value = value;
    }

    @Override
    public void pipe(Ref<U> ref) {
        ref.setRef(value);
    }
}
