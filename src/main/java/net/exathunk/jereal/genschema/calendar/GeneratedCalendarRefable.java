package net.exathunk.jereal.genschema.calendar;

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

public interface GeneratedCalendarRefable {

        Ref<String> getCategoryRef();

        Ref<String> getDescriptionRef();

        Ref<String> getDtendRef();

        Ref<String> getDtstartRef();

        Ref<String> getDurationRef();

        Ref<GeneratedGeoContainer> getGeoRef();

        Ref<String> getLocationRef();

        Ref<String> getRdateRef();

        Ref<String> getRruleRef();

        Ref<String> getSummaryRef();

        Ref<String> getUrlRef();

}
