package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/28/12 3:22 AM
 */
public class JThing implements UntypedVisitable, Visitable {

    private final Visitable value;

    private JThing(Visitable value) {
        this.value = value;
        assert value != null;
    }

    public Maybe<JObject> getObject() {
        if (Model.OBJECT.equals(getModel())) {
            return Maybe.just((JObject) value);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JArray> getArray() {
        if (Model.ARRAY.equals(getModel())) {
            return Maybe.just((JArray) value);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JString> getString() {
        if (Model.STRING.equals(getModel())) {
            return Maybe.just((JString) value);
        } else {
            return Maybe.nothing();
        }
    }
    public Maybe<JBoolean> getBoolean() {
        if (Model.BOOLEAN.equals(getModel())) {
            return Maybe.just((JBoolean) value);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JLong> getLong() {
        if (Model.LONG.equals(getModel())) {
            return Maybe.just((JLong) value);
        } else {
            return Maybe.nothing();
        }
    }

    public Maybe<JDouble> getDouble() {
        if (Model.DOUBLE.equals(getModel())) {
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
        return (Model.OBJECT.equals(getModel()));
    }

    public boolean isArray() {
        return (Model.ARRAY.equals(getModel()));
    }

    public boolean isString() {
        return (Model.STRING.equals(getModel()));
    }

    public boolean isBoolean() {
        return (Model.BOOLEAN.equals(getModel()));
    }

    public boolean isLong() {
        return (Model.LONG.equals(getModel()));
    }

    public boolean isDouble() {
        return (Model.DOUBLE.equals(getModel()));
    }

    public Model getModel() {
        return value.getModel();
    }

    public static JThing make(JObject visitable) {
        return new JThing(visitable);
    }
    public static JThing make(JArray visitable) {
        return new JThing(visitable);
    }
    public static JThing make(JString visitable) {
        return new JThing(visitable);
    }
    public static JThing make(JBoolean visitable) {
        return new JThing(visitable);
    }
    public static JThing make(JDouble visitable) {
        return new JThing(visitable);
    }
    public static JThing make(JLong visitable) {
        return new JThing(visitable);
    }

    public static JThing make(Map<String, JThing> object) {
        return new JThing(new JObject(object));
    }

    public static JThing make(List<JThing> array) {
        return new JThing(new JArray(array));
    }

    public static JThing make(String scalar) {
        return new JThing(new JString(scalar));
    }

    public static JThing make(Boolean scalar) {
        return new JThing(new JBoolean(scalar));
    }

    public static JThing make(Long scalar) {
        return new JThing(new JLong(scalar));
    }

    public static JThing make(Double scalar) {
        return new JThing(new JDouble(scalar));
    }

    @Override
    public String toString() {
        return "JThing{" +
                "value=" + value +
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
    public <A extends PushableContext<A, B>, B extends Questionable> Pipeable<B> acceptDSL(DSL<A, B> dsl) {
        return value.acceptDSL(dsl);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JThing entries = (JThing) o;

        if (!value.equals(entries.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        return result;
    }

    @Override
    public JThing toJThing() {
        return this;
    }

    @Override
    public boolean hasMapSpec() {
        return value.hasMapSpec();
    }

    @Override
    public Map<String, ? extends Speclike> getMapSpec() {
        return value.getMapSpec();
    }

    @Override
    public boolean hasListSpec() {
        return value.hasListSpec();
    }

    @Override
    public List<? extends Speclike> getListSpec() {
        return value.getListSpec();
    }

    @Override
    public Speclike makeSpec() {
        return this;
    }

    public static JThing fromSpec(Speclike spec) {
        switch (spec.getModel()) {
            case OBJECT:
                assert spec.hasMapSpec();
                return JThing.make(JObject.fromSpec(spec.getMapSpec()));
            case ARRAY:
                assert spec.hasListSpec();
                return JThing.make(JArray.fromSpec(spec.getListSpec()));
            case STRING:
                return JThing.make(new JString());
            case BOOLEAN:
                return JThing.make(new JBoolean());
            case LONG:
                return JThing.make(new JLong());
            case DOUBLE:
                return JThing.make(new JDouble());
            default:
                throw new IllegalArgumentException("Unhandled model: "+spec.getModel());
        }
    }
}
