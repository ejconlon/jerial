package net.exathunk.jereal.genschema.geo;

import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.*;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.geo.*;

public class GeoContainer implements GeoContainerLike, GeoContainerRefable {

    private final Ref<Geo> geo;

    public GeoContainer() {
        geo = new RefImpl<Geo>();
    }

    @Override
    public boolean hasGeo() {
        return !geo.isEmptyRef();
    }
    @Override
    public Geo getGeo() {
        return geo.getRef();
    }
    @Override
    public void setGeo(Geo value) {
        geo.setRef(value);
    }
    @Override
    public Ref<Geo> getGeoRef() {
        return geo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeoContainer{ ");
        if (!geo.isEmptyRef()) sb.append("geo='").append(geo).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeoContainerRefable) {
            GeoContainerRefable other = (GeoContainerRefable) o;
            if (!getGeoRef().equals(other.getGeoRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + geo.hashCode();
        return result;
    }

}
