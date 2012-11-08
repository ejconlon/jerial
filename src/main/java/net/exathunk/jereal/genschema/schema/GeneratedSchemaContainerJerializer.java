package net.exathunk.jereal.genschema.schema;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.Long;
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
import net.exathunk.jereal.genschema.schema.GeneratedSchema;
import net.exathunk.jereal.genschema.schema.GeneratedSchemaContainer;

public class GeneratedSchemaContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedSchemaContainer> {

    @Override
    public GeneratedSchemaContainer prototype(Speclike spec) {
        return new GeneratedSchemaContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedSchemaContainer domain) throws JerializerException {
        // dsl.addSomething(domain.getGeneratedSchemaRef());
        return null;
    }

}
