package net.exathunk.jereal.genschema.interfaces;

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
import net.exathunk.jereal.genschema.interfaces.Interfaces;

public class InterfacesContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, InterfacesContainer> {

    @Override
    public InterfacesContainer prototype(Speclike spec) {
        return new InterfacesContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, InterfacesContainer domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeWritable("interfaces", new RefImpl(recurser.seeCustom(dsl, domain.getInterfacesRef(), Interfaces.class)));
        return objectDSL;
    }

}
