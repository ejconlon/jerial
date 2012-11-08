package net.exathunk.jereal.genschema.calendar;

import java.lang.String;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.geo.GeoContainer;

public interface CalendarLike {

        boolean hasCategory();
        String getCategory();
        void setCategory(String value);

        boolean hasDescription();
        String getDescription();
        void setDescription(String value);

        boolean hasDtend();
        String getDtend();
        void setDtend(String value);

        boolean hasDtstart();
        String getDtstart();
        void setDtstart(String value);

        boolean hasDuration();
        String getDuration();
        void setDuration(String value);

        boolean hasGeo();
        GeoContainer getGeo();
        void setGeo(GeoContainer value);

        boolean hasLocation();
        String getLocation();
        void setLocation(String value);

        boolean hasRdate();
        String getRdate();
        void setRdate(String value);

        boolean hasRrule();
        String getRrule();
        void setRrule(String value);

        boolean hasSummary();
        String getSummary();
        void setSummary(String value);

        boolean hasUrl();
        String getUrl();
        void setUrl(String value);

}
