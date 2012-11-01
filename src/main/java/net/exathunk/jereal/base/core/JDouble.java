package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Pipeable;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JDouble extends JMutableScalarImpl<Double> {
    public JDouble(Double scalar) {
        super(scalar);
    }

    @Override
    public void acceptTyped(Path path, TypedVisitor visitor) throws VisitException {
        visitor.visitDouble(path, this);
    }

    @Override
    public <A extends PushableContext<A, B>, B> Pipeable<B> acceptDSL(DSL<A, B> dsl) {
        return dsl.seeDouble(this);
    }
}