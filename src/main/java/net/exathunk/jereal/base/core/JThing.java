package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.visitors.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * charolastra 10/28/12 3:22 AM
 */
public class JThing implements Sequence<Map.Entry<ConsList<PathPart>, JThing>> {
    private final Jitem.Model model;
    private final Object erased;

    private JThing(Jitem.Model model, Object erased) {
        this.model = model;
        this.erased = erased;
    }

    public Maybe<JObject> getObject() {
        if (Jitem.Model.OBJECT.equals(model)) {
            return Maybe.just((JObject)erased);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JArray> getArray() {
        if (Jitem.Model.ARRAY.equals(model)) {
            return Maybe.just((JArray)erased);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JString> getString() {
        if (Jitem.Model.STRING.equals(model)) {
            return Maybe.just((JString)erased);
        } else {
            return Maybe.nothing();
        }
    }
    public Maybe<JBoolean> getBoolean() {
        if (Jitem.Model.BOOLEAN.equals(model)) {
            return Maybe.just((JBoolean)erased);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JLong> getLong() {
        if (Jitem.Model.LONG.equals(model)) {
            return Maybe.just((JLong)erased);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JDouble> getDouble() {
        if (Jitem.Model.DOUBLE.equals(model)) {
            return Maybe.just((JDouble)erased);
        } else {
            return Maybe.nothing();
        }
    }

    private JObject  rawGetObject()  { return (JObject)erased; }
    private JArray   rawGetArray()   { return (JArray)erased; }
    private JString  rawGetString()  { return (JString)erased; }
    private JBoolean rawGetBoolean() { return (JBoolean)erased; }
    private JLong    rawGetLong()    { return (JLong)erased; }
    private JDouble  rawGetDouble()  { return (JDouble)erased; }

    public boolean isObject() {
        return (Jitem.Model.OBJECT.equals(model));
    }

    public boolean isArray() {
        return (Jitem.Model.ARRAY.equals(model));
    }

    public boolean isString() {
        return (Jitem.Model.STRING.equals(model));
    }

    public boolean isBoolean() {
        return (Jitem.Model.BOOLEAN.equals(model));
    }

    public boolean isLong() {
        return (Jitem.Model.LONG.equals(model));
    }

    public boolean isDouble() {
        return (Jitem.Model.DOUBLE.equals(model));
    }

    public Jitem.Model getModel() {
        return model;
    }

    public static JThing makeObject() {
        return new JThing(Jitem.Model.OBJECT, new JObject());
    }

    public static JThing makeArray() {
        return new JThing(Jitem.Model.ARRAY, new JArray());
    }

    public static JThing makeString(String value) {
        return new JThing(Jitem.Model.STRING, new JString(value));
    }

    public static JThing makeBoolean(Boolean value) {
        return new JThing(Jitem.Model.BOOLEAN, new JBoolean(value));
    }

    public static JThing makeLong(Long value) {
        return new JThing(Jitem.Model.LONG, new JLong(value));
    }

    public static JThing makeDouble(Double value) {
        return new JThing(Jitem.Model.DOUBLE, new JDouble(value));
    }

    public <T> void acceptObjectVisitor(VisitorFactory<T> factory, String key, ObjectVisitor<T> visitor) {
        switch (model) {
            case OBJECT:
                ObjectVisitor<T> childObjectVisitor = visitor.seeObjectFieldStart(key);
                for (Map.Entry<String, JThing> entry : rawGetObject().seq()) {
                    entry.getValue().acceptObjectVisitor(factory, entry.getKey(), childObjectVisitor);
                }
                break;
            case ARRAY:
                ArrayVisitor<T> childArrayVisitor = visitor.seeArrayFieldStart(key);
                for (Map.Entry<Integer, JThing> entry : rawGetArray().seq()) {
                    entry.getValue().acceptArrayVisitor(factory,  entry.getKey(), childArrayVisitor);
                }
                break;
            case STRING:
                visitor.seeStringField(key, rawGetString().runResFunc());
                break;
            case BOOLEAN:
                visitor.seeBooleanField(key, rawGetBoolean().runResFunc());
                break;
            case LONG:
                visitor.seeLongField(key, rawGetLong().runResFunc());
                break;
            case DOUBLE:
                visitor.seeDoubleField(key, rawGetDouble().runResFunc());
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public <T> void acceptArrayVisitor(VisitorFactory<T> factory, Integer index, ArrayVisitor<T> visitor) {
        switch (model) {
            case OBJECT:
                ObjectVisitor<T> childObjectVisitor = visitor.seeObjectItemStart();
                for (Map.Entry<String, JThing> entry : rawGetObject().seq()) {
                    entry.getValue().acceptObjectVisitor(factory, entry.getKey(), childObjectVisitor);
                }
                break;
            case ARRAY:
                ArrayVisitor<T> childArrayVisitor = visitor.seeArrayItemStart();
                for (Map.Entry<Integer, JThing> entry : rawGetArray().seq()) {
                    entry.getValue().acceptArrayVisitor(factory,  entry.getKey(), childArrayVisitor);
                }
                break;
            case STRING:
                visitor.seeStringItem(rawGetString().runResFunc());
                break;
            case BOOLEAN:
                visitor.seeBooleanItem(rawGetBoolean().runResFunc());
                break;
            case LONG:
                visitor.seeLongItem(rawGetLong().runResFunc());
                break;
            case DOUBLE:
                visitor.seeDoubleItem(rawGetDouble().runResFunc());
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public <T> Maybe<Writer<T>> accept(VisitorFactory<T> factory) {
        Writer<T> writer = null;
        if (isObject()) {
            ObjectVisitor<T> visitor = factory.makeObjectVisitor();
            acceptObjectVisitor(factory, null, visitor);
            writer = visitor;
        } else if (isArray()) {
            ArrayVisitor<T> visitor = factory.makeArrayVisitor();
            acceptArrayVisitor(factory, null, visitor);
            writer = visitor;
        }
        return Maybe.nonNull(writer);
    }

    @Override
    public Iterator<Map.Entry<ConsList<PathPart>, JThing>> iterator() {
        return new JThingPathIterator(ConsList.<PathPart>nil(), this);
    }

    private static class JThingPathIterator implements Iterator<Map.Entry<ConsList<PathPart>, JThing>> {
        private final ConsList<PathPart> path;
        private final JThing thing;
        private final List<JThingPathIterator> nexts;
        int index = -1;

        public JThingPathIterator(ConsList<PathPart> path, JThing thing) {
            this.path = path;
            this.thing = thing;
            nexts = new ArrayList<JThingPathIterator>();
            if (thing.isObject()) {
                for (Map.Entry<String, JThing> entry : thing.rawGetObject().seq()) {
                    nexts.add(new JThingPathIterator(path.cons(PathPart.key(entry.getKey())), entry.getValue()));
                }
            } else if (thing.isArray()) {
                for (Map.Entry<Integer, JThing> entry : thing.rawGetArray().seq()) {
                    nexts.add(new JThingPathIterator(path.cons(PathPart.index(entry.getKey())), entry.getValue()));
                }
            }
        }

        @Override
        public boolean hasNext() {
            if (index >= nexts.size()) return false;
            else if (index == 0) {
                return true;
            } else {
                while (index < nexts.size()) {
                    if (nexts.get(index).hasNext()) return true;
                    index++;
                }
                return false;
            }
        }

        @Override
        public Map.Entry<ConsList<PathPart>, JThing> next() {
            if (index == 0) {
                index++;
                return new Pair<ConsList<PathPart>, JThing>(path, thing);
            } else {
                while (index < nexts.size()) {
                    Iterator<Map.Entry<ConsList<PathPart>, JThing>> curit = nexts.get(index);
                    if (curit.hasNext()) {
                        return curit.next();
                    } else {
                        index++;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
