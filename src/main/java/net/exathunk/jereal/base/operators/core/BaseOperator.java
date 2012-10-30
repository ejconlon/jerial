package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.operators.OpContext;
import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/30/12 1:24 AM
 */
public abstract class BaseOperator<J, D> implements Operator<JThing, D> {
    private final Model model;

    protected BaseOperator(Model model) {
        this.model = model;
        assert model != null;
    }

    public final boolean canConvert(OpContext<JThing, D> c) {
        return model.equals(c.thing.getModel());
    }

    public final OpContext<J, D> convert(OpContext<JThing, D> c) throws OperatorException{
        return c.withThing(convert(c.thing));
    }

    @Override
    public final void runFunc(OpContext<JThing, D> c) {
        try {
            final OpContext<J, D> converted = convert(c);
            typedRunFunc(converted);
        } catch (OperatorException e) {
            c.fail(e);
        }
    }

    public abstract J convert(JThing thing) throws OperatorException;
    public abstract void typedRunFunc(OpContext<J, D> c);
}
