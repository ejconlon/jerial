package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.*;

/**
 * charolastra 10/29/12 4:01 PM
 */
public class Suspension<D, E, J> implements Func1<EitherRef<D, E>> {

    private final Operator<D, E, J> operator;
    private final PathPart part;
    private final J thing;

    public Suspension(Operator<D, E, J> operator, PathPart part, J thing) {
        this.operator = operator;
        this.part = part;
        this.thing = thing;
    }

    @Override
    public void runFunc(EitherRef<D, E> context) {
        if (context.hasLeft()) {
            final D domain = context.getLeft();
            operator.runFunc(part, thing, domain, context.getRightReference());
        }
    }
}
