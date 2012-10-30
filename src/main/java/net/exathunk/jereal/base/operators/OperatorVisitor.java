package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.core.ArgContext;
import net.exathunk.jereal.base.operators.core.Operator;

/**
 * charolastra 10/29/12 9:52 PM
 */
public class OperatorVisitor<F> implements UntypedVisitor {

    private final OpContext<JThing, F> opC;

    public OperatorVisitor(OpContext<JThing, F> opC) {
        this.opC = opC;
    }

    @Override
    public boolean visitThing(Path path, JThing thing) throws VisitException {
        Operator<JThing, F> op = opC.opMap.get(path, thing.getModel());
        final ArgContext<JThing> argC = new ArgContext<JThing>(path, thing);
        return opC.apply(op, argC);
    }
}
