package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/27/12 2:14 PM
 */
public interface TreeObjectVisitorFactory<T> extends ObjectVisitorFactory<T> {
    TreeObjectVisitor<T> makeObjectVisitor();
}
