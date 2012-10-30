package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JLongOperator<D> extends BaseOperator<JLong, D> {
    public JLongOperator() {
        super(Model.LONG, SuperModel.LONG);
    }

    @Override
    public JLong convert(JThing thing) throws OperatorException {
        if (!thing.isLong()) throw new OperatorException("Expected LONG: "+thing.getModel());
        return thing.rawGetLong();
    }
}
