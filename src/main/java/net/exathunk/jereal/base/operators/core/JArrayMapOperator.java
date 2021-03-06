package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.JArray;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.ResFunc0;
import net.exathunk.jereal.base.operators.OpContext;
import net.exathunk.jereal.base.operators.OperatorException;
import net.exathunk.jereal.base.operators.converters.Converter;

import java.util.Map;

/**
 * charolastra 10/30/12 3:55 PM
 */
public class JArrayMapOperator<D, E, F> implements Operator<JThing, JArray, D, E> {

    private final Converter<E, ResFunc0<F>> converter;
    private final Operator<JThing, JThing, D, F> op;

    public JArrayMapOperator(Converter<E, ResFunc0<F>> converter, Operator<JThing, JThing, D, F> op)  {
        this.converter = converter;
        this.op = op;
    }

    @Override
    public void runFunc(OpContext<JThing, D> opC, ArgContext argC, JArray thing, E domain) {
        try {
            final ResFunc0<F> source = converter.convert(domain);
            for (Map.Entry<Integer, JThing> entry : thing.seq()) {
                final ArgContext newArgC = argC.push(entry.getKey());
                final JThing newThing = entry.getValue();
                final F newDomain = source.runResFunc();
                op.runFunc(opC, newArgC, newThing, newDomain);
            }
        } catch (OperatorException e) {
            opC.fail(e);
        }
    }
}
