package net.exathunk.jereal.base.core;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JBoolean extends JMutableScalarImpl<Boolean> {
    public JBoolean(Boolean scalar) {
        super(scalar);
    }

    @Override
    public void accept(Path path, TypedVisitor visitor) throws VisitException {
        visitor.visitBoolean(path, this);
    }
}
