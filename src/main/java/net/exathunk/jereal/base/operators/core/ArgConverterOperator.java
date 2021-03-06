package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.operators.OpContext;
import net.exathunk.jereal.base.operators.OperatorException;
import net.exathunk.jereal.base.operators.converters.Converter;

/**
 * charolastra 10/30/12 1:24 AM
 */
public class ArgConverterOperator<J, K, L, D, E> implements Operator<J, K, D, E> {
    private final Converter<K, L> converter;
    private final Operator<J, L, D, E> op;

    protected ArgConverterOperator(Converter<K, L> converter, Operator<J, L, D, E> op) {
        this.converter = converter;
        this.op = op;
        assert converter != null && op != null;
    }

    @Override
    public final void runFunc(OpContext<J, D> opC, ArgContext argC, K thing, E domain) {
        try {
            final L newThing = converter.convert(thing);
            op.runFunc(opC, argC, newThing, domain);
        } catch (OperatorException e) {
            opC.fail(e);
        }
    }
}
