package net.exathunk.jereal.genschema.interfaces;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.interfaces.GeneratedInterfaces;
import net.exathunk.jereal.genschema.interfaces.GeneratedInterfacesContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedInterfacesContainer implements GeneratedInterfacesContainerLike, GeneratedInterfacesContainerRefable {

    private final Ref<GeneratedInterfaces> GeneratedInterfaces;

    public GeneratedInterfacesContainer() {
        GeneratedInterfaces = new RefImpl<GeneratedInterfaces>();
    }

    @Override
    public boolean hasGeneratedInterfaces() {
        return !GeneratedInterfaces.isEmptyRef();
    }
    @Override
    public GeneratedInterfaces getGeneratedInterfaces() {
        return GeneratedInterfaces.getRef();
    }
    @Override
    public void setGeneratedInterfaces(GeneratedInterfaces value) {
        GeneratedInterfaces.setRef(value);
    }
    @Override
    public Ref<GeneratedInterfaces> getGeneratedInterfacesRef() {
        return GeneratedInterfaces;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedInterfacesContainer{ ");
        if (!GeneratedInterfaces.isEmptyRef()) sb.append("GeneratedInterfaces='").append(GeneratedInterfaces).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedInterfacesContainerLike) {
            GeneratedInterfacesContainerLike other = (GeneratedInterfacesContainerLike) o;
            if (hasGeneratedInterfaces()) {
                if (!other.hasGeneratedInterfaces()) return false;
                else if (!getGeneratedInterfaces().equals(other.getGeneratedInterfaces())) return false;
            } else if (other.hasGeneratedInterfaces()) return false;
            return true;
        } else if (o instanceof GeneratedInterfacesContainerRefable) {
            GeneratedInterfacesContainerRefable other = (GeneratedInterfacesContainerRefable) o;
            if (!getGeneratedInterfacesRef().equals(other.getGeneratedInterfacesRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + GeneratedInterfaces.hashCode();
        return result;
    }

}
