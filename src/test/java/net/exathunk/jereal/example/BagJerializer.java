package net.exathunk.jereal.example;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Writable;
import net.exathunk.jereal.base.jerializers.*;

/**
 * charolastra 10/23/12 9:07 PM
 */
public class BagJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, Bag> {

    @Override
    public Writable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Bag bag) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeString("s", bag.s);
        objectDSL.seeLong("l", bag.l);
        objectDSL.seeDouble("d", bag.d);
        objectDSL.seeBoolean("b", bag.b);
        objectDSL.seeWritable("next", recurser.seeCustom(dsl, bag.next));
        return objectDSL;
    }
}
