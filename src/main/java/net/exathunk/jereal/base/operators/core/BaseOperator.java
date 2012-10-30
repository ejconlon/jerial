package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.OpContext;
import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/30/12 1:24 AM
 */
public abstract class BaseOperator<J, D> implements Operator<JThing, D> {
    private final Model model;
    private final SuperModel superModel;

    protected BaseOperator(Model model, SuperModel superModel) {
        this.model = model;
        this.superModel = superModel;
        assert model != null && superModel != null;
    }

    public final boolean canConvert(OpContext<JThing, D> c) {
        return model.equals(c.thing.getModel()) && superModel.equals(c.model);
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
