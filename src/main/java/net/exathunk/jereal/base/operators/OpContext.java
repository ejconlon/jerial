package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.functional.Reference;
import net.exathunk.jereal.base.operators.core.ArgContext;
import net.exathunk.jereal.base.operators.core.Operator;

/**
 * charolastra 10/30/12 1:30 AM
 */
public class OpContext<J, D> {
    public final OperatorMap<J, D> opMap;
    public final D domain;
    public final Reference<OperatorException> failRef;

    public OpContext(OperatorMap<J, D> opMap,
                     D domain, Reference<OperatorException> failRef) {
        this.domain = domain;
        this.failRef = failRef;
        this.opMap = opMap;
    }

    public void fail(OperatorException e) {
        failRef.setReference(e);
    }

    public boolean hasFailed() {
        return failRef.getReference() != null;
    }

    // return true if should continue
    public boolean apply(Operator<J, D> op, ArgContext<J> argC) {
        if (op == null) {
            return true;   // null op == no-op
        } else if (!hasFailed()) {
            op.runFunc(this, argC);
            return hasFailed();
        } else {
            return false;
        }
    }
}
