package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.converters.JDoubleConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public class JDoubleOperator<D, E> extends ArgConverterOperator<JThing, JThing, JDouble, D, E>{
    public JDoubleOperator(Operator<JThing, JDouble, D, E> op) {
        super(new JDoubleConverter(), op);
    }
}
