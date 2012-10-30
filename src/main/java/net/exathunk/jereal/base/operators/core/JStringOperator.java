package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;
import net.exathunk.jereal.base.operators.converters.JStringConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JStringOperator<D> extends ArgConverterOperator<JThing, JString, D> {
    public JStringOperator() {
        super(new JStringConverter());
    }
}
