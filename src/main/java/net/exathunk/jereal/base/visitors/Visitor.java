package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.ConsList;

/**
 * charolastra 10/29/12 4:37 PM
 */
public interface Visitor {
    void visitStart(ConsList<PathPart> path, JThing thing) throws VisitException;
    void visitEnd(ConsList<PathPart> path, JThing thing) throws VisitException;
}
