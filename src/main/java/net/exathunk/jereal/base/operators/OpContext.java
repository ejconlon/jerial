package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.functional.Reference;
import net.exathunk.jereal.base.operators.core.ArgContext;
import net.exathunk.jereal.base.operators.core.Operator;

/**
 * charolastra 10/30/12 1:30 AM
 */
public class OpContext<J, D> {
    public final OperatorMap<J, D> opMap;
    public final Reference<OperatorException> failRef;

    public OpContext(OperatorMap<J, D> opMap,
                     Reference<OperatorException> failRef) {
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
    public boolean apply(Operator<J, J, D, D> op, ArgContext argC, J thing, D domain) {
        if (op == null) {
            return true;   // null op == no-op; recurse
        }
        if (!hasFailed()) {
            op.runFunc(this, argC, thing, domain);
        }
        return false;
    }
}
