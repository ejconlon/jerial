package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.*;

/**
 * charolastra 10/28/12 1:32 AM
 */
public class JLong extends JMutableScalarImpl<Long> {
    public JLong(Long scalar) {
        super(scalar);
    }

    public JLong() {
        super();
    }

    @Override
    public void acceptTyped(Path path, TypedVisitor visitor) throws VisitException {
        visitor.visitLong(path, this);
    }

    @Override
    public <A extends PushableContext<A, B>, B extends Questionable> Pipeable<B> acceptDSL(DSL<A, B> dsl) {
        return dsl.seeLong(this);
    }

    @Override
    public Model getModel() {
        return Model.LONG;
    }

    @Override
    public JThing toJThing() {
        return JThing.make(this);
    }
}