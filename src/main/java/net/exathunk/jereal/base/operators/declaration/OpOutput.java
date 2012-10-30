package net.exathunk.jereal.base.operators.declaration;

import net.exathunk.jereal.base.functional.EitherRef;
import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/30/12 1:42 AM
 */
public class OpOutput<F> {
    public final EitherRef<F, OperatorException> reference;

    public OpOutput(EitherRef<F, OperatorException> ref) {
        this.reference = ref;
    }


}
