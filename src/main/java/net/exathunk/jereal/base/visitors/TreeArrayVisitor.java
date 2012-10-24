package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.Either3;

import java.util.ArrayList;
import java.util.List;

/**
 * charolastra 10/23/12 10:12 PM
 */
public abstract class TreeArrayVisitor<T> implements ArrayVisitor<T> {

    private final List<Either3<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>>> items = new ArrayList<Either3<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>>>();

    public List<Either3<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>>> getItems() { return items; }

    protected void addObjectVisitor(TreeObjectVisitor<T> item) {
        items.add(Either3.<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>>makeMiddle(item));
    }

    protected void addArrayVisitor(TreeArrayVisitor<T> item) {
        items.add(Either3.<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>>makeRight(item));
    }

    @Override
    public void seeStringItem(String value) {
        items.add(Either3.<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>>makeLeft(Jitem.makeString(null, value)));
    }

    @Override
    public void seeBooleanItem(Boolean value) {
        items.add(Either3.<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>>makeLeft(Jitem.makeBoolean(null, value)));
    }

    @Override
    public void seeLongItem(Long value) {
        items.add(Either3.<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>>makeLeft(Jitem.makeLong(null, value)));
    }

    @Override
    public void seeDoubleItem(Double value) {
        items.add(Either3.<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>>makeLeft(Jitem.makeDouble(null, value)));
    }
}
