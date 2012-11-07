package net.exathunk.jereal.genschema.calendar;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.geo.GeneratedGeoContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public interface GeneratedCalendarLike {

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
        GeneratedGeoContainer getGeo();
        void setGeo(GeneratedGeoContainer value);

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
