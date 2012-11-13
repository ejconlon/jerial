package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.jerializers.JerializerException;

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

    @Override
    public void writeObject(RefMapGroup<JThingContext, JThing> group, Ref<JThing> ref) throws JerializerException {
        if (!RefMapGroup.WModel.OBJECT.equals(group.getModel())) {
            throw new IllegalArgumentException("Expected object model: "+group.getModel());
        }
        writeInner(group, ref);
    }

    @Override
    public void writeArray(RefMapGroup<JThingContext, JThing> group, Ref<JThing> ref) throws JerializerException {
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

    private void writeInner(RefMapGroup<JThingContext, JThing> group, Ref<JThing> retRef) throws JerializerException {
        for (Map.Entry<PathPart, RefMapGroup.WModel> order : group.getOrders()) {
            switch (order.getValue()) {
                case OBJECT:
                {
                    Ref<ObjectDSL<JThingContext, JThing>> objectDSL = group.getObjects().get(order.getKey());
                    if (objectDSL.isEmptyRef()) break;
                    Ref<JThing> ref = new RefImpl<JThing>();
                    objectDSL.getRef().pipe(ref);
                    context.builder.addThing(order.getKey(), ref.getRef());
                    break;
                }
                case ARRAY:
                {
                    Ref<ArrayDSL<JThingContext, JThing>> arrayDSL = group.getArrays().get(order.getKey());
                    if (arrayDSL.isEmptyRef()) break;
                    Ref<JThing> ref = new RefImpl<JThing>();
                    arrayDSL.getRef().pipe(ref);
                    context.builder.addThing(order.getKey(), ref.getRef());
                    break;
                }
                case STRING:
                {
                    Ref<String> value = group.getStrings().get(order.getKey());
                    if (value.isEmptyRef()) break;
                    context.builder.addThing(order.getKey(), JThing.make(value.getRef()));
                    break;
                }
                case BOOLEAN:
                {
                    Ref<Boolean> value = group.getBooleans().get(order.getKey());
                    if (value.isEmptyRef()) break;
                    context.builder.addThing(order.getKey(), JThing.make(value.getRef()));
                    break;
                }
                case LONG:
                {
                    Ref<Long> value = group.getLongs().get(order.getKey());
                    if (value.isEmptyRef()) break;
                    context.builder.addThing(order.getKey(), JThing.make(value.getRef()));
                    break;
                }
                case DOUBLE:
                {
                    Ref<Double> value = group.getDoubles().get(order.getKey());
                    if (value.isEmptyRef()) break;
                    context.builder.addThing(order.getKey(), JThing.make(value.getRef()));
                    break;
                }
                case CUSTOM:
                case LIST:
                {
                    final Ref<Pipeable<JThing>> writable;
                    if ( RefMapGroup.WModel.CUSTOM.equals(order.getValue())) {
                        writable = group.getCustoms().get(order.getKey());
                    } else {
                        writable = group.getLists().get(order.getKey());
                    }
                    if (writable.isEmptyRef()) break;
                    Ref<JThing> ref = new RefImpl<JThing>();
                    writable.getRef().pipe(ref);
                    if (!ref.isEmptyRef())
                        context.builder.addThing(order.getKey(), ref.getRef());
                    break;
                }
                default:
                    throw new IllegalStateException("UNCOVERED CASE!");
            }
        }

        if (RefMapGroup.WModel.OBJECT.equals(group.getModel())) {
            retRef.setRef(JThing.make(context.builder.buildObject()));
        } else if (RefMapGroup.WModel.ARRAY.equals(group.getModel())) {
            retRef.setRef(JThing.make(context.builder.buildArray()));
        } else {
            throw new IllegalArgumentException("Invalid model: "+group.getModel());
        }
    }

    @Override
    public JThingContext push(PathPart part) {
        return new JThingContext(context.push(part));
    }

}
