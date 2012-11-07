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

public class GeneratedCalendarContainer {

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

    public GeneratedCalendarContainer() {
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

    public boolean hasCategory() {
        return !category.isEmptyRef();
    }
    public String getCategory() {
        return category.getRef();
    }
    public void setCategory(String value) {
        category.setRef(value);
    }
    public Ref<String> getCategoryRef() {
        return category;
    }

    public boolean hasDescription() {
        return !description.isEmptyRef();
    }
    public String getDescription() {
        return description.getRef();
    }
    public void setDescription(String value) {
        description.setRef(value);
    }
    public Ref<String> getDescriptionRef() {
        return description;
    }

    public boolean hasDtend() {
        return !dtend.isEmptyRef();
    }
    public String getDtend() {
        return dtend.getRef();
    }
    public void setDtend(String value) {
        dtend.setRef(value);
    }
    public Ref<String> getDtendRef() {
        return dtend;
    }

    public boolean hasDtstart() {
        return !dtstart.isEmptyRef();
    }
    public String getDtstart() {
        return dtstart.getRef();
    }
    public void setDtstart(String value) {
        dtstart.setRef(value);
    }
    public Ref<String> getDtstartRef() {
        return dtstart;
    }

    public boolean hasDuration() {
        return !duration.isEmptyRef();
    }
    public String getDuration() {
        return duration.getRef();
    }
    public void setDuration(String value) {
        duration.setRef(value);
    }
    public Ref<String> getDurationRef() {
        return duration;
    }

    public boolean hasGeo() {
        return !geo.isEmptyRef();
    }
    public GeneratedGeoContainer getGeo() {
        return geo.getRef();
    }
    public void setGeo(GeneratedGeoContainer value) {
        geo.setRef(value);
    }
    public Ref<GeneratedGeoContainer> getGeoRef() {
        return geo;
    }

    public boolean hasLocation() {
        return !location.isEmptyRef();
    }
    public String getLocation() {
        return location.getRef();
    }
    public void setLocation(String value) {
        location.setRef(value);
    }
    public Ref<String> getLocationRef() {
        return location;
    }

    public boolean hasRdate() {
        return !rdate.isEmptyRef();
    }
    public String getRdate() {
        return rdate.getRef();
    }
    public void setRdate(String value) {
        rdate.setRef(value);
    }
    public Ref<String> getRdateRef() {
        return rdate;
    }

    public boolean hasRrule() {
        return !rrule.isEmptyRef();
    }
    public String getRrule() {
        return rrule.getRef();
    }
    public void setRrule(String value) {
        rrule.setRef(value);
    }
    public Ref<String> getRruleRef() {
        return rrule;
    }

    public boolean hasSummary() {
        return !summary.isEmptyRef();
    }
    public String getSummary() {
        return summary.getRef();
    }
    public void setSummary(String value) {
        summary.setRef(value);
    }
    public Ref<String> getSummaryRef() {
        return summary;
    }

    public boolean hasUrl() {
        return !url.isEmptyRef();
    }
    public String getUrl() {
        return url.getRef();
    }
    public void setUrl(String value) {
        url.setRef(value);
    }
    public Ref<String> getUrlRef() {
        return url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedCalendarContainer{ ");
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
        if (o instanceof GeneratedCalendarContainer) {
            GeneratedCalendarContainer other = (GeneratedCalendarContainer) o;
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
