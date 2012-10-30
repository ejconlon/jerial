package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JStringOperator<D> extends BaseOperator<JString, D> {
    public JStringOperator() {
        super(Model.STRING);
    }

    @Override
    public JString convert(JThing thing) throws OperatorException {
        if (!thing.isString()) throw new OperatorException("Expected STRING: "+thing.getModel());
        return thing.rawGetString();
    }
}
