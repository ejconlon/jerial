package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.operators.OpContext;
import net.exathunk.jereal.base.operators.OperatorException;
import net.exathunk.jereal.base.operators.converters.Converter;

/**
 * charolastra 10/30/12 1:24 AM
 */
public abstract class ArgConverterOperator<J, K, D> implements Operator<J, D> {
    private final Converter<J, K> converter;

    protected ArgConverterOperator(Converter<J, K> converter) {
        this.converter = converter;
        assert converter != null;
    }

    @Override
    public final void runFunc(OpContext<J, D> opC, ArgContext<J> argC) {
        try {
            final K newThing = converter.convert(argC.thing);
            final ArgContext<K> newArgC = argC.withThing(newThing);
            runArgConvertedFunc(opC, newArgC);
        } catch (OperatorException e) {
            opC.fail(e);
        }
    }

    public abstract void runArgConvertedFunc(OpContext<J, D> opC, ArgContext<K> argC);
}
