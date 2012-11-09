package net.exathunk.jereal.genschema.card;

import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.*;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.address.*;
import net.exathunk.jereal.genschema.card.*;
import net.exathunk.jereal.genschema.geo.*;

public class CardContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, CardContainer> {

    @Override
    public CardContainer prototype(Speclike spec) throws JerializerException {
        return new CardContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, CardContainer domain) throws JerializerException {
        return (new CardJerializer()).jerialize(recurser, dsl, domain.getCardRef().getRef());
    }

}
