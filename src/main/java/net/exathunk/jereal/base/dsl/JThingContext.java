package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

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

    public void writeObject(RefMapGroup<JThingContext, JThing> group, Ref<JThing> ref) {
        if (!RefMapGroup.WModel.OBJECT.equals(group.getModel())) {
            throw new IllegalArgumentException("Expected object model: "+group.getModel());
        }
        writeInner(group, ref);
    }

    public void writeArray(RefMapGroup<JThingContext, JThing> group, Ref<JThing> ref) {
        if (!RefMapGroup.WModel.ARRAY.equals(group.getModel())) {
            throw new IllegalArgumentException("Expected array model: "+group.getModel());
        }
        writeInner(group, ref);
    }

    @Override
    public void writeString(Ref<String> value, Ref<JThing> ref) {
        ref.setRef(JThing.make(value.getRef()));
    }

    @Override
    public void writeBoolean(Ref<Boolean> value, Ref<JThing> ref) {
        ref.setRef(JThing.make(value.getRef()));
    }

    @Override
    public void writeLong(Ref<Long> value, Ref<JThing> ref) {
        ref.setRef(JThing.make(value.getRef()));
    }

    @Override
    public void writeDouble(Ref<Double> value, Ref<JThing> ref) {
        ref.setRef(JThing.make(value.getRef()));
    }

    private void writeInner(RefMapGroup<JThingContext, JThing> group, Ref<JThing> ret) {
        Iterator<Map.Entry<PathPart, Ref<ObjectDSL<JThingContext, JThing>>>> objectIt = group.getObjects().iterator();
        Iterator<Map.Entry<PathPart, Ref<ArrayDSL<JThingContext, JThing>>>> arrayIt = group.getArrays().iterator();
        Iterator<Map.Entry<PathPart, Ref<String>>> stringIt = group.getStrings().iterator();
        Iterator<Map.Entry<PathPart, Ref<Boolean>>> booleanIt = group.getBooleans().iterator();
        Iterator<Map.Entry<PathPart, Ref<Long>>> longIt = group.getLongs().iterator();
        Iterator<Map.Entry<PathPart, Ref<Double>>> doubleIt = group.getDoubles().iterator();
        Iterator<Map.Entry<PathPart, Ref<Writable<JThing>>>> writableIt = group.getWritables().iterator();

        for (RefMapGroup.WModel model : group.getOrders()) {
            switch (model) {
                case OBJECT:
                {
                    if (!objectIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<ObjectDSL<JThingContext, JThing>>> entry = objectIt.next();
                    if (entry.getValue().isEmptyRef()) break;
                    Ref<JThing> ref = new RefImpl<JThing>();
                    entry.getValue().getRef().writeTo(ref);
                    context.builder.addThing(entry.getKey(), ref.getRef());
                    break;
                }
                case ARRAY:
                {
                    if (!arrayIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<ArrayDSL<JThingContext, JThing>>> entry = arrayIt.next();
                    if (entry.getValue().isEmptyRef()) break;
                    Ref<JThing> ref = new RefImpl<JThing>();
                    entry.getValue().getRef().writeTo(ref);
                    context.builder.addThing(entry.getKey(), ref.getRef());
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
                    Ref<JThing> ref = new RefImpl<JThing>();
                    entry.getValue().getRef().writeTo(ref);
                    context.builder.addThing(entry.getKey(), ref.getRef());
                    break;
                }
                default:
                    throw new IllegalStateException("UNCOVERED CASE!");
            }
        }

        if (RefMapGroup.WModel.OBJECT.equals(group.getModel())) {
            ret.setRef(JThing.make(context.builder.buildObject()));
        } else if (RefMapGroup.WModel.ARRAY.equals(group.getModel())) {
            ret.setRef(JThing.make(context.builder.buildArray()));
        } else {
            throw new IllegalArgumentException("Invalid model: "+group.getModel());
        }
    }

    @Override
    public JThingContext push(PathPart part) {
        return new JThingContext(context.push(part));
    }

}
