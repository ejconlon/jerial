package net.exathunk.jereal.genschema.calendar;

import java.lang.String;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.geo.GeneratedGeoContainer;

public class GeneratedCalendarJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedCalendar> {

    @Override
    public GeneratedCalendar prototype(Speclike spec) {
        return new GeneratedCalendar();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedCalendar domain) throws JerializerException {
        dsl.seeString(domain.getCategoryRef());
        dsl.seeString(domain.getDescriptionRef());
        dsl.seeString(domain.getDtendRef());
        dsl.seeString(domain.getDtstartRef());
        dsl.seeString(domain.getDurationRef());
        recurser.seeCustom(dsl, domain.getGeoRef(), GeneratedGeoContainer.class);
        dsl.seeString(domain.getLocationRef());
        dsl.seeString(domain.getRdateRef());
        dsl.seeString(domain.getRruleRef());
        dsl.seeString(domain.getSummaryRef());
        dsl.seeString(domain.getUrlRef());
        return null;
    }

}
