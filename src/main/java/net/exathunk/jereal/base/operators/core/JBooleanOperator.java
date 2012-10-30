package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.converters.JBooleanConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public class JBooleanOperator<D, E> extends ArgConverterOperator<JThing, JThing, JBoolean, D, E> {
    public JBooleanOperator(Operator<JThing, JBoolean, D, E> op) {
        super(new JBooleanConverter(), op);
    }
}