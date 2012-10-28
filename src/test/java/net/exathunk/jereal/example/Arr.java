package net.exathunk.jereal.example;

import net.exathunk.jereal.base.core.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.ArrayList;
import java.util.List;

/**
 * charolastra 10/23/12 9:44 PM
 */
public class Arr {
    public final List<Jitem> objects;

    public Arr(Object... args) {
        objects = new ArrayList<Jitem>(args.length);
        int i = 0;
        for (final Object x : args) {
            if (x instanceof String) {
                objects.add(Jitem.makeString(PathPart.index(i), (String) x));
            } else if (x instanceof Long) {
                objects.add(Jitem.makeLong(PathPart.index(i), (Long) x));
            } else if (x instanceof Double) {
                objects.add(Jitem.makeDouble(PathPart.index(i), (Double) x));
            } else if (x instanceof Boolean) {
                objects.add(Jitem.makeBoolean(PathPart.index(i), (Boolean) x));
            } else {
                throw new UnsupportedOperationException();
            }
            i += 1;
        }
    }
}
