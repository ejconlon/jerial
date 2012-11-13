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

public class CalendarJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Calendar> {

    @Override
    public Calendar prototype(Speclike spec) {
        return new Calendar();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Calendar domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeString("category", domain.getCategoryRef());
        objectDSL.seeString("description", domain.getDescriptionRef());
        objectDSL.seeString("dtend", domain.getDtendRef());
        objectDSL.seeString("dtstart", domain.getDtstartRef());
        objectDSL.seeString("duration", domain.getDurationRef());
        objectDSL.seeCustom("geo", new RefImpl(recurser.seeCustom(dsl, domain.getGeoRef(), GeoContainer.class)));
        objectDSL.seeString("location", domain.getLocationRef());
        objectDSL.seeString("rdate", domain.getRdateRef());
        objectDSL.seeString("rrule", domain.getRruleRef());
        objectDSL.seeString("summary", domain.getSummaryRef());
        objectDSL.seeString("url", domain.getUrlRef());
        return objectDSL;
    }

}
