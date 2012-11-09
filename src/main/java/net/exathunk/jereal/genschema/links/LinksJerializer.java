package net.exathunk.jereal.genschema.links;

import java.lang.*;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschema.*;

public class LinksJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Links> {

    @Override
    public Links prototype(Speclike spec) {
        return new Links();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Links domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeString("enctype", domain.getEnctypeRef());
        objectDSL.seeString("href", domain.getHrefRef());
        objectDSL.seeString("method", domain.getMethodRef());
        objectDSL.seeWritable("properties", new RefImpl(recurser.seeCustom(dsl, domain.getPropertiesRef(), HyperSchemaContainer.class)));
        objectDSL.seeString("rel", domain.getRelRef());
        objectDSL.seeWritable("targetSchema", new RefImpl(recurser.seeCustom(dsl, domain.getTargetSchemaRef(), HyperSchemaContainer.class)));
        return objectDSL;
    }

}
