package net.exathunk.jereal.example;

import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.jerializers.*;

/**
 * charolastra 10/23/12 9:07 PM
 */
public class BagJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, Bag> {

    @Override
    public void jerialize(Recurser<T, U> recurser, ObjectDSL<T, U> dsl, Bag bag) throws JerializerException {
        dsl.seeString("s", bag.s);
        dsl.seeLong("l", bag.l);
        dsl.seeDouble("d", bag.d);
        dsl.seeBoolean("b", bag.b);
        recurser.seeCustom(dsl, "next", bag.next);
    }
}
