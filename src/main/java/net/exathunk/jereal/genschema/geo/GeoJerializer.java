package net.exathunk.jereal.genschema.geo;

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

public class GeoJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Geo> {

    @Override
    public Geo prototype(Speclike spec) {
        return new Geo();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Geo domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeDouble("latitude", domain.getLatitudeRef());
        objectDSL.seeDouble("longitude", domain.getLongitudeRef());
        return objectDSL;
    }

}
