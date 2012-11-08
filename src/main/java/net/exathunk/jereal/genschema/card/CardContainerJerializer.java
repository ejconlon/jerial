package net.exathunk.jereal.genschema.card;

import java.lang.String;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.address.AddressContainer;
import net.exathunk.jereal.genschema.card.Card;
import net.exathunk.jereal.genschema.geo.GeoContainer;

public class CardContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, CardContainer> {

    @Override
    public CardContainer prototype(Speclike spec) {
        return new CardContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, CardContainer domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeWritable("card", new RefImpl(recurser.seeCustom(dsl, domain.getCardRef(), Card.class)));
        return objectDSL;
    }

}
