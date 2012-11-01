package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.functional.*;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/28/12 3:22 AM
 */
public class JThing implements TypedVisitable, UntypedVisitable {

    private final Model model;
    private final TypedVisitable value;

    private JThing(Model model, TypedVisitable value) {
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

    @Override
    public void acceptTyped(Path path, TypedVisitor visitor) throws VisitException {
        value.acceptTyped(path, visitor);
    }

    @Override
    public void acceptUntyped(Path path, UntypedVisitor visitor) throws VisitException {
        if (visitor.visitThing(path, this)) {
            if (isObject()) {
                for (Map.Entry<String, JThing> entry : rawGetObject().seq()) {
                    entry.getValue().acceptUntyped(path.consKey(entry.getKey()), visitor);
                }
            } else if (isArray()) {
                for (Map.Entry<Integer, JThing> entry : rawGetArray().seq()) {
                    entry.getValue().acceptUntyped(path.consIndex(entry.getKey()), visitor);
                }
            }
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
