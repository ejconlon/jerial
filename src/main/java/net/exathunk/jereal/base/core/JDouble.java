package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.*;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JDouble extends JMutableScalarImpl<Double> {
    public JDouble(Double scalar) {
        super(scalar);
    }

    public JDouble() {
        super();
    }

    @Override
    public void acceptTyped(Path path, TypedVisitor visitor) throws VisitException {
        visitor.visitDouble(path, this);
    }

    @Override
    public <A extends PushableContext<A, B>, B extends Questionable> Pipeable<B> acceptDSL(DSL<A, B> dsl) {
        return dsl.seeDouble(this);
    }

    @Override
    public Model getModel() {
        return Model.DOUBLE;
    }

    @Override
    public JThing toJThing() {
        return JThing.make(this);
    }
}