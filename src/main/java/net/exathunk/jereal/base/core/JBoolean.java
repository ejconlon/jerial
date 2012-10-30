package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.visitors.TypedVisitor;
import net.exathunk.jereal.base.visitors.VisitException;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JBoolean extends JMutableScalarImpl<Boolean> {
    public JBoolean(Boolean scalar) {
        super(scalar);
    }

    @Override
    public void accept(ConsList<PathPart> path, TypedVisitor visitor) throws VisitException {
        visitor.visitBoolean(path, this);
    }
}
