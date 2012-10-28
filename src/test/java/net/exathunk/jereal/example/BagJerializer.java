package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.visitors.PathPart;
import net.exathunk.jereal.base.visitors.Jitem;

/**
 * charolastra 10/23/12 9:07 PM
 */
public class BagJerializer implements Jerializer<Bag> {

    @Override
    public void jerialize(JerializerRegistry registry, Bag bag, JerialContext context) {
        context.builder.addJitem(Jitem.makeString(PathPart.key("s"), bag.s));
        context.builder.addJitem(Jitem.makeLong(PathPart.key("l"), bag.l));
        context.builder.addJitem(Jitem.makeDouble(PathPart.key("d"), bag.d));
        context.builder.addJitem(Jitem.makeBoolean(PathPart.key("b"), bag.b));
        if (bag.next != null) {
            JerialContext nextContext = context.push(PathPart.key("next"));
            jerialize(registry, bag.next, nextContext);
            context.builder.addJitem(Jitem.makeObject(PathPart.key("next"), nextContext.builder.buildObject()));
        }
    }
}
