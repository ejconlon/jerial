package net.exathunk.jereal.genschema.geo;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.geo.GeneratedGeo;
import net.exathunk.jereal.genschema.geo.GeneratedGeoContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedGeoContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedGeoContainer> {

    @Override
    public GeneratedGeoContainer prototype(Speclike spec) {
        return new GeneratedGeoContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedGeoContainer domain) throws JerializerException {
        // dsl.addSomething(domain.getGeneratedGeoRef());
        return null;
    }

}
