package net.exathunk.jereal.genschema.calendar;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.calendar.GeneratedCalendar;
import net.exathunk.jereal.genschema.calendar.GeneratedCalendarContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedCalendarContainer implements GeneratedCalendarContainerLike, GeneratedCalendarContainerRefable {

    private final Ref<GeneratedCalendar> GeneratedCalendar;

    public GeneratedCalendarContainer() {
        GeneratedCalendar = new RefImpl<GeneratedCalendar>();
    }

    @Override
    public boolean hasGeneratedCalendar() {
        return !GeneratedCalendar.isEmptyRef();
    }
    @Override
    public GeneratedCalendar getGeneratedCalendar() {
        return GeneratedCalendar.getRef();
    }
    @Override
    public void setGeneratedCalendar(GeneratedCalendar value) {
        GeneratedCalendar.setRef(value);
    }
    @Override
    public Ref<GeneratedCalendar> getGeneratedCalendarRef() {
        return GeneratedCalendar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedCalendarContainer{ ");
        if (!GeneratedCalendar.isEmptyRef()) sb.append("GeneratedCalendar='").append(GeneratedCalendar).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedCalendarContainerLike) {
            GeneratedCalendarContainerLike other = (GeneratedCalendarContainerLike) o;
            if (hasGeneratedCalendar()) {
                if (!other.hasGeneratedCalendar()) return false;
                else if (!getGeneratedCalendar().equals(other.getGeneratedCalendar())) return false;
            } else if (other.hasGeneratedCalendar()) return false;
            return true;
        } else if (o instanceof GeneratedCalendarContainerRefable) {
            GeneratedCalendarContainerRefable other = (GeneratedCalendarContainerRefable) o;
            if (!getGeneratedCalendarRef().equals(other.getGeneratedCalendarRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + GeneratedCalendar.hashCode();
        return result;
    }

}
