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
public class BagJerializer implements Jerializer<Bag> {

    @Override
    public void jerialize(JDSL jdsl, Bag bag) throws JerializerException {
        jdsl.addString("s", bag.s);
        jdsl.addLong("l", bag.l);
        jdsl.addDouble("d", bag.d);
        jdsl.addBoolean("b", bag.b);
        jdsl.add(PathPart.key("next"), bag.next);
    }
}
