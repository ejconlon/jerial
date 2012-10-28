package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.functional.Func2;

/**
 * charolastra 10/25/12 11:30 AM
 */
public class TreeVisitorFactoryImpl<T> implements TreeVisitorFactory<T> {
    private final Func2<TreeNodeMap<T>, T> writer;

    public TreeVisitorFactoryImpl(Func2<TreeNodeMap<T>, T> writer) {
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
