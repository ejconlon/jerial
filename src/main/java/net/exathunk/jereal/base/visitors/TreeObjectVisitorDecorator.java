package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/27/12 2:10 PM
 */
public class TreeObjectVisitorDecorator<T> implements TreeObjectVisitor<T> {

    private final TreeObjectVisitor<T> decorated;

    public TreeObjectVisitorDecorator(TreeObjectVisitor<T> decorated) {
        this.decorated = decorated;
    }

    @Override
    public ObjectVisitor<T> seeObjectFieldStart(String key) {
        return decorated.seeObjectFieldStart(key);
    }

    @Override
    public ArrayVisitor<T> seeArrayFieldStart(String key) {
        return decorated.seeArrayFieldStart(key);
    }

    @Override
    public void seeStringField(String key, String value) {
        decorated.seeStringField(key, value);
    }

    @Override
    public void seeBooleanField(String key, Boolean value) {
        decorated.seeBooleanField(key, value);
    }

    @Override
    public void seeLongField(String key, Long value) {
        decorated.seeLongField(key, value);
    }

    @Override
    public void seeDoubleField(String key, Double value) {
        decorated.seeDoubleField(key, value);
    }

    @Override
    public TreeNodeMap<T> getTreeNodeMap() {
        return decorated.getTreeNodeMap();
    }

    @Override
    public void writeTo(T out) {
        decorated.writeTo(out);
    }
}
