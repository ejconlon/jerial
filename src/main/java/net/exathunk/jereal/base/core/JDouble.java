package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.ConsList;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JDouble extends JMutableScalarImpl<Double> {
    public JDouble(Double scalar) {
        super(scalar);
    }

    @Override
    public void accept(ConsList<PathPart> path, TypedVisitor visitor) throws VisitException {
        visitor.visitDouble(path, this);
    }
}