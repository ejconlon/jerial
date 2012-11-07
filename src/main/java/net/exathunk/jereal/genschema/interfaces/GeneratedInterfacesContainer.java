package net.exathunk.jereal.genschema.interfaces;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedInterfacesContainer {

    private final Ref<JThing> methods;

    public GeneratedInterfacesContainer() {
        methods = new RefImpl<JThing>();
    }

    public boolean hasMethods() {
        return !methods.isEmptyRef();
    }
    public JThing getMethods() {
        return methods.getRef();
    }
    public void setMethods(JThing value) {
        methods.setRef(value);
    }
    public Ref<JThing> getMethodsRef() {
        return methods;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedInterfacesContainer{ ");
        if (!methods.isEmptyRef()) sb.append("methods='").append(methods).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedInterfacesContainer) {
            GeneratedInterfacesContainer other = (GeneratedInterfacesContainer) o;
            if (hasMethods()) {
                if (!other.hasMethods()) return false;
                else if (!getMethods().equals(other.getMethods())) return false;
            } else if (other.hasMethods()) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + methods.hashCode();
        return result;
    }

}
