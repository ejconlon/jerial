package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.Either;
import net.exathunk.jereal.base.functional.Either3;
import net.exathunk.jereal.base.visitors.PathPart;
import net.exathunk.jereal.schema.Schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * charolastra 10/27/12 6:33 PM
 */
public class JDSL {

    private static boolean addSimple(PathPart part, Object value, JerialContext context) {
        if (value != null) {
           if (value instanceof String) {
              context.builder.addThing(part, JThing.make(new JString((String) value)));
           } else if (value instanceof Long) {
               context.builder.addThing(part, JThing.make(new JLong((Long) value)));
           } else if (value instanceof Double) {
               context.builder.addThing(part, JThing.make(new JDouble((Double) value)));
           } else if (value instanceof Boolean) {
               context.builder.addThing(part, JThing.make(new JBoolean((Boolean) value)));
           } else if (value instanceof Enum) {
               // to make TYPE enum work easily
               context.builder.addThing(part, JThing.make(new JString(value.toString())));
           } else {
               return false;
           }
           return true;
        }
        return false;
    }

    private static boolean addSimple(String key, Object value, JerialContext context) {
        return addSimple(PathPart.key(key), value, context);
    }

    public static void addBoolean(String key, Boolean value, JerialContext context) {
        addSimple(key, value, context);
    }

    public static void addLong(String key, Long value, JerialContext context) {
        addSimple(key, value, context);
    }

    public static void addString(String key, String value, JerialContext context) {
        addSimple(key, value, context);
    }

    private static boolean addStructural(JerializerRegistry registry, PathPart part, Object value, JerialContext context) throws JerializerException {
        if (value instanceof Either) {
            addEither(registry, part, (Either)value, context);
        } else if (value instanceof Either3) {
            addEither3(registry, part, (Either3) value, context);
        } else {
            return false;
        }
        return true;
    }

    public static void add(JerializerRegistry registry, PathPart part, Object value, JerialContext context) throws JerializerException {
        if (!addSimple(part, value, context)) {
            if (!addStructural(registry, part, value, context)) {
                addCustom(registry, part, value, context);
            }
        }
    }

    private static <A, B> void addEither(JerializerRegistry registry, PathPart part, Either<A, B> either, JerialContext context) throws JerializerException {
        if (either == null) return;
        if (either.hasLeft()) {
            add(registry, part, either.getLeft(), context);
        } else {
            add(registry, part, either.getRight(), context);
        }
    }

    private static <A, B, C> void addEither3(JerializerRegistry registry, PathPart part, Either3<A, B, C> either, JerialContext context) throws JerializerException {
        if (either == null) return;
        if (either.hasLeft()) {
            add(registry, part, either.getLeft(), context);
        } else if (either.hasMiddle()) {
            add(registry, part, either.getMiddle(), context);
        } else {
            add(registry, part, either.getRight(), context);
        }
    }

    public static void addTypes(String key, List<Schema.TYPE> types, JerialContext context) {
        if (types == null) return;
        List<JThing> arr = new ArrayList<JThing>(types.size());
        for (int i = 0; i < types.size(); ++i) {
            arr.add(JThing.make(new JString(types.get(i).toString())));
        }
        if (arr.size() == 1) {
            context.builder.addThing(PathPart.key(key), arr.get(0));
        } else {
            context.builder.addThing(PathPart.key(key), JThing.make(new JArray(arr)));
        }
    }

    private static <T> void addCustom(JerializerRegistry registry, PathPart part, T subObject, JerialContext context) throws JerializerException {
        if (subObject == null) return;
        JerialContext newContext = context.push(part);
        Jerializer<T> jerializer = registry.getJerializer((Class<T>)subObject.getClass());
        jerializer.jerialize(registry, subObject, newContext);
        context.builder.addThing(part, JThing.make(newContext.builder.buildObject()));
    }

    public static <T> void addMap(JerializerRegistry registry, PathPart part, Map<String, T> subObjectMap, JerialContext context) throws JerializerException {
        if (subObjectMap == null) return;
        JerialContext parentContext = context.push(part);
        for (Map.Entry<String, T> entry : subObjectMap.entrySet()) {
            add(registry, PathPart.key(entry.getKey()), entry.getValue(), parentContext);
        }
        context.builder.addThing(part, JThing.make(parentContext.builder.buildObject()));
    }

    public static <T> void addSinglyList(JerializerRegistry registry, PathPart part, List<T> subObjectList, JerialContext context) throws JerializerException {
        if (subObjectList == null) return;
        if (subObjectList.size() == 1) {
            add(registry, part, subObjectList.get(0), context);
        } else {
            addList(registry, part, subObjectList, context);
        }
    }

    public static <T> void addList(JerializerRegistry registry, PathPart part, List<T> subObjectList, JerialContext context) throws JerializerException {
        if (subObjectList == null) return;
        final PathPart parentPart = PathPart.key("links");
        JerialContext parentContext = context.push(parentPart);
        int i = 0;
        for (T subObject : subObjectList) {
            final PathPart childPart = PathPart.index(i);
            add(registry, childPart, subObject, parentContext);
            i += 1;
        }
        JArray array = parentContext.builder.buildArray();
        context.builder.addThing(part, JThing.make(array));
    }
}
