package net.exathunk.jereal.base.operators.converters;

import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/30/12 2:35 PM
 */
public interface Converter<A, B> {
    boolean canConvert(A a);
    public B convert(A a) throws OperatorException;
}
