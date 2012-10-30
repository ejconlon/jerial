package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.OperatorException;
import net.exathunk.jereal.base.operators.converters.JObjectConverter;

/**
 * charolastra 10/29/12 3:33 PM
 */
public abstract class JObjectOperator<D> extends ArgConverterOperator<JThing, JObject, D> {
    public JObjectOperator() {
        super(new JObjectConverter());
    }
}
