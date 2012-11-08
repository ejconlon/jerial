package net.exathunk.jereal.genschema.hyperschemaoruri;

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
import net.exathunk.jereal.genschema.hyperschema.HyperSchemaContainer;

public class HyperSchemaOrUriContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, HyperSchemaOrUriContainer> {

    @Override
    public HyperSchemaOrUriContainer prototype(Speclike spec) {
        return new HyperSchemaOrUriContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, HyperSchemaOrUriContainer domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeString("hyperSchemaOrUri", domain.getHyperSchemaOrUriRef().getFirstRef());
        objectDSL.seeWritable("hyperSchemaOrUri", new RefImpl(recurser.seeCustom(dsl, domain.getHyperSchemaOrUriRef().getSecondRef(), HyperSchemaContainer.class)));
        return objectDSL;
    }

}