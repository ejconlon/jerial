package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/27/12 2:15 PM
 */
public interface TreeArrayVisitorFactory<T> extends ObjectVisitorFactory<T> {
    TreeArrayVisitor<T> makeArrayVisitor();
}
