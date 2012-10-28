package net.exathunk.jereal.example;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.ArrayList;
import java.util.List;

/**
 * charolastra 10/23/12 9:44 PM
 */
public class Arr {
    public final List<JThing> objects;

    public Arr(Object... args) {
        objects = new ArrayList<JThing>(args.length);
        int i = 0;
        for (final Object x : args) {
            if (x instanceof String) {
                objects.add(JThing.make(new JString((String)x)));
            } else if (x instanceof Long) {
                objects.add(JThing.make(new JLong((Long) x)));
            } else if (x instanceof Double) {
                objects.add(JThing.make(new JDouble((Double) x)));
            } else if (x instanceof Boolean) {
                objects.add(JThing.make(new JBoolean((Boolean) x)));
            } else {
                throw new UnsupportedOperationException();
            }
            i += 1;
        }
    }
}
