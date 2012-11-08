package net.exathunk.jereal.genschema.interfaces;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;

public class GeneratedInterfacesContainer implements GeneratedInterfacesContainerLike, GeneratedInterfacesContainerRefable {

    private final Ref<JThing> generatedInterfaces;

    public GeneratedInterfacesContainer() {
        generatedInterfaces = new RefImpl<JThing>();
    }

    @Override
    public boolean hasGeneratedInterfaces() {
        return !generatedInterfaces.isEmptyRef();
    }
    @Override
    public JThing getGeneratedInterfaces() {
        return generatedInterfaces.getRef();
    }
    @Override
    public void setGeneratedInterfaces(JThing value) {
        generatedInterfaces.setRef(value);
    }
    @Override
    public Ref<JThing> getGeneratedInterfacesRef() {
        return generatedInterfaces;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedInterfacesContainer{ ");
        if (!generatedInterfaces.isEmptyRef()) sb.append("generatedInterfaces='").append(generatedInterfaces).append("', ");
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
        result = 31 * result + generatedInterfaces.hashCode();
        return result;
    }

}
