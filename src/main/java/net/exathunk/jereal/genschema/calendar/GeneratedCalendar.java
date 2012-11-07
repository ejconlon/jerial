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

public class GeneratedCalendar implements GeneratedCalendarLike, GeneratedCalendarRefable {

    private final Ref<String> category;
    private final Ref<String> description;
    private final Ref<String> dtend;
    private final Ref<String> dtstart;
    private final Ref<String> duration;
    private final Ref<GeneratedGeoContainer> geo;
    private final Ref<String> location;
    private final Ref<String> rdate;
    private final Ref<String> rrule;
    private final Ref<String> summary;
    private final Ref<String> url;

    public GeneratedCalendar() {
        category = new RefImpl<String>();
        description = new RefImpl<String>();
        dtend = new RefImpl<String>();
        dtstart = new RefImpl<String>();
        duration = new RefImpl<String>();
        geo = new RefImpl<GeneratedGeoContainer>();
        location = new RefImpl<String>();
        rdate = new RefImpl<String>();
        rrule = new RefImpl<String>();
        summary = new RefImpl<String>();
        url = new RefImpl<String>();
    }

    @Override
    public boolean hasCategory() {
        return !category.isEmptyRef();
    }
    @Override
    public String getCategory() {
        return category.getRef();
    }
    @Override
    public void setCategory(String value) {
        category.setRef(value);
    }
    @Override
    public Ref<String> getCategoryRef() {
        return category;
    }

    @Override
    public boolean hasDescription() {
        return !description.isEmptyRef();
    }
    @Override
    public String getDescription() {
        return description.getRef();
    }
    @Override
    public void setDescription(String value) {
        description.setRef(value);
    }
    @Override
    public Ref<String> getDescriptionRef() {
        return description;
    }

    @Override
    public boolean hasDtend() {
        return !dtend.isEmptyRef();
    }
    @Override
    public String getDtend() {
        return dtend.getRef();
    }
    @Override
    public void setDtend(String value) {
        dtend.setRef(value);
    }
    @Override
    public Ref<String> getDtendRef() {
        return dtend;
    }

    @Override
    public boolean hasDtstart() {
        return !dtstart.isEmptyRef();
    }
    @Override
    public String getDtstart() {
        return dtstart.getRef();
    }
    @Override
    public void setDtstart(String value) {
        dtstart.setRef(value);
    }
    @Override
    public Ref<String> getDtstartRef() {
        return dtstart;
    }

    @Override
    public boolean hasDuration() {
        return !duration.isEmptyRef();
    }
    @Override
    public String getDuration() {
        return duration.getRef();
    }
    @Override
    public void setDuration(String value) {
        duration.setRef(value);
    }
    @Override
    public Ref<String> getDurationRef() {
        return duration;
    }

    @Override
    public boolean hasGeo() {
        return !geo.isEmptyRef();
    }
    @Override
    public GeneratedGeoContainer getGeo() {
        return geo.getRef();
    }
    @Override
    public void setGeo(GeneratedGeoContainer value) {
        geo.setRef(value);
    }
    @Override
    public Ref<GeneratedGeoContainer> getGeoRef() {
        return geo;
    }

    @Override
    public boolean hasLocation() {
        return !location.isEmptyRef();
    }
    @Override
    public String getLocation() {
        return location.getRef();
    }
    @Override
    public void setLocation(String value) {
        location.setRef(value);
    }
    @Override
    public Ref<String> getLocationRef() {
        return location;
    }

    @Override
    public boolean hasRdate() {
        return !rdate.isEmptyRef();
    }
    @Override
    public String getRdate() {
        return rdate.getRef();
    }
    @Override
    public void setRdate(String value) {
        rdate.setRef(value);
    }
    @Override
    public Ref<String> getRdateRef() {
        return rdate;
    }

    @Override
    public boolean hasRrule() {
        return !rrule.isEmptyRef();
    }
    @Override
    public String getRrule() {
        return rrule.getRef();
    }
    @Override
    public void setRrule(String value) {
        rrule.setRef(value);
    }
    @Override
    public Ref<String> getRruleRef() {
        return rrule;
    }

    @Override
    public boolean hasSummary() {
        return !summary.isEmptyRef();
    }
    @Override
    public String getSummary() {
        return summary.getRef();
    }
    @Override
    public void setSummary(String value) {
        summary.setRef(value);
    }
    @Override
    public Ref<String> getSummaryRef() {
        return summary;
    }

