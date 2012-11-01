package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Cont;
import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 10/31/12 7:25 PM
 */
public class PipeableImpl<U> implements Pipeable<U> {
    private final Cont<U> value;

    public PipeableImpl(Cont<U> value) {
        this.value = value;
    }

    @Override
    public void pipe(Cont<U> cont) {
        cont.setCont(value);
    }
}
