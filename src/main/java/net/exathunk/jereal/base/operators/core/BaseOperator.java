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

    public final boolean canConvert(ArgContext<JThing> argC) {
        return model.equals(argC.thing.getModel());
    }

    public final ArgContext<J> convert(ArgContext<JThing> argC) throws OperatorException {
        return argC.withThing(convert(argC.thing));
    }

    @Override
    public final void runFunc(OpContext<JThing, D> opC, ArgContext<JThing> argC) {
        try {
            final ArgContext<J> newArgC = convert(argC);
            typedRunFunc(opC, newArgC);
        } catch (OperatorException e) {
            opC.fail(e);
        }
    }

    public abstract J convert(JThing thing) throws OperatorException;
    public abstract void typedRunFunc(OpContext<JThing, D> opC, ArgContext<J> argC);
}
