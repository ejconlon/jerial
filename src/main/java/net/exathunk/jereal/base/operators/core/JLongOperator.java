package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.converters.JLongConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public class JLongOperator<D, E> extends ArgConverterOperator<JThing, JThing, JLong, D, E> {
    public JLongOperator(Operator<JThing, JLong, D, E> op) {
        super(new JLongConverter(), op);
    }
}
