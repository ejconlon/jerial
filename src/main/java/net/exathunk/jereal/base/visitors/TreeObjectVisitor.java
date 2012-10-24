package net.exathunk.jereal.base.visitors;

import java.util.HashMap;
import java.util.Map;

// This is a visitor that builds a tree of parsed Jitems and unparsed (in-progress) suspensions
public abstract class TreeObjectVisitor<T> implements ObjectVisitor<T> {

    private final Map<String, JerialNode<T>> items = new HashMap<String, JerialNode<T>>();

    public Map<String, JerialNode<T>> getItems() { return items; }

    protected void addObjectVisitor(String key, TreeObjectVisitor<T> item) {
        items.put(key, JerialNode.<T>makeMiddle(item));
    }

    protected void addArrayVisitor(String key, TreeArrayVisitor<T> item) {
        items.put(key, JerialNode.<T>makeRight(item));
    }

    @Override
    public void seeStringField(String key, String value) {
        items.put(key, JerialNode.<T>makeLeft(Jitem.makeString(key, value)));
    }

    @Override
    public void seeBooleanField(String key, Boolean value) {
        items.put(key, JerialNode.<T>makeLeft(Jitem.makeBoolean(key, value)));
    }

    @Override
    public void seeLongField(String key, Long value) {
        items.put(key, JerialNode.<T>makeLeft(Jitem.makeLong(key, value)));
    }

    @Override
    public void seeDoubleField(String key, Double value) {
        items.put(key, JerialNode.<T>makeLeft(Jitem.makeDouble(key, value)));
    }
}
