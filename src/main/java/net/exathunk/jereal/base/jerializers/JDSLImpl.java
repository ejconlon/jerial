package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.Either;
import net.exathunk.jereal.base.functional.Either3;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.schema.domain.Schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * charolastra 10/27/12 6:33 PM
 */
public class JDSLImpl implements JDSL {

    private <T> boolean addSimple(PathPart part, Ref<T> refValue, JerialContext context) {
        final T value = refValue.getRef();
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

    private boolean addSimple(String key, Ref<?> value, JerialContext context) {
        return addSimple(PathPart.key(key), value, context);
    }

    @Override
    public void addThing(String key, Ref<JThing> thing, JerialContext context) {
        if (thing == null || thing.isEmptyRef()) return;
        context.builder.addThing(PathPart.key(key), thing.getRef());
    }

    @Override
    public void addBoolean(String key, Ref<Boolean> value, JerialContext context) {
        addSimple(key, value, context);
    }

    @Override
    public void addLong(String key, Ref<Long> value, JerialContext context) {
        addSimple(key, value, context);
    }

    @Override
    public void addDouble(String key, Ref<Double> value, JerialContext context) {
        addSimple(key, value, context);
    }

    @Override
    public void addString(String key, Ref<String> value, JerialContext context) {
        addSimple(key, value, context);
    }

    private <T, A, B, C> boolean addStructural(JerializerRegistry registry, PathPart part, Ref<T> value, JerialContext context) throws JerializerException {
        if (value == null || value.isEmptyRef()) return false;
        if (value.getRef() instanceof Either) {
            addEither(registry, part, (Ref<Either<Ref<A>, Ref<B>>>)value, context);
        } else if (value.getRef() instanceof Either3) {
            addEither3(registry, part, (Ref<Either3<Ref<A>, Ref<B>, Ref<C>>>) value, context);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public <T> void add(JerializerRegistry registry, PathPart part, Ref<T> value, JerialContext context) throws JerializerException {
        if (!addSimple(part, value, context)) {
            if (!addStructural(registry, part, value, context)) {
                addCustom(registry, part, value, context);
            }
        }
    }

    private <A, B> void addEither(JerializerRegistry registry, PathPart part, Ref<Either<Ref<A>, Ref<B>>> either, JerialContext context) throws JerializerException {
        if (either == null || either.isEmptyRef()) return;
        if (either.getRef().hasLeft()) {
            add(registry, part, either.getRef().getLeft(), context);
        } else {
            add(registry, part, either.getRef().getRight(), context);
        }
    }

    private <A, B, C> void addEither3(JerializerRegistry registry, PathPart part, Ref<Either3<Ref<A>, Ref<B>, Ref<C>>> either, JerialContext context) throws JerializerException {
        if (either == null || either.isEmptyRef()) return;
        if (either.getRef().hasLeft()) {
            add(registry, part, either.getRef().getLeft(), context);
        } else if (either.getRef().hasMiddle()) {
            add(registry, part, either.getRef().getMiddle(), context);
        } else {
            add(registry, part, either.getRef().getRight(), context);
        }
    }

    @Override
    public void addTypes(String key, List<Schema.TYPE> types, JerialContext context) {
        if (types == null || types.isEmpty()) return;
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

    private <T> void addCustom(JerializerRegistry registry, PathPart part, Ref<T> subObject, JerialContext context) throws JerializerException {
        if (subObject == null || subObject.isEmptyRef()) return;
        JerialContext newContext = context.push(part);
        Jerializer<T> jerializer = registry.getJerializer((Class<T>)subObject.getRef().getClass());
        jerializer.jerialize(registry, subObject.getRef(), newContext);
        context.builder.addThing(part, JThing.make(newContext.builder.buildObject()));
    }

    @Override
    public <T> void addMap(JerializerRegistry registry, PathPart part, Ref<Map<String, Ref<T>>> subObjectMap, JerialContext context) throws JerializerException {
        if (subObjectMap == null || subObjectMap.isEmptyRef() || subObjectMap.getRef().isEmpty()) return;
        JerialContext parentContext = context.push(part);
        for (Map.Entry<String, Ref<T>> entry : subObjectMap.getRef().entrySet()) {
            add(registry, PathPart.key(entry.getKey()), entry.getValue(), parentContext);
        }
        context.builder.addThing(part, JThing.make(parentContext.builder.buildObject()));
    }

    @Override
    public <T> void addSinglyList(JerializerRegistry registry, PathPart part, Ref<List<Ref<T>>> subObjectList, JerialContext context) throws JerializerException {
        if (subObjectList == null || subObjectList.isEmptyRef() || subObjectList.getRef().isEmpty()) return;
        if (subObjectList.getRef().size() == 1) {
            add(registry, part, subObjectList.getRef().get(0), context);
        } else {
            addList(registry, part, subObjectList, context);
        }
    }

    @Override
    public <T> void addList(JerializerRegistry registry, PathPart part, Ref<List<Ref<T>>> subObjectList, JerialContext context) throws JerializerException {
        if (subObjectList == null || subObjectList.isEmptyRef() || subObjectList.getRef().isEmpty()) return;
        final PathPart parentPart = PathPart.key("links");
        JerialContext parentContext = context.push(parentPart);
        int i = 0;
        for (Ref<T> subObject : subObjectList.getRef()) {
            final PathPart childPart = PathPart.index(i);
            add(registry, childPart, subObject, parentContext);
            i += 1;
        }
        JArray array = parentContext.builder.buildArray();
        context.builder.addThing(part, JThing.make(array));
    }
}
