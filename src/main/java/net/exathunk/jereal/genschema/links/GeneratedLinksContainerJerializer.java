package net.exathunk.jereal.genschema.links;

import java.lang.String;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchemaContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinks;

public class GeneratedLinksContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedLinksContainer> {

    @Override
    public GeneratedLinksContainer prototype(Speclike spec) {
        return new GeneratedLinksContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedLinksContainer domain) throws JerializerException {
        // dsl.addSomething(domain.getGeneratedLinksRef());
        return null;
    }

}
