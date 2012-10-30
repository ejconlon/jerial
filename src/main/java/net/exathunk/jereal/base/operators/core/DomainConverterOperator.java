package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.operators.OpContext;
import net.exathunk.jereal.base.operators.OperatorException;
import net.exathunk.jereal.base.operators.converters.Converter;

/**
 * charolastra 10/30/12 3:03 PM
 */
public class DomainConverterOperator<J, K, D, E, F> implements Operator<J, K, D, E> {
    private final Converter<E, F> converter;
    private final Operator<J, K, D, F> op;

    protected DomainConverterOperator(Converter<E, F> converter, Operator<J, K, D, F> op) {
        this.converter = converter;
        this.op = op;
        assert converter != null && op != null;
    }

    @Override
    public final void runFunc(OpContext<J, D> opC, ArgContext argC, K thing, E domain) {
        try {
            final F newDomain = converter.convert(domain);
            op.runFunc(opC, argC, thing, newDomain);
        } catch (OperatorException e) {
            opC.fail(e);
        }
    }
}