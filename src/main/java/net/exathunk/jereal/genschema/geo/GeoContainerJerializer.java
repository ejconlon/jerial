package net.exathunk.jereal.genschema.geo;

import java.lang.Double;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.geo.Geo;

public class GeoContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeoContainer> {

    @Override
    public GeoContainer prototype(Speclike spec) {
        return new GeoContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeoContainer domain) throws JerializerException {
        recurser.seeCustom(dsl, domain.getGeoRef(), Geo.class);
        return null;
    }

}
