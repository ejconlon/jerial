package net.exathunk.jereal.genschema.jsonref;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.jsonref.GeneratedJsonRef;
import net.exathunk.jereal.genschema.jsonref.GeneratedJsonRefContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedJsonRefContainer implements GeneratedJsonRefContainerLike, GeneratedJsonRefContainerRefable {

    private final Ref<GeneratedJsonRef> GeneratedJsonRef;

    public GeneratedJsonRefContainer() {
        GeneratedJsonRef = new RefImpl<GeneratedJsonRef>();
    }

    @Override
    public boolean hasGeneratedJsonRef() {
        return !GeneratedJsonRef.isEmptyRef();
    }
    @Override
    public GeneratedJsonRef getGeneratedJsonRef() {
        return GeneratedJsonRef.getRef();
    }
    @Override
    public void setGeneratedJsonRef(GeneratedJsonRef value) {
        GeneratedJsonRef.setRef(value);
    }
    @Override
    public Ref<GeneratedJsonRef> getGeneratedJsonRefRef() {
        return GeneratedJsonRef;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedJsonRefContainer{ ");
        if (!GeneratedJsonRef.isEmptyRef()) sb.append("GeneratedJsonRef='").append(GeneratedJsonRef).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedJsonRefContainerLike) {
            GeneratedJsonRefContainerLike other = (GeneratedJsonRefContainerLike) o;
            if (hasGeneratedJsonRef()) {
                if (!other.hasGeneratedJsonRef()) return false;
                else if (!getGeneratedJsonRef().equals(other.getGeneratedJsonRef())) return false;
            } else if (other.hasGeneratedJsonRef()) return false;
            return true;
        } else if (o instanceof GeneratedJsonRefContainerRefable) {
            GeneratedJsonRefContainerRefable other = (GeneratedJsonRefContainerRefable) o;
            if (!getGeneratedJsonRefRef().equals(other.getGeneratedJsonRefRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + GeneratedJsonRef.hashCode();
        return result;
    }

}
