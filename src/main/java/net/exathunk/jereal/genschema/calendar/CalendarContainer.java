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

public class CalendarContainer implements CalendarContainerLike, CalendarContainerRefable {

    private final Ref<Calendar> calendar;

    public CalendarContainer() {
        calendar = new RefImpl<Calendar>();
    }

    @Override
    public boolean hasCalendar() {
        return !calendar.isEmptyRef();
    }
    @Override
    public Calendar getCalendar() {
        return calendar.getRef();
    }
    @Override
    public void setCalendar(Calendar value) {
        calendar.setRef(value);
    }
    @Override
    public Ref<Calendar> getCalendarRef() {
        return calendar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CalendarContainer{ ");
        if (!calendar.isEmptyRef()) sb.append("calendar='").append(calendar).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof CalendarContainerLike) {
            CalendarContainerLike other = (CalendarContainerLike) o;
            if (hasCalendar()) {
                if (!other.hasCalendar()) return false;
                else if (!getCalendar().equals(other.getCalendar())) return false;
            } else if (other.hasCalendar()) return false;
            return true;
        } else if (o instanceof CalendarContainerRefable) {
            CalendarContainerRefable other = (CalendarContainerRefable) o;
            if (!getCalendarRef().equals(other.getCalendarRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + calendar.hashCode();
        return result;
    }

}
