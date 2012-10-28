package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/27/12 2:07 PM
 */
public class TreeArrayVisitorDecorator<T> implements TreeArrayVisitor<T> {

    private final TreeArrayVisitor<T> decorated;

    public TreeArrayVisitorDecorator(TreeArrayVisitor<T> decorated) {
        this.decorated = decorated;
    }

    @Override
    public ObjectVisitor<T> seeObjectItemStart() {
        return decorated.seeObjectItemStart();
    }

    @Override
    public ArrayVisitor<T> seeArrayItemStart() {
        return decorated.seeArrayItemStart();
    }

    @Override
    public void seeStringItem(String value) {
        decorated.seeStringItem(value);
    }

    @Override
    public void seeBooleanItem(Boolean value) {
        decorated.seeBooleanItem(value);
    }

    @Override
    public void seeLongItem(Long value) {
        decorated.seeLongItem(value);
    }

    @Override
    public void seeDoubleItem(Double value) {
        decorated.seeDoubleItem(value);
    }

    @Override
    public TreeNodeMap<T> getTreeNodeMap() {
        return decorated.getTreeNodeMap();
    }

    @Override
    public void runFunc(T out) {
        decorated.runFunc(out);
    }
}
