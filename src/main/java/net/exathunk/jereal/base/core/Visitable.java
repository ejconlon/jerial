package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.visitors.TypedVisitor;
import net.exathunk.jereal.base.visitors.VisitException;

/**
 * charolastra 10/29/12 5:38 PM
 */
public interface Visitable {
    void accept(ConsList<PathPart> path, TypedVisitor visitor) throws VisitException;
}
