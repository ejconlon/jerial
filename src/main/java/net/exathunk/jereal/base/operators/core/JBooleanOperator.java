package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JBooleanOperator<D> extends BaseOperator<JBoolean, D> {
    public JBooleanOperator() {
        super(Model.BOOLEAN, SuperModel.BOOLEAN);
    }

    @Override
    public JBoolean convert(JThing thing) throws OperatorException {
        if (!thing.isBoolean()) throw new OperatorException("Expected BOOLEAN: "+thing.getModel());
        return thing.rawGetBoolean();
    }
}