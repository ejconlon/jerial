package net.exathunk.jereal.base.visitors;

import java.util.List;

public class Jitem {
    public enum Model {
        STRING, LONG, DOUBLE, BOOLEAN, OBJECT, ARRAY
    }

    public final String key;
    public final Object value;
    public final Model model;

    private Jitem(String key, Object value, Model model) {
        this.key = key;
        this.value = value;
        this.model = model;
    }

    public static Jitem makeObject(String key, Jerial value) {
        return new Jitem(key, value, Model.OBJECT);
    }

    public static Jitem makeArray(String key, List<Jitem> value) {
        return new Jitem(key, value, Model.ARRAY);
    }

    public static Jitem makeString(String key, String value) {
        return new Jitem(key, value, Model.STRING);
    }

    public static Jitem makeLong(String key, Long value) {
        return new Jitem(key, value, Model.LONG);
    }

    public static Jitem makeDouble(String key, Double value) {
        return new Jitem(key, value, Model.DOUBLE);
    }

    public static Jitem makeBoolean(String key, Boolean value) {
        return new Jitem(key, value, Model.BOOLEAN);
    }

    public String toString() {
        return "Jitem<"+(key != null ? key : "null")+","+(value != null ? value.toString() : "null")+","+model+">";
    }
}
