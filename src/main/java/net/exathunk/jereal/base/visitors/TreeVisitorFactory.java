package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/25/12 11:30 AM
 */
public class TreeVisitorFactory<T> implements VisitorFactory<T> {
    private final JerialNodeMapWriter<T> writer;

    public TreeVisitorFactory(JerialNodeMapWriter<T> writer) {
        this.writer = writer;
    }

    public TreeObjectVisitor<T> makeObjectVisitor() {
        return new TreeObjectVisitor<T>(this, writer);
    }

    public TreeArrayVisitor<T> makeArrayVisitor() {
        return new TreeArrayVisitor<T>(this, writer);
    }
}
