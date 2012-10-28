package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.functional.Either;
import net.exathunk.jereal.base.functional.Either3;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;
import net.exathunk.jereal.schema.Schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * charolastra 10/27/12 6:33 PM
 */
public class JDSL {

    public static boolean addSimple(PathPart part, Object value, JerialContext context) {
        if (value != null) {
           if (value instanceof String) {
              context.builder.addJitem(Jitem.makeString(part, (String) value));
           } else if (value instanceof Long) {
               context.builder.addJitem(Jitem.makeLong(part, (Long) value));
           } else if (value instanceof Double) {
               context.builder.addJitem(Jitem.makeDouble(part, (Double) value));
           } else if (value instanceof Boolean) {
               context.builder.addJitem(Jitem.makeBoolean(part, (Boolean) value));
           } else {
               return false;
           }
           return true;
        }
        return false;
    }

    public static boolean addSimple(String key, Object value, JerialContext context) {
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

    public static void add(JerializerRegistry registry, PathPart part, Object value, JerialContext context) throws JerializerException {
        if (!addSimple(part, value, context)) {
            addSubObject(registry, part, value, context);
        }
    }

    public static <A, B> void addEither(JerializerRegistry registry, PathPart part, Either<A, B> either, JerialContext context) throws JerializerException {
        if (either == null) return;
        if (either.hasLeft()) {
            add(registry, part, either.getLeft(), context);
        } else {
            add(registry, part, either.getRight(), context);
        }
    }

    public static <A, B, C> void addEither3(JerializerRegistry registry, PathPart part, Either3<A, B, C> either, JerialContext context) throws JerializerException {
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
        List<Jitem> arr = new ArrayList<Jitem>(types.size());
        for (int i = 0; i < types.size(); ++i) {
            arr.add(Jitem.makeString(PathPart.index(i), types.get(i).toString()));
        }
        if (arr.size() == 1) {
            context.builder.addJitem(Jitem.makeString(PathPart.key(key), arr.get(0).getString()));
        } else {
            context.builder.addJitem(Jitem.makeArray(PathPart.key(key), arr));
        }
    }

    public static <T> void addSubObject(JerializerRegistry registry, PathPart part, T subObject, JerialContext context) throws JerializerException {
        if (subObject == null) return;
        JerialContext newContext = context.push(part);
        Jerializer<T> jerializer = registry.getJerializer((Class<T>)subObject.getClass());
        jerializer.jerialize(registry, subObject, newContext);
        context.builder.addJitem(Jitem.makeObject(part, newContext.builder.buildObject()));
    }

    public static <T> void addMap(JerializerRegistry registry, PathPart part, Map<String, T> subObjectMap, JerialContext context) throws JerializerException {
        if (subObjectMap == null) return;
        JerialContext parentContext = context.push(part);
        for (Map.Entry<String, T> entry : subObjectMap.entrySet()) {
            add(registry, PathPart.key(entry.getKey()), entry.getValue(), parentContext);
        }
        context.builder.addJitem(Jitem.makeObject(part, parentContext.builder.buildObject()));
    }

    public static <T> void addList(JerializerRegistry registry, PathPart part, List<T> subObjectList, JerialContext context) throws JerializerException {
        if (subObjectList == null) return;
        final PathPart parentPart = PathPart.key("links");
        JerialContext parentContext = context.push(parentPart);
        List<Jitem> list = new ArrayList<Jitem>();
        int i = 0;
        for (T subObject : subObjectList) {
            final PathPart childPart = PathPart.index(i);
            JerialContext childContext = parentContext.push(childPart);
            Jerializer<T> jerializer = registry.getJerializer((Class<T>)subObject.getClass());
            jerializer.jerialize(registry, subObject, childContext);
            list.add(Jitem.makeObject(childPart, childContext.builder.buildObject()));
            i += 1;
        }
        context.builder.addJitem(Jitem.makeArray(part, list));
    }
}
