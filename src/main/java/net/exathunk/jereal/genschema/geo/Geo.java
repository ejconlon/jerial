package net.exathunk.jereal.genschema.geo;

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

public class Geo implements GeoLike, GeoRefable {

    private final Ref<Double> latitude;
    private final Ref<Double> longitude;

    public Geo() {
        latitude = new RefImpl<Double>();
        longitude = new RefImpl<Double>();
    }

    @Override
    public boolean hasLatitude() {
        return !latitude.isEmptyRef();
    }
    @Override
    public Double getLatitude() {
        return latitude.getRef();
    }
    @Override
    public void setLatitude(Double value) {
        latitude.setRef(value);
    }
    @Override
    public Ref<Double> getLatitudeRef() {
        return latitude;
    }

    @Override
    public boolean hasLongitude() {
        return !longitude.isEmptyRef();
    }
    @Override
    public Double getLongitude() {
        return longitude.getRef();
    }
    @Override
    public void setLongitude(Double value) {
        longitude.setRef(value);
    }
    @Override
    public Ref<Double> getLongitudeRef() {
        return longitude;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Geo{ ");
        if (!latitude.isEmptyRef()) sb.append("latitude='").append(latitude).append("', ");
        if (!longitude.isEmptyRef()) sb.append("longitude='").append(longitude).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeoRefable) {
            GeoRefable other = (GeoRefable) o;
            if (!getLatitudeRef().equals(other.getLatitudeRef())) return false;
            if (!getLongitudeRef().equals(other.getLongitudeRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + latitude.hashCode();
        result = 31 * result + longitude.hashCode();
        return result;
    }

}
