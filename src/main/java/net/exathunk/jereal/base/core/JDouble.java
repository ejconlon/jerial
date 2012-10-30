package net.exathunk.jereal.base.core;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JDouble extends JMutableScalarImpl<Double> {
    public JDouble(Double scalar) {
        super(scalar);
    }

    @Override
    public void accept(Path path, TypedVisitor visitor) throws VisitException {
        visitor.visitDouble(path, this);
    }
}