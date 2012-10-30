package net.exathunk.jereal.base.core;

/**
 * charolastra 10/30/12 2:55 AM
 */
public interface UntypedVisitable {
    void acceptUntyped(Path path, UntypedVisitor visitor) throws VisitException;
}
