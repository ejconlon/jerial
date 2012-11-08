package net.exathunk.jereal.genschema.jsonref;

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
import net.exathunk.jereal.genschema.jsonref.JsonRef;

public class JsonRefContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, JsonRefContainer> {

    @Override
    public JsonRefContainer prototype(Speclike spec) {
        return new JsonRefContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, JsonRefContainer domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeWritable("jsonRef", new RefImpl(recurser.seeCustom(dsl, domain.getJsonRefRef(), JsonRef.class)));
        return objectDSL;
    }

}
