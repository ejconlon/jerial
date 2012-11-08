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

public class GeneratedCalendarJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedCalendar> {

    @Override
    public GeneratedCalendar prototype(Speclike spec) {
        return new GeneratedCalendar();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedCalendar domain) throws JerializerException {
        // dsl.addSomething(domain.getCategoryRef());
        // dsl.addSomething(domain.getDescriptionRef());
        // dsl.addSomething(domain.getDtendRef());
        // dsl.addSomething(domain.getDtstartRef());
        // dsl.addSomething(domain.getDurationRef());
        // dsl.addSomething(domain.getGeoRef());
        // dsl.addSomething(domain.getLocationRef());
        // dsl.addSomething(domain.getRdateRef());
        // dsl.addSomething(domain.getRruleRef());
        // dsl.addSomething(domain.getSummaryRef());
        // dsl.addSomething(domain.getUrlRef());
        return null;
    }

}
