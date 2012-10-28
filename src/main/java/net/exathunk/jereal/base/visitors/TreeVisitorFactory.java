package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/27/12 2:12 PM
 */
public interface TreeVisitorFactory<T> extends VisitorFactory<T> {
    TreeObjectVisitor<T> makeObjectVisitor();
    TreeArrayVisitor<T> makeArrayVisitor();
}
