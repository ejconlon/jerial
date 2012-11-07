package net.exathunk.jereal.genschema.geo;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.geo.GeneratedGeo;
import net.exathunk.jereal.genschema.geo.GeneratedGeoContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedGeoContainer implements GeneratedGeoContainerLike, GeneratedGeoContainerRefable {

    private final Ref<GeneratedGeo> GeneratedGeo;

    public GeneratedGeoContainer() {
        GeneratedGeo = new RefImpl<GeneratedGeo>();
    }

    @Override
    public boolean hasGeneratedGeo() {
        return !GeneratedGeo.isEmptyRef();
    }
    @Override
    public GeneratedGeo getGeneratedGeo() {
        return GeneratedGeo.getRef();
    }
    @Override
    public void setGeneratedGeo(GeneratedGeo value) {
        GeneratedGeo.setRef(value);
    }
    @Override
    public Ref<GeneratedGeo> getGeneratedGeoRef() {
        return GeneratedGeo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedGeoContainer{ ");
        if (!GeneratedGeo.isEmptyRef()) sb.append("GeneratedGeo='").append(GeneratedGeo).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedGeoContainerLike) {
            GeneratedGeoContainerLike other = (GeneratedGeoContainerLike) o;
            if (hasGeneratedGeo()) {
                if (!other.hasGeneratedGeo()) return false;
                else if (!getGeneratedGeo().equals(other.getGeneratedGeo())) return false;
            } else if (other.hasGeneratedGeo()) return false;
            return true;
        } else if (o instanceof GeneratedGeoContainerRefable) {
            GeneratedGeoContainerRefable other = (GeneratedGeoContainerRefable) o;
            if (!getGeneratedGeoRef().equals(other.getGeneratedGeoRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + GeneratedGeo.hashCode();
        return result;
    }

}
