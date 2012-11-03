package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.*;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JString extends JMutableScalarImpl<String> {

    public JString() { super(); }

    public JString(String scalar) {
        super(scalar);
    }

    @Override
    public void acceptTyped(Path path, TypedVisitor visitor) throws VisitException {
        visitor.visitString(path, this);
    }

    @Override
    public <A extends PushableContext<A, B>, B extends Questionable> Pipeable<B> acceptDSL(DSL<A, B> dsl) {
        return dsl.seeString(this);
    }

    @Override
    public Model getModel() {
        return Model.STRING;
    }

    @Override
    public JThing toJThing() {
        return JThing.make(this);
    }
}