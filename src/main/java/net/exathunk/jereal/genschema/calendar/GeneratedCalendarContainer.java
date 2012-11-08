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

public class GeneratedCalendarContainer implements GeneratedCalendarContainerLike, GeneratedCalendarContainerRefable {

    private final Ref<JThing> generatedCalendar;

    public GeneratedCalendarContainer() {
        generatedCalendar = new RefImpl<JThing>();
    }

    @Override
    public boolean hasGeneratedCalendar() {
        return !generatedCalendar.isEmptyRef();
    }
    @Override
    public JThing getGeneratedCalendar() {
        return generatedCalendar.getRef();
    }
    @Override
    public void setGeneratedCalendar(JThing value) {
        generatedCalendar.setRef(value);
    }
    @Override
    public Ref<JThing> getGeneratedCalendarRef() {
        return generatedCalendar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedCalendarContainer{ ");
        if (!generatedCalendar.isEmptyRef()) sb.append("generatedCalendar='").append(generatedCalendar).append("', ");
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
        result = 31 * result + generatedCalendar.hashCode();
        return result;
    }

}
