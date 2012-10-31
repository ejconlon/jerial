package net.exathunk.jereal.example;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * charolastra 10/23/12 9:44 PM
 */
public class Arr {
    public final Ref<List<JThing>> objects;

    public Arr(Object... args) {
        objects = new RefImpl<List<JThing>>(new ArrayList<JThing>(args.length));
        int i = 0;
        for (final Object x : args) {
            if (x instanceof String) {
                objects.getRef().add(JThing.make(new JString((String)x)));
            } else if (x instanceof Long) {
                objects.getRef().add(JThing.make(new JLong((Long) x)));
            } else if (x instanceof Double) {
                objects.getRef().add(JThing.make(new JDouble((Double) x)));
            } else if (x instanceof Boolean) {
                objects.getRef().add(JThing.make(new JBoolean((Boolean) x)));
            } else {
                throw new UnsupportedOperationException();
            }
            i += 1;
        }
    }
}
