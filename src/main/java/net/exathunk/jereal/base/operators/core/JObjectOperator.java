package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.ExecutionException;
import net.exathunk.jereal.base.operators.Operator;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JObjectOperator<D> implements Operator<D, JObject> {
    @Override
    public boolean canCast(SuperModel model) {
        return SuperModel.OBJECT.equals(model);
    }

    @Override
    public JObject cast(SuperModel model, JThing thing) throws ExecutionException {
        if (!canCast(model)) throw new ExecutionException("Model mismatch: "+model+" "+thing);
        return thing.rawGetObject();
    }
}
