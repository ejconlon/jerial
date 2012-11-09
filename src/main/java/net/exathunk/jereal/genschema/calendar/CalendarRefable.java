package net.exathunk.jereal.genschema.calendar;

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
import net.exathunk.jereal.genschema.geo.*;

public interface CalendarRefable {

        Ref<String> getCategoryRef();

        Ref<String> getDescriptionRef();

        Ref<String> getDtendRef();

        Ref<String> getDtstartRef();

        Ref<String> getDurationRef();

        Ref<GeoContainer> getGeoRef();

        Ref<String> getLocationRef();

        Ref<String> getRdateRef();

        Ref<String> getRruleRef();

        Ref<String> getSummaryRef();

        Ref<String> getUrlRef();

}
