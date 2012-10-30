package net.exathunk.jereal.base.core;

/**
 * charolastra 10/29/12 5:38 PM
 */
public interface Visitable {
    void accept(Path path, TypedVisitor visitor) throws VisitException;
}
