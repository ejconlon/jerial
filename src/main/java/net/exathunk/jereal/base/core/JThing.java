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

    private final Model model;
    private final Object value;

    private JThing(Model model, Object value) {
        this.model = model;
        this.value = value;
        assert model != null;
        assert value != null;
    }

    public Maybe<JObject> getObject() {
        if (Model.OBJECT.equals(model)) {
            return Maybe.just((JObject) value);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JArray> getArray() {
        if (Model.ARRAY.equals(model)) {
            return Maybe.just((JArray) value);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JString> getString() {
        if (Model.STRING.equals(model)) {
            return Maybe.just((JString) value);
        } else {
            return Maybe.nothing();
        }
    }
    public Maybe<JBoolean> getBoolean() {
        if (Model.BOOLEAN.equals(model)) {
            return Maybe.just((JBoolean) value);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JLong> getLong() {
        if (Model.LONG.equals(model)) {
            return Maybe.just((JLong) value);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JDouble> getDouble() {
        if (Model.DOUBLE.equals(model)) {
            return Maybe.just((JDouble) value);
        } else {
            return Maybe.nothing();
        }
    }

    public JObject  rawGetObject()  { return (JObject) value; }
    public JArray   rawGetArray()   { return (JArray) value; }
    public JString  rawGetString()  { return (JString) value; }
    public JBoolean rawGetBoolean() { return (JBoolean) value; }
    public JLong    rawGetLong()    { return (JLong) value; }
    public JDouble  rawGetDouble()  { return (JDouble) value; }

    public boolean isObject() {
        return (Model.OBJECT.equals(model));
    }

    public boolean isArray() {
        return (Model.ARRAY.equals(model));
    }

    public boolean isString() {
        return (Model.STRING.equals(model));
    }

    public boolean isBoolean() {
        return (Model.BOOLEAN.equals(model));
    }

    public boolean isLong() {
        return (Model.LONG.equals(model));
    }

    public boolean isDouble() {
        return (Model.DOUBLE.equals(model));
    }

    public Model getModel() {
        return model;
    }

    public static JThing make(JObject object) {
        return new JThing(Model.OBJECT, object);
    }

    public static JThing make(JArray array) {
        return new JThing(Model.ARRAY, array);
    }

    public static JThing make(JString scalar) {
        return new JThing(Model.STRING, scalar);
    }

    public static JThing make(JBoolean scalar) {
        return new JThing(Model.BOOLEAN, scalar);
    }

    public static JThing make(JLong scalar) {
        return new JThing(Model.LONG, scalar);
    }

    public static JThing make(JDouble scalar) {
        return new JThing(Model.DOUBLE, scalar);
    }

    public static JThing make(Map<String, JThing> object) {
        return new JThing(Model.OBJECT, new JObject(object));
    }

    public static JThing make(List<JThing> array) {
        return new JThing(Model.ARRAY, new JArray(array));
    }

    public static JThing make(String scalar) {
        return new JThing(Model.STRING, new JString(scalar));
    }

    public static JThing make(Boolean scalar) {
        return new JThing(Model.BOOLEAN, new JBoolean(scalar));
    }

    public static JThing make(Long scalar) {
        return new JThing(Model.LONG, new JLong(scalar));
    }

    public static JThing make(Double scalar) {
        return new JThing(Model.DOUBLE, new JDouble(scalar));
    }

    @Override
    public String toString() {
        return "JThing{" +
                "model=" + model +
                ", value=" + value +
                '}';
    }

    public static <T> void acceptObjectVisitor(VisitorFactory<T> factory, String key, JThing value, ObjectVisitor<T> visitor) {
        switch (value.getModel()) {
            case OBJECT:
                ObjectVisitor<T> childObjectVisitor = visitor.seeObjectFieldStart(key);
                for (Map.Entry<String, JThing> entry : value.rawGetObject().seq()) {
                    entry.getValue().acceptObjectVisitor(factory, entry.getKey(), entry.getValue(), childObjectVisitor);
                }
                break;
            case ARRAY:
                ArrayVisitor<T> childArrayVisitor = visitor.seeArrayFieldStart(key);
                for (Map.Entry<Integer, JThing> entry : value.rawGetArray().seq()) {
                    entry.getValue().acceptArrayVisitor(factory,  entry.getKey(), entry.getValue(), childArrayVisitor);
                }
                break;
            case STRING:
                visitor.seeStringField(key, value.rawGetString().runResFunc());
                break;
            case BOOLEAN:
                visitor.seeBooleanField(key, value.rawGetBoolean().runResFunc());
                break;
            case LONG:
                visitor.seeLongField(key, value.rawGetLong().runResFunc());
                break;
            case DOUBLE:
                visitor.seeDoubleField(key, value.rawGetDouble().runResFunc());
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public static <T> void acceptArrayVisitor(VisitorFactory<T> factory, Integer index, JThing value, ArrayVisitor<T> visitor) {
        switch (value.getModel()) {
            case OBJECT:
                ObjectVisitor<T> childObjectVisitor = visitor.seeObjectItemStart();
                for (Map.Entry<String, JThing> entry : value.rawGetObject().seq()) {
                    entry.getValue().acceptObjectVisitor(factory, entry.getKey(), entry.getValue(), childObjectVisitor);
                }
                break;
            case ARRAY:
                ArrayVisitor<T> childArrayVisitor = visitor.seeArrayItemStart();
                for (Map.Entry<Integer, JThing> entry : value.rawGetArray().seq()) {
                    entry.getValue().acceptArrayVisitor(factory,  entry.getKey(), entry.getValue(), childArrayVisitor);
                }
                break;
            case STRING:
                visitor.seeStringItem(value.rawGetString().runResFunc());
                break;
            case BOOLEAN:
                visitor.seeBooleanItem(value.rawGetBoolean().runResFunc());
                break;
            case LONG:
                visitor.seeLongItem(value.rawGetLong().runResFunc());
                break;
            case DOUBLE:
                visitor.seeDoubleItem(value.rawGetDouble().runResFunc());
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public <T> Maybe<Func1<T>> accept(VisitorFactory<T> factory) {
        if (isObject()) {
            ObjectVisitor<T> visitor = factory.makeObjectVisitor();
            for (Map.Entry<String, JThing> entry : rawGetObject().seq()) {
                acceptObjectVisitor(factory, entry.getKey(), entry.getValue(), visitor);
            }
            return Maybe.<Func1<T>>just(visitor);
        } else if (isArray()) {
            ArrayVisitor<T> visitor = factory.makeArrayVisitor();
            for (Map.Entry<Integer, JThing> entry : rawGetArray().seq()) {
                acceptArrayVisitor(factory, entry.getKey(), entry.getValue(), visitor);
            }
            return Maybe.<Func1<T>>just(visitor);
        }
        return Maybe.nothing();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JThing entries = (JThing) o;

        if (!value.equals(entries.value)) return false;
        if (model != entries.model) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
