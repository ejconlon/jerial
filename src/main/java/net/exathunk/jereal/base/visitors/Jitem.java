package net.exathunk.jereal.base.visitors;

import java.util.List;

public class Jitem {

    public enum Model {
        STRING, LONG, DOUBLE, BOOLEAN, OBJECT, ARRAY
    }

    private final PathPart part;
    private final Object value;
    private final Model model;

    private Jitem(PathPart part, Object value, Model model) {
        this.part = part;
        this.value = value;
        this.model = model;
        assert part != null;
        assert model != null;
    }

    public PathPart getPart() {
        return part;
    }

    public Model getModel() {
        return model;
    }

    public String getString() {
        assert isString();
        return (String)value;
    }

    public Long getLong() {
        assert isLong();
        return (Long)value;
    }

    public Boolean getBoolean() {
        assert isBoolean();
        return (Boolean)value;
    }

    public Double getDouble() {
        assert isDouble();
        return (Double)value;
    }

    public Jerial getObject() {
        assert isObject();
        return (Jerial)value;
    }

    public List<Jitem> getArray() {
        assert isArray();
        return (List<Jitem>)value;
    }

    public boolean isString() {
        return model.equals(Model.STRING);
    }

    public boolean isLong() {
        return model.equals(Model.LONG);
    }

    public boolean isBoolean() {
        return model.equals(Model.BOOLEAN);
    }

    public boolean isDouble() {
        return model.equals(Model.DOUBLE);
    }

    public boolean isObject() {
        return model.equals(Model.OBJECT);
    }

    public boolean isArray() {
        return model.equals(Model.ARRAY);
    }

    public static Jitem makeObject(PathPart part, Jerial value) {
        return new Jitem(part, value, Model.OBJECT);
    }

    public static Jitem makeArray(PathPart part, List<Jitem> value) {
        return new Jitem(part, value, Model.ARRAY);
    }

    public static Jitem makeString(PathPart part, String value) {
        return new Jitem(part, value, Model.STRING);
    }

    public static Jitem makeLong(PathPart part, Long value) {
        return new Jitem(part, value, Model.LONG);
    }

    public static Jitem makeDouble(PathPart part, Double value) {
        return new Jitem(part, value, Model.DOUBLE);
    }

    public static Jitem makeBoolean(PathPart part, Boolean value) {
        return new Jitem(part, value, Model.BOOLEAN);
    }

    public Jitem withPart(PathPart newPart) {
        return new Jitem(newPart, value, model);
    }

    public String toString() {
        return "Jitem<"+part+","+(value == null ? "NULL" : value)+","+model+">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jitem jitem = (Jitem) o;

        if (model != jitem.model) return false;
        if (!part.equals(jitem.part)) return false;
        if (value != null ? !value.equals(jitem.value) : jitem.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = part.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + model.hashCode();
        return result;
    }
}
