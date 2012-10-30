package net.exathunk.jereal.base.core;

/**
 * charolastra 10/28/12 1:32 AM
 */
public class JLong extends JMutableScalarImpl<Long> {
    public JLong(Long scalar) {
        super(scalar);
    }

    @Override
    public void accept(Path path, TypedVisitor visitor) throws VisitException {
        visitor.visitLong(path, this);
    }
}