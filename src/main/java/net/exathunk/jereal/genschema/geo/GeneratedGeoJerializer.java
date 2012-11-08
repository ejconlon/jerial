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
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedGeoJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedGeo> {

    @Override
    public GeneratedGeo prototype(Speclike spec) {
        return new GeneratedGeo();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedGeo domain) throws JerializerException {
        // dsl.addSomething(domain.getLatitudeRef());
        // dsl.addSomething(domain.getLongitudeRef());
        return null;
    }

}
