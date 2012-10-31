package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.Either;
import net.exathunk.jereal.base.functional.Either3;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.schema.domain.Schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * charolastra 10/27/12 6:33 PM
 */
public class JDSLImpl implements JDSL {

    private final JerialContext context;
    private final JerializerRegistry registry;

    public JDSLImpl(JerialContext context, JerializerRegistry registry) {
        this.context = context;
        this.registry = registry;
    }

    private JDSLImpl pushContext(JerialContext newContext) {
        return new JDSLImpl(newContext, registry);
    }

    private <T> boolean addSimple(PathPart part, Ref<T> refValue) {
        if (refValue == null || refValue.isEmptyRef()) return false;
        final T value = refValue.getRef();
        if (1 == 1) {
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

    private boolean addSimple(String key, Ref<?> value) {
        return addSimple(PathPart.key(key), value);
    }

    @Override
    public void addThing(PathPart part, Ref<JThing> thing) {
        if (thing == null || thing.isEmptyRef()) return;
        context.builder.addThing(part, thing.getRef());
    }

    @Override
    public void addBoolean(String key, Ref<Boolean> value) {
        addSimple(key, value);
    }

    @Override
    public void addLong(String key, Ref<Long> value) {
        addSimple(key, value);
    }

    @Override
    public void addDouble(String key, Ref<Double> value) {
        addSimple(key, value);
    }

    @Override
    public void addString(String key, Ref<String> value) {
        addSimple(key, value);
    }

    private <T, A, B, C> boolean addStructural(JerializerRegistry registry, PathPart part, Ref<T> value) throws JerializerException {
        if (value == null || value.isEmptyRef()) return false;
        if (value.getRef() instanceof Either) {
            addEither(part, (Ref<Either<Ref<A>, Ref<B>>>)value);
        } else if (value.getRef() instanceof Either3) {
            addEither3(part, (Ref<Either3<Ref<A>, Ref<B>, Ref<C>>>) value);
        } else if (value.getRef() instanceof  JThing) {
            addThing(part, (Ref<JThing>)value);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public <T> void add(PathPart part, Ref<T> value) throws JerializerException {
        if (!addSimple(part, value)) {
            if (!addStructural(registry, part, value)) {
                addCustom(part, value);
            }
        }
    }

    private <A, B> void addEither(PathPart part, Ref<Either<Ref<A>, Ref<B>>> either) throws JerializerException {
        if (either == null || either.isEmptyRef()) return;
        if (either.getRef().hasLeft()) {
            add(part, either.getRef().getLeft());
        } else {
            add(part, either.getRef().getRight());
        }
    }

    private <A, B, C> void addEither3(PathPart part, Ref<Either3<Ref<A>, Ref<B>, Ref<C>>> either) throws JerializerException {
        if (either == null || either.isEmptyRef()) return;
        if (either.getRef().hasLeft()) {
            add(part, either.getRef().getLeft());
        } else if (either.getRef().hasMiddle()) {
            add(part, either.getRef().getMiddle());
        } else {
            add(part, either.getRef().getRight());
        }
    }

    @Override
    public void addTypes(String key, List<Schema.TYPE> types) {
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

    private <T> void addCustom(PathPart part, Ref<T> subObject) throws JerializerException {
        if (subObject == null || subObject.isEmptyRef()) return;
        JerialContext newContext = context.push(part);
        Jerializer<T> jerializer = (Jerializer<T>) registry.getJerializer(subObject.getRef().getClass());
        jerializer.jerialize(pushContext(newContext), subObject.getRef());
        context.builder.addThing(part, JThing.make(newContext.builder.buildObject()));
    }

    @Override
    public <T> void addMap(PathPart part, Ref<Map<String, T>> subObjectMap) throws JerializerException {
        if (subObjectMap == null || subObjectMap.isEmptyRef() || subObjectMap.getRef().isEmpty()) return;
        JerialContext parentContext = context.push(part);
        for (Map.Entry<String, T> entry : subObjectMap.getRef().entrySet()) {
            pushContext(parentContext).add(PathPart.key(entry.getKey()), new RefImpl<Object>(entry.getValue()));
        }
        context.builder.addThing(part, JThing.make(parentContext.builder.buildObject()));
    }

    @Override
    public <T> void addSinglyList(PathPart part, Ref<List<T>> subObjectList) throws JerializerException {
        if (subObjectList == null || subObjectList.isEmptyRef() || subObjectList.getRef().isEmpty()) return;
        if (subObjectList.getRef().size() == 1) {
            add(part, new RefImpl<Object>(subObjectList.getRef().get(0)));
        } else {
            addList(part, subObjectList);
        }
    }

    @Override
    public <T> void addList(PathPart part, Ref<List<T>> subObjectList) throws JerializerException {
        if (subObjectList == null || subObjectList.isEmptyRef() || subObjectList.getRef().isEmpty()) return;
        final PathPart parentPart = PathPart.key("links");
        JerialContext parentContext = context.push(parentPart);
        int i = 0;
        for (T subObject : subObjectList.getRef()) {
            final PathPart childPart = PathPart.index(i);
            pushContext(parentContext).add(childPart, new RefImpl<Object>(subObject));
            i += 1;
        }
        JArray array = parentContext.builder.buildArray();
        context.builder.addThing(part, JThing.make(array));
    }
}
