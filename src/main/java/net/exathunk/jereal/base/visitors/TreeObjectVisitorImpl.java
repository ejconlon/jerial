package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.Func2;

// This is a visitor that builds a tree of parsed Jitems and unparsed (in-progress) suspensions
public class TreeObjectVisitorImpl<T> implements TreeObjectVisitor<T> {

    private final TreeVisitorFactory<T> factory;
    private final Func2<TreeNodeMap<T>, T> writer;
    private final TreeNodeMap<T> map = new TreeNodeMap<T>();

    public TreeObjectVisitorImpl(TreeVisitorFactory<T> factory,  Func2<TreeNodeMap<T>, T> writer) {
        this.factory = factory;
        this.writer = writer;
    }

    protected PathPart makePath(String key) {
        return PathPart.key(key);
    }

    @Override
    public ObjectVisitor<T> seeObjectFieldStart(String key) {
        TreeObjectVisitor<T> v = factory.makeObjectVisitor();
        map.putKeyed(key, TreeNode.<T>makeMiddle(v));
        return v;
    }

    @Override
    public ArrayVisitor<T> seeArrayFieldStart(String key) {
        TreeArrayVisitor<T> v = factory.makeArrayVisitor();
        map.putKeyed(key, TreeNode.<T>makeRight(v));
        return v;
    }

    @Override
    public void seeStringField(String key, String value) {
        map.putKeyed(key, TreeNode.<T>makeLeft(JThing.make(new JString(value))));
    }

    @Override
    public void seeBooleanField(String key, Boolean value) {
        map.putKeyed(key, TreeNode.<T>makeLeft(JThing.make(new JBoolean(value))));
    }

    @Override
    public void seeLongField(String key, Long value) {
        map.putKeyed(key, TreeNode.<T>makeLeft(JThing.make(new JLong(value))));
    }

    @Override
    public void seeDoubleField(String key, Double value) {
        map.putKeyed(key, TreeNode.<T>makeLeft(JThing.make(new JDouble(value))));
    }

    public TreeNodeMap<T> getTreeNodeMap() {
        return map;
    }

    @Override
    public void runFunc(T out) {
        writer.runFunc(getTreeNodeMap(), out);
    }
}
