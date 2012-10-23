package net.exathunk.jereal.base;

public class Jitem {

    public enum Model {
        STRING, LONG, DOUBLE, BOOLEAN, OBJECT
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
}
