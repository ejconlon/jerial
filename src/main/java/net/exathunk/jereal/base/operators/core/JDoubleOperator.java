package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JDoubleOperator<D> extends BaseOperator<JDouble, D> {
    public JDoubleOperator() {
        super(Model.DOUBLE, SuperModel.DOUBLE);
    }

    @Override
    public JDouble convert(JThing thing) throws OperatorException {
        if (!thing.isDouble()) throw new OperatorException("Expected DOUBLE: "+thing.getModel());
        return thing.rawGetDouble();
    }
}
