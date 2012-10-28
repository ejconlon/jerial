package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/23/12 10:12 PM
 */
public class TreeArrayVisitorImpl<T> implements TreeArrayVisitor<T> {

    private final TreeVisitorFactory<T> factory;
    private final TreeNodeMapWriter<T> writer;
    private final TreeNodeMap<T> map = new TreeNodeMap<T>();

    private int index = 0;

    public TreeArrayVisitorImpl(TreeVisitorFactory<T> factory, TreeNodeMapWriter<T> writer) {
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
        PathPart part = PathPart.index(index);
        map.putIndexed(index, TreeNode.<T>makeLeft(Jitem.makeString(part, value)));
    }

    @Override
    public void seeBooleanItem(Boolean value) {
        Integer index = incIndex();
        PathPart part = PathPart.index(index);
        map.putIndexed(index, TreeNode.<T>makeLeft(Jitem.makeBoolean(part, value)));
    }

    @Override
    public void seeLongItem(Long value) {
        Integer index = incIndex();
        PathPart part = PathPart.index(index);
        map.putIndexed(index, TreeNode.<T>makeLeft(Jitem.makeLong(part, value)));
    }

    @Override
    public void seeDoubleItem(Double value) {
        Integer index = incIndex();
        PathPart part = PathPart.index(index);
        map.putIndexed(index, TreeNode.<T>makeLeft(Jitem.makeDouble(part, value)));
    }

    public TreeNodeMap<T> getTreeNodeMap() {
        return map;
    }

    @Override
    public void writeTo(T out) {
        writer.writeTo(getTreeNodeMap(), out);
    }
}
