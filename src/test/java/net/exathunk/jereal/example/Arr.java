package net.exathunk.jereal.example;

import net.exathunk.jereal.base.visitors.Jitem;

import java.util.ArrayList;
import java.util.List;

/**
 * charolastra 10/23/12 9:44 PM
 */
public class Arr {
    public final List<Jitem> objects;

    public Arr(Object... args) {
        objects = new ArrayList<Jitem>(args.length);
        for (final Object x : args) {
            if (x instanceof String) {
                objects.add(Jitem.makeString(null, (String) x));
            } else if (x instanceof Long) {
                objects.add(Jitem.makeLong(null, (Long) x));
            } else if (x instanceof Double) {
                objects.add(Jitem.makeDouble(null, (Double) x));
            } else if (x instanceof Boolean) {
                objects.add(Jitem.makeBoolean(null, (Boolean) x));
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }
}
