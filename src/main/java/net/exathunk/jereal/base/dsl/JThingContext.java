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

    public JThingContext(JerialContext context) {
        this.context = context;
    }

    @Override
    public JThing runResFunc(RefMapGroup<JThingContext, JThing> group) {
        Iterator<Map.Entry<PathPart, Ref<ObjectDSL<JThingContext, JThing>>>> objectIt = group.objectIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<ArrayDSL<JThingContext, JThing>>>> arrayIt = group.arrayIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<String>>> stringIt = group.stringIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<Boolean>>> booleanIt = group.booleanIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<Long>>> longIt = group.longIterable().iterator();
        Iterator<Map.Entry<PathPart, Ref<Double>>> doubleIt = group.doubleIterable().iterator();

        for (Model model : group.orderIterable()) {
            switch (model) {
                case OBJECT:
                {
                    if (!objectIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<ObjectDSL<JThingContext, JThing>>> entry = objectIt.next();
                    JThing walked = entry.getValue().getRef().seeObjectEnd();
                    context.builder.addThing(entry.getKey(), walked);
                    break;
                }
                case ARRAY:
                {
                    if (!arrayIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<ArrayDSL<JThingContext, JThing>>> entry = arrayIt.next();
                    JThing walked = entry.getValue().getRef().seeArrayEnd();
                    context.builder.addThing(entry.getKey(), walked);
                    break;
                }
                case STRING:
                {
                    if (!stringIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<String>> entry = stringIt.next();
                    context.builder.addThing(entry.getKey(), JThing.make(entry.getValue().getRef()));
                    break;
                }
                case BOOLEAN:
                {
                    if (!booleanIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<Boolean>> entry = booleanIt.next();
                    context.builder.addThing(entry.getKey(), JThing.make(entry.getValue().getRef()));
                    break;
                }
                case LONG:
                {
                    if (!longIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<Long>> entry = longIt.next();
                    context.builder.addThing(entry.getKey(), JThing.make(entry.getValue().getRef()));
                    break;
                }
                case DOUBLE:
                {
                    if (!doubleIt.hasNext()) continue;
                    Map.Entry<PathPart, Ref<Double>> entry = doubleIt.next();
                    context.builder.addThing(entry.getKey(), JThing.make(entry.getValue().getRef()));
                    break;
                }
            }
        }

        if (Model.OBJECT.equals(group.getModel())) {
            return JThing.make(context.builder.buildObject());
        } else if (Model.ARRAY.equals(group.getModel())) {
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
