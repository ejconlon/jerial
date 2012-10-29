package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.JDouble;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.ExecutionException;
import net.exathunk.jereal.base.operators.Operator;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JDoubleOperator<D, E> implements Operator<D, E, JDouble> {
    @Override
    public boolean canCast(SuperModel model) {
        return SuperModel.DOUBLE.equals(model);
    }

    @Override
    public JDouble cast(SuperModel model, JThing thing) throws ExecutionException {
        if (!canCast(model)) throw new ExecutionException("Model mismatch: "+model+" "+thing);
        return thing.rawGetDouble();
    }
}
