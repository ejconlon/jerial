package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;
import net.exathunk.jereal.base.operators.converters.JBooleanConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JBooleanOperator<D> extends ArgConverterOperator<JThing, JBoolean, D> {
    public JBooleanOperator() {
        super(new JBooleanConverter());
    }
}