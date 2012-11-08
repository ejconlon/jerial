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
import net.exathunk.jereal.genschema.hyperschema.HyperSchemaContainer;

public class LinksJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Links> {

    @Override
    public Links prototype(Speclike spec) {
        return new Links();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Links domain) throws JerializerException {
        dsl.seeString(domain.getEnctypeRef());
        dsl.seeString(domain.getHrefRef());
        dsl.seeString(domain.getMethodRef());
        recurser.seeCustom(dsl, domain.getPropertiesRef(), HyperSchemaContainer.class);
        dsl.seeString(domain.getRelRef());
        recurser.seeCustom(dsl, domain.getTargetSchemaRef(), HyperSchemaContainer.class);
        return null;
    }

}
