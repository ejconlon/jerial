package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;

import java.util.Iterator;
import java.util.Map;

/**
 * charolastra 10/31/12 2:18 PM
 */
public class JThingContext implements PushableContext<JThingContext, JThing> {
    private final JerialContext context;

    public JThingContext() {
        this(new JerialContext());
    }

    public JThingContext(JerialContext context) {
        this.context = context;
    }

    public JThing writeObject(RefMapGroup<JThingContext, JThing> group) {
        if (!RefMapGroup.WModel.OBJECT.equals(group.getModel())) {
            throw new IllegalArgumentException("Expected object model: "+group.getModel());
        }
        return writeInner(group);
    }

    public JThing writeArray(RefMapGroup<JThingContext, JThing> group) {
        if (!RefMapGroup.WModel.ARRAY.equals(group.getModel())) {
            throw new IllegalArgumentException("Expected array model: "+group.getModel());
        }
        return writeInner(group);
    }

    @Override
    public JThing writeString(Ref<String> value) {
        return JThing.make(value.getRef());
    }

    @Override
    public JThing writeBoolean(Ref<Boolean> value) {
        return JThing.make(value.getRef());
    }

    @Override
    public JThing writeLong(Ref<Long> value) {
        return JThing.make(value.getRef());
    }

    @Override
    public JThing writeDouble(Ref<Double> value) {
        return JThing.make(value.getRef());
    }

    private JThing writeInner(RefMapGroup<JThingContext, JThing> group) {
        Iterator<Map.Entry<PathPart, Ref<ObjectDSL<JThingContext, JThing>>>> objectIt = group.objectIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<ArrayDSL<JThingContext, JThing>>>> arrayIt = group.arrayIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<String>>> stringIt = group.stringIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<Boolean>>> booleanIt = group.booleanIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<Long>>> longIt = group.longIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<Double>>> doubleIt = group.doubleIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<Writable<JThing>>>> writableIt = group.writableIterable().iterator();

        for (RefMapGroup.WModel model : group.orderIterable()) {
            switch (model) {
                case OBJECT:
                {
                    if (!objectIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<ObjectDSL<JThingContext, JThing>>> entry = objectIt.next();
                    if (entry.getValue().isEmptyRef()) break;
                    JThing walked = entry.getValue().getRef().write();
                    context.builder.addThing(entry.getKey(), walked);
                    break;
                }
                case ARRAY:
                {
                    if (!arrayIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<ArrayDSL<JThingContext, JThing>>> entry = arrayIt.next();
                    if (entry.getValue().isEmptyRef()) break;
                    JThing walked = entry.getValue().getRef().write();
                    context.builder.addThing(entry.getKey(), walked);
                    break;
                }
                case STRING:
                {
                    if (!stringIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<String>> entry = stringIt.next();
                    if (entry.getValue().isEmptyRef()) break;
                    context.builder.addThing(entry.getKey(), JThing.make(entry.getValue().getRef()));
                    break;
                }
                case BOOLEAN:
                {
                    if (!booleanIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<Boolean>> entry = booleanIt.next();
                    if (entry.getValue().isEmptyRef()) break;
                    context.builder.addThing(entry.getKey(), JThing.make(entry.getValue().getRef()));
                    break;
                }
                case LONG:
                {
                    if (!longIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<Long>> entry = longIt.next();
                    if (entry.getValue().isEmptyRef()) break;
                    context.builder.addThing(entry.getKey(), JThing.make(entry.getValue().getRef()));
                    break;
                }
                case DOUBLE:
                {
                    if (!doubleIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<Double>> entry = doubleIt.next();
                    if (entry.getValue().isEmptyRef()) break;
                    context.builder.addThing(entry.getKey(), JThing.make(entry.getValue().getRef()));
                    break;
                }
                case WRITABLE:
                {
                    if (!writableIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<Writable<JThing>>> entry = writableIt.next();
                    if (entry.getValue().isEmptyRef()) break;
                    Writable<JThing> writable = entry.getValue().getRef();
                    JThing walked = writable.write();
                    context.builder.addThing(entry.getKey(), walked);
                    break;
                }
                default:
                    throw new IllegalStateException("UNCOVERED CASE!");
            }
        }

        if (RefMapGroup.WModel.OBJECT.equals(group.getModel())) {
            return JThing.make(context.builder.buildObject());
        } else if (RefMapGroup.WModel.ARRAY.equals(group.getModel())) {
            return JThing.make(context.builder.buildArray());
        } else {
            throw new IllegalArgumentException("Invalid model: "+group.getModel());
        }
    }

    @Override
    public JThingContext push(PathPart part) {
        return new JThingContext(context.push(part));
    }

}
