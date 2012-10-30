package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.converters.JObjectConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public class JObjectOperator<D, E> extends ArgConverterOperator<JThing, JThing, JObject, D, E> {
    public JObjectOperator(Operator<JThing, JObject, D, E> op) {
        super(new JObjectConverter(), op);
    }
}
