package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.JDSL;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.core.PathPart;

/**
 * charolastra 10/23/12 9:07 PM
 */
public class BagJerializer implements Jerializer<Bag, JerialContext> {

    @Override
    public void jerialize(JDSL<JerialContext> jdsl, JerializerRegistry<JerialContext> registry, Bag bag, JerialContext context) {
        jdsl.addThing(PathPart.key("s"), new RefImpl<JThing>(JThing.make(bag.s)), context);
        jdsl.addThing(PathPart.key("l"), new RefImpl<JThing>(JThing.make(bag.l)), context);
        jdsl.addThing(PathPart.key("d"), new RefImpl<JThing>(JThing.make(bag.d)), context);
        jdsl.addThing(PathPart.key("b"), new RefImpl<JThing>(JThing.make(bag.b)), context);
        if (bag.next != null) {
            JerialContext nextContext = context.push(PathPart.key("next"));
            jerialize(jdsl, registry, bag.next, nextContext);
            context.builder.addThing(PathPart.key("next"), JThing.make(nextContext.builder.buildObject()));
        }
    }
}
