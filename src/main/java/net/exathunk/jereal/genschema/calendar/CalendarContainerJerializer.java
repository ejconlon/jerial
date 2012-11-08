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
import net.exathunk.jereal.genschema.calendar.Calendar;
import net.exathunk.jereal.genschema.geo.GeoContainer;

public class CalendarContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, CalendarContainer> {

    @Override
    public CalendarContainer prototype(Speclike spec) {
        return new CalendarContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, CalendarContainer domain) throws JerializerException {
        recurser.seeCustom(dsl, domain.getCalendarRef(), Calendar.class);
        return null;
    }

}
