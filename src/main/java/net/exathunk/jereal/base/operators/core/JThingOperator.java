package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.Operator;

/**
 * charolastra 10/29/12 3:28 PM
 */
public abstract class JThingOperator<D> implements Operator<D, JThing> {
    @Override
    public boolean canCast(SuperModel model) {
        // maybe SuperModel.NULL has significance...
        return true;
    }

    @Override
    public JThing cast(SuperModel model, JThing thing) {
        return thing;
    }
}
