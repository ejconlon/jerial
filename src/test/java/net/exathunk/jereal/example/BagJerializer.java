package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.base.core.PathPart;

/**
 * charolastra 10/23/12 9:07 PM
 */
public class BagJerializer<C> implements Jerializer<Bag, C> {

    @Override
    public void jerialize(JDSL<C> jdsl, JerializerRegistry<C> registry, Bag bag, C context) throws JerializerException {
        jdsl.addString("s", bag.s, context);
        jdsl.addLong("l", bag.l, context);
        jdsl.addDouble("d", bag.d, context);
        jdsl.addBoolean("b", bag.b, context);
        jdsl.add(new SinglyRegistry<Bag, C>(Bag.class, this, registry), PathPart.key("next"), bag.next, context);
    }
}
