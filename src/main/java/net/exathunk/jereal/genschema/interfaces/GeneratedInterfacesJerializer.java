package net.exathunk.jereal.genschema.interfaces;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;

public class GeneratedInterfacesJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedInterfaces> {

    @Override
    public GeneratedInterfaces prototype(Speclike spec) {
        return new GeneratedInterfaces();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedInterfaces domain) throws JerializerException {
        recurser.seeThing(dsl, domain.getMethodsRef());
        return null;
    }

}
