package net.exathunk.jereal.base.core;

/**
 * charolastra 10/29/12 5:38 PM
 */
public interface TypedVisitable {
    void acceptTyped(Path path, TypedVisitor visitor) throws VisitException;
}
