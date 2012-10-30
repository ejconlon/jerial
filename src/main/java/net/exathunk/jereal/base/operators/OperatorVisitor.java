package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.core.ArgContext;
import net.exathunk.jereal.base.operators.core.Operator;

/**
 * charolastra 10/29/12 9:52 PM
 */
public class OperatorVisitor<D> implements UntypedVisitor {

    private final OpContext<JThing, D> opC;

    public OperatorVisitor(OpContext<JThing, D> opC) {
        this.opC = opC;
    }

    @Override
    public boolean visitThing(Path path, JThing thing) throws VisitException {
        Operator<JThing, JThing, D, D> op = opC.opMap.get(path, thing.getModel());
        final ArgContext argC = new ArgContext(path);
        return opC.apply(op, argC, thing);
    }
}
