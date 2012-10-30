package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.converters.JArrayConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public class JArrayOperator<D, E> extends ArgConverterOperator<JThing, JThing, JArray, D, E> {
    public JArrayOperator(Operator<JThing, JArray, D, E> op) {
        super(new JArrayConverter(), op);
    }
}
