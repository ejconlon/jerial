package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/23/12 10:17 PM
 */
public interface ObjectVisitorFactory<T> {
    ObjectVisitor<T> makeObjectVisitor();
}
