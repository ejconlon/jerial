package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JObjectOperator<D> extends BaseOperator<JObject, D> {
    public JObjectOperator() {
        super(Model.OBJECT, SuperModel.OBJECT);
    }

    @Override
    public JObject convert(JThing thing) throws OperatorException {
        if (!thing.isObject()) throw new OperatorException("Expected OBJECT: "+thing.getModel());
        return thing.rawGetObject();
    }
}
