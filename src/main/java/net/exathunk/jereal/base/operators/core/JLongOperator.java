package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;
import net.exathunk.jereal.base.operators.converters.JLongConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JLongOperator<D> extends ArgConverterOperator<JThing, JLong, D> {
    public JLongOperator() {
        super(new JLongConverter());
    }
}
