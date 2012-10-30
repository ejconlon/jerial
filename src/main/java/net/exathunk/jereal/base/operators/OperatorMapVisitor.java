package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.core.Operator;
import net.exathunk.jereal.base.util.EmptyTypedVisitor;

/**
 * charolastra 10/29/12 9:52 PM
 */
public class OperatorMapVisitor<F> implements UntypedVisitor {

    private final OperatorMap<JThing, F> opMap;
    private final OpContext<JThing, F> context;

    public OperatorMapVisitor(OperatorMap<JThing, F> opMap, OpContext<JThing, F> context) {
        this.opMap = opMap;
        this.context = context;
    }

    @Override
    public boolean visitThing(Path path, JThing thing) throws VisitException {
        Operator<JThing, F> op = opMap.get(path, thing.getModel());
        if (op != null) {
            final OpContext newContext = context.withPath(path).withThing(thing);
            newContext.apply(op);
        }
        return false;
    }
}
