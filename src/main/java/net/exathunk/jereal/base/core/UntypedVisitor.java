package net.exathunk.jereal.base.core;

/**
 * charolastra 10/30/12 2:51 AM
 */
public interface UntypedVisitor {
    boolean visitThing(Path path, JThing thing) throws VisitException;
}
