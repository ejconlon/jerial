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

public class GeoJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Geo> {

    @Override
    public Geo prototype(Speclike spec) {
        return new Geo();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Geo domain) throws JerializerException {
        dsl.seeDouble(domain.getLatitudeRef());
        dsl.seeDouble(domain.getLongitudeRef());
        return null;
    }

}
