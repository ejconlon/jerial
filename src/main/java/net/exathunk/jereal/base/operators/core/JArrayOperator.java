package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.JArray;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.ExecutionException;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JArrayOperator<D, E> implements Operator<D, E, JArray> {
    @Override
    public boolean canCast(SuperModel model) {
        return SuperModel.ARRAY.equals(model);
    }

    @Override
    public JArray cast(SuperModel model, JThing thing) throws ExecutionException {
        if (!canCast(model)) throw new ExecutionException("Model mismatch: "+model+" "+thing);
        return thing.rawGetArray();
    }
}
