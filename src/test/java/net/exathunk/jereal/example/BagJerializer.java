package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.visitors.PathPart;

/**
 * charolastra 10/23/12 9:07 PM
 */
public class BagJerializer implements Jerializer<Bag> {

    @Override
    public void jerialize(JerializerRegistry registry, Bag bag, JerialContext context) {
        context.builder.addThing(PathPart.key("s"), JThing.make(bag.s));
        context.builder.addThing(PathPart.key("l"), JThing.make(bag.l));
        context.builder.addThing(PathPart.key("d"), JThing.make(bag.d));
        context.builder.addThing(PathPart.key("b"), JThing.make(bag.b));
        if (bag.next != null) {
            JerialContext nextContext = context.push(PathPart.key("next"));
            jerialize(registry, bag.next, nextContext);
            context.builder.addThing(PathPart.key("next"), JThing.make(nextContext.builder.buildObject()));
        }
    }
}
