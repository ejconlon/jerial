package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.converters.JStringConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public class JStringOperator<D, E> extends ArgConverterOperator<JThing, JThing, JString, D, E> {
    public JStringOperator(Operator<JThing, JString, D, E> op) {
        super(new JStringConverter(), op);
    }
}
