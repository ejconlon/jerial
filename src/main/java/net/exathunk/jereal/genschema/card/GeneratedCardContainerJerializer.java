package net.exathunk.jereal.genschema.card;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.card.GeneratedCard;
import net.exathunk.jereal.genschema.card.GeneratedCardContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedCardContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedCardContainer> {

    @Override
    public GeneratedCardContainer prototype(Speclike spec) {
        return new GeneratedCardContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedCardContainer domain) throws JerializerException {
        // dsl.addSomething(domain.getGeneratedCardRef());
        return null;
    }

}