    @Override
    public boolean hasUrl() {
        return !url.isEmptyRef();
    }
    @Override
    public String getUrl() {
        return url.getRef();
    }
    @Override
    public void setUrl(String value) {
        url.setRef(value);
    }
    @Override
    public Ref<String> getUrlRef() {
        return url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedCalendar{ ");
        if (!category.isEmptyRef()) sb.append("category='").append(category).append("', ");
        if (!description.isEmptyRef()) sb.append("description='").append(description).append("', ");
        if (!dtend.isEmptyRef()) sb.append("dtend='").append(dtend).append("', ");
        if (!dtstart.isEmptyRef()) sb.append("dtstart='").append(dtstart).append("', ");
        if (!duration.isEmptyRef()) sb.append("duration='").append(duration).append("', ");
        if (!geo.isEmptyRef()) sb.append("geo='").append(geo).append("', ");
        if (!location.isEmptyRef()) sb.append("location='").append(location).append("', ");
        if (!rdate.isEmptyRef()) sb.append("rdate='").append(rdate).append("', ");
        if (!rrule.isEmptyRef()) sb.append("rrule='").append(rrule).append("', ");
        if (!summary.isEmptyRef()) sb.append("summary='").append(summary).append("', ");
        if (!url.isEmptyRef()) sb.append("url='").append(url).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedCalendarLike) {
            GeneratedCalendarLike other = (GeneratedCalendarLike) o;
            if (hasCategory()) {
                if (!other.hasCategory()) return false;
                else if (!getCategory().equals(other.getCategory())) return false;
            } else if (other.hasCategory()) return false;
            if (hasDescription()) {
                if (!other.hasDescription()) return false;
                else if (!getDescription().equals(other.getDescription())) return false;
            } else if (other.hasDescription()) return false;
            if (hasDtend()) {
                if (!other.hasDtend()) return false;
                else if (!getDtend().equals(other.getDtend())) return false;
            } else if (other.hasDtend()) return false;
            if (hasDtstart()) {
                if (!other.hasDtstart()) return false;
                else if (!getDtstart().equals(other.getDtstart())) return false;
            } else if (other.hasDtstart()) return false;
            if (hasDuration()) {
                if (!other.hasDuration()) return false;
                else if (!getDuration().equals(other.getDuration())) return false;
            } else if (other.hasDuration()) return false;
            if (hasGeo()) {
                if (!other.hasGeo()) return false;
                else if (!getGeo().equals(other.getGeo())) return false;
            } else if (other.hasGeo()) return false;
            if (hasLocation()) {
                if (!other.hasLocation()) return false;
                else if (!getLocation().equals(other.getLocation())) return false;
            } else if (other.hasLocation()) return false;
            if (hasRdate()) {
                if (!other.hasRdate()) return false;
                else if (!getRdate().equals(other.getRdate())) return false;
            } else if (other.hasRdate()) return false;
            if (hasRrule()) {
                if (!other.hasRrule()) return false;
                else if (!getRrule().equals(other.getRrule())) return false;
            } else if (other.hasRrule()) return false;
            if (hasSummary()) {
                if (!other.hasSummary()) return false;
                else if (!getSummary().equals(other.getSummary())) return false;
            } else if (other.hasSummary()) return false;
            if (hasUrl()) {
                if (!other.hasUrl()) return false;
                else if (!getUrl().equals(other.getUrl())) return false;
            } else if (other.hasUrl()) return false;
            return true;
        } else if (o instanceof GeneratedCalendarRefable) {
            GeneratedCalendarRefable other = (GeneratedCalendarRefable) o;
            if (!getCategoryRef().equals(other.getCategoryRef())) return false;
            if (!getDescriptionRef().equals(other.getDescriptionRef())) return false;
            if (!getDtendRef().equals(other.getDtendRef())) return false;
            if (!getDtstartRef().equals(other.getDtstartRef())) return false;
            if (!getDurationRef().equals(other.getDurationRef())) return false;
            if (!getGeoRef().equals(other.getGeoRef())) return false;
            if (!getLocationRef().equals(other.getLocationRef())) return false;
            if (!getRdateRef().equals(other.getRdateRef())) return false;
            if (!getRruleRef().equals(other.getRruleRef())) return false;
            if (!getSummaryRef().equals(other.getSummaryRef())) return false;
            if (!getUrlRef().equals(other.getUrlRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + category.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + dtend.hashCode();
        result = 31 * result + dtstart.hashCode();
        result = 31 * result + duration.hashCode();
        result = 31 * result + geo.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + rdate.hashCode();
        result = 31 * result + rrule.hashCode();
        result = 31 * result + summary.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

}
