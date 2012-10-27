package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/25/12 11:30 AM
 */
public class TreeVisitorFactoryImpl<T> implements TreeVisitorFactory<T> {
    private final TreeNodeMapWriter<T> writer;

    public TreeVisitorFactoryImpl(TreeNodeMapWriter<T> writer) {
        this.writer = writer;
    }

    @Override
    public TreeObjectVisitor<T> makeObjectVisitor() {
        return new TreeObjectVisitorImpl<T>(this, writer);
    }

    @Override
    public TreeArrayVisitor<T> makeArrayVisitor() {
        return new TreeArrayVisitorImpl<T>(this, writer);
    }
}
