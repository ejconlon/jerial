package net.exathunk.jereal.genschema.links;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchema;
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchemaContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedLinksJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedLinks> {

    @Override
    public GeneratedLinks prototype(Speclike spec) {
        return new GeneratedLinks();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedLinks domain) throws JerializerException {
        // dsl.addSomething(domain.getEnctypeRef());
        // dsl.addSomething(domain.getHrefRef());
        // dsl.addSomething(domain.getMethodRef());
        // dsl.addSomething(domain.getPropertiesRef());
        // dsl.addSomething(domain.getRelRef());
        // dsl.addSomething(domain.getTargetSchemaRef());
        return null;
    }

}
