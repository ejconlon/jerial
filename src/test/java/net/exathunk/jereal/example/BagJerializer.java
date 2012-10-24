package net.exathunk.jereal.example;

import net.exathunk.jereal.base.JerialContext;
import net.exathunk.jereal.base.Jerializer;
import net.exathunk.jereal.base.Jitem;

/**
 * charolastra 10/23/12 9:07 PM
 */
public class BagJerializer implements Jerializer<Bag> {

    @Override
    public void jerialize(Bag bag, JerialContext context) {
        context.builder.addJitem(Jitem.makeString("s", bag.s));
        context.builder.addJitem(Jitem.makeLong("l", bag.l));
        context.builder.addJitem(Jitem.makeDouble("d", bag.d));
        context.builder.addJitem(Jitem.makeBoolean("b", bag.b));
        if (bag.next != null) {
            JerialContext nextContext = context.push("next");
            jerialize(bag.next, nextContext);
            context.builder.addJitem(Jitem.makeObject("next", nextContext.builder.buildJerial()));
        }
    }
}
