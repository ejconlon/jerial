package net.exathunk.jereal.genschema.hyperschemaoruri;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschemaoruri.GeneratedHyperSchemaOrUri;

public class GeneratedHyperSchemaOrUriContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedHyperSchemaOrUriContainer> {

    @Override
    public GeneratedHyperSchemaOrUriContainer prototype(Speclike spec) {
        return new GeneratedHyperSchemaOrUriContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedHyperSchemaOrUriContainer domain) throws JerializerException {
        // dsl.addSomething(domain.getGeneratedHyperSchemaOrUriRef());
        return null;
    }

}
