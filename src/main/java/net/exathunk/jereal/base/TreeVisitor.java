package net.exathunk.jereal.base;

import java.util.HashMap;
import java.util.Map;

// This is a visitor that builds a tree of parsed Jitems and unparsed (in-progress) suspensions
public abstract class TreeVisitor<T> implements JerialVisitor.ObjectVisitor<T> {
    private final Map<String, Either<Jitem, TreeVisitor<T>>> pairs = new HashMap<String, Either<Jitem, TreeVisitor<T>>>();

    public Map<String, Either<Jitem, TreeVisitor<T>>> getPairs() { return pairs; }

    protected void addObjectVisitor(String key, TreeVisitor<T> item) {
        pairs.put(key, Either.<Jitem, TreeVisitor<T>>makeRight(item));
    }

    @Override
    public void seeStringField(String key, String value) {
        pairs.put(key, Either.<Jitem, TreeVisitor<T>>makeLeft(Jitem.makeString(key, value)));
    }

    @Override
    public void seeBooleanField(String key, Boolean value) {
        pairs.put(key, Either.<Jitem, TreeVisitor<T>>makeLeft(Jitem.makeBoolean(key, value)));
    }

    @Override
    public void seeLongField(String key, Long value) {
        pairs.put(key, Either.<Jitem, TreeVisitor<T>>makeLeft(Jitem.makeLong(key, value)));
    }

    @Override
    public void seeDoubleField(String key, Double value) {
        pairs.put(key, Either.<Jitem, TreeVisitor<T>>makeLeft(Jitem.makeDouble(key, value)));
    }
}
