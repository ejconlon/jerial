package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;
import net.exathunk.jereal.base.operators.converters.JArrayConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JArrayOperator<D> extends ArgConverterOperator<JThing, JArray, D> {
    public JArrayOperator() {
        super(new JArrayConverter());
    }
}
