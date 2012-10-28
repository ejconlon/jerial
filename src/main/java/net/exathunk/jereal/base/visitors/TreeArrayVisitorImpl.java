package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.Func2;

/**
 * charolastra 10/23/12 10:12 PM
 */
public class TreeArrayVisitorImpl<T> implements TreeArrayVisitor<T> {

    private final TreeVisitorFactory<T> factory;
    private final Func2<TreeNodeMap<T>, T> writer;
    private final TreeNodeMap<T> map = new TreeNodeMap<T>();

    private int index = 0;

    public TreeArrayVisitorImpl(TreeVisitorFactory<T> factory,  Func2<TreeNodeMap<T>, T> writer) {
        this.factory = factory;
        this.writer = writer;
    }

    protected int incIndex() {
        return index++;
    }

    @Override
    public ObjectVisitor<T> seeObjectItemStart() {
        TreeObjectVisitor<T> v = factory.makeObjectVisitor();
        map.putIndexed(incIndex(), TreeNode.<T>makeMiddle(v));
        return v;
    }

    @Override
    public ArrayVisitor<T> seeArrayItemStart() {
        TreeArrayVisitor<T> v = factory.makeArrayVisitor();
        map.putIndexed(incIndex(), TreeNode.<T>makeRight(v));
        return v;
    }

    @Override
    public void seeStringItem(String value) {
        Integer index = incIndex();
        map.putIndexed(index, TreeNode.<T>makeLeft(JThing.make(new JString(value))));
    }

    @Override
    public void seeBooleanItem(Boolean value) {
        Integer index = incIndex();
        map.putIndexed(index, TreeNode.<T>makeLeft(JThing.make(new JBoolean(value))));
    }

    @Override
    public void seeLongItem(Long value) {
        Integer index = incIndex();
        map.putIndexed(index, TreeNode.<T>makeLeft(JThing.make(new JLong(value))));
    }

    @Override
    public void seeDoubleItem(Double value) {
        Integer index = incIndex();
        map.putIndexed(index, TreeNode.<T>makeLeft(JThing.make(new JDouble(value))));
    }

    public TreeNodeMap<T> getTreeNodeMap() {
        return map;
    }

    @Override
    public void runFunc(T out) {
        writer.runFunc(getTreeNodeMap(), out);
    }
}
