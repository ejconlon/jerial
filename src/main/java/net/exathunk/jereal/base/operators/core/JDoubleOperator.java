package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;
import net.exathunk.jereal.base.operators.converters.JDoubleConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JDoubleOperator<D> extends ArgConverterOperator<JThing, JDouble, D> {
    public JDoubleOperator() {
        super(new JDoubleConverter());
    }
}
