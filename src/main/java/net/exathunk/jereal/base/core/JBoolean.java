package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.Pipeable;
import net.exathunk.jereal.base.dsl.PushableContext;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JBoolean extends JMutableScalarImpl<Boolean> {
    public JBoolean(Boolean scalar) {
        super(scalar);
    }

    @Override
    public void acceptTyped(Path path, TypedVisitor visitor) throws VisitException {
        visitor.visitBoolean(path, this);
    }

    @Override
    public <A extends PushableContext<A, B>, B> Pipeable<B> acceptDSL(DSL<A, B> dsl) {
        return dsl.seeBoolean(this);
    }
}
