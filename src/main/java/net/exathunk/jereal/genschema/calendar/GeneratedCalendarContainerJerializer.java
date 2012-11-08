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
import net.exathunk.jereal.genschema.calendar.GeneratedCalendar;
import net.exathunk.jereal.genschema.geo.GeneratedGeoContainer;

public class GeneratedCalendarContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedCalendarContainer> {

    @Override
    public GeneratedCalendarContainer prototype(Speclike spec) {
        return new GeneratedCalendarContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedCalendarContainer domain) throws JerializerException {
        // dsl.addSomething(domain.getGeneratedCalendarRef());
        return null;
    }

}
