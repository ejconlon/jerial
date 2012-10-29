package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.JBoolean;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.ExecutionException;
import net.exathunk.jereal.base.operators.Operator;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JBooleanOperator<D> implements Operator<D, JBoolean> {
    @Override
    public boolean canCast(SuperModel model) {
        return SuperModel.BOOLEAN.equals(model);
    }

    @Override
    public JBoolean cast(SuperModel model, JThing thing) throws ExecutionException {
        if (!canCast(model)) throw new ExecutionException("Model mismatch: "+model+" "+thing);
        return thing.rawGetBoolean();
    }
}
