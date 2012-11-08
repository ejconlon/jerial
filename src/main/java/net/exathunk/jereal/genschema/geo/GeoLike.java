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

public interface GeoLike {

        boolean hasLatitude();
        Double getLatitude();
        void setLatitude(Double value);

        boolean hasLongitude();
        Double getLongitude();
        void setLongitude(Double value);

}
