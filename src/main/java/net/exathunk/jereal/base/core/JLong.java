package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Pipeable;

/**
 * charolastra 10/28/12 1:32 AM
 */
public class JLong extends JMutableScalarImpl<Long> {
    public JLong(Long scalar) {
        super(scalar);
    }

    @Override
    public void acceptTyped(Path path, TypedVisitor visitor) throws VisitException {
        visitor.visitLong(path, this);
    }

    @Override
    public <A extends PushableContext<A, B>, B> Pipeable<B> acceptDSL(DSL<A, B> dsl) {
        return dsl.seeLong(this);
    }
}