package net.exathunk.jereal.example;

import net.exathunk.jereal.base.JerialContext;
import net.exathunk.jereal.base.Jerializer;
import net.exathunk.jereal.base.visitors.PathPart;
import net.exathunk.jereal.base.visitors.Jitem;

/**
 * charolastra 10/23/12 9:07 PM
 */
public class BagJerializer implements Jerializer<Bag> {

    @Override
    public void jerialize(Bag bag, JerialContext context) {
        context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("s"), bag.s));
        context.builder.addJitem(Jitem.makeLong(PathPart.makeLeft("l"), bag.l));
        context.builder.addJitem(Jitem.makeDouble(PathPart.makeLeft("d"), bag.d));
        context.builder.addJitem(Jitem.makeBoolean(PathPart.makeLeft("b"), bag.b));
        if (bag.next != null) {
            JerialContext nextContext = context.push(PathPart.makeLeft("next"));
            jerialize(bag.next, nextContext);
            context.builder.addJitem(Jitem.makeObject(PathPart.makeLeft("next"), nextContext.builder.buildJerial()));
        }
    }
}
