package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JArrayOperator<D> extends BaseOperator<JArray, D> {
    public JArrayOperator() {
        super(Model.ARRAY, SuperModel.ARRAY);
    }

    @Override
    public JArray convert(JThing thing) throws OperatorException {
        if (!thing.isArray()) throw new OperatorException("Expected ARRAY: "+thing.getModel());
        return thing.rawGetArray();
    }
}
