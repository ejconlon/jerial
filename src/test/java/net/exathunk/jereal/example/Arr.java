package net.exathunk.jereal.example;

import net.exathunk.jereal.base.visitors.Jitem;
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
                objects.add(Jitem.makeString(PathPart.makeRight(i), (String) x));
            } else if (x instanceof Long) {
                objects.add(Jitem.makeLong(PathPart.makeRight(i), (Long) x));
            } else if (x instanceof Double) {
                objects.add(Jitem.makeDouble(PathPart.makeRight(i), (Double) x));
            } else if (x instanceof Boolean) {
                objects.add(Jitem.makeBoolean(PathPart.makeRight(i), (Boolean) x));
            } else {
                throw new UnsupportedOperationException();
            }
            i += 1;
        }
    }
}
