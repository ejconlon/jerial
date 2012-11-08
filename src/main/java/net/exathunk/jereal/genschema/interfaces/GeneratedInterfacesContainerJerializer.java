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
import net.exathunk.jereal.genschema.interfaces.GeneratedInterfaces;
import net.exathunk.jereal.genschema.interfaces.GeneratedInterfacesContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedInterfacesContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedInterfacesContainer> {

    @Override
    public GeneratedInterfacesContainer prototype(Speclike spec) {
        return new GeneratedInterfacesContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedInterfacesContainer domain) throws JerializerException {
        // dsl.addSomething(domain.getGeneratedInterfacesRef());
        return null;
    }

}
