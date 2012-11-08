package net.exathunk.jereal.genschema.interfaces;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.interfaces.Interfaces;

public class InterfacesContainer implements InterfacesContainerLike, InterfacesContainerRefable {

    private final Ref<Interfaces> interfaces;

    public InterfacesContainer() {
        interfaces = new RefImpl<Interfaces>();
    }

    @Override
    public boolean hasInterfaces() {
        return !interfaces.isEmptyRef();
    }
    @Override
    public Interfaces getInterfaces() {
        return interfaces.getRef();
    }
    @Override
    public void setInterfaces(Interfaces value) {
        interfaces.setRef(value);
    }
    @Override
    public Ref<Interfaces> getInterfacesRef() {
        return interfaces;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("InterfacesContainer{ ");
        if (!interfaces.isEmptyRef()) sb.append("interfaces='").append(interfaces).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof InterfacesContainerRefable) {
            InterfacesContainerRefable other = (InterfacesContainerRefable) o;
            if (!getInterfacesRef().equals(other.getInterfacesRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + interfaces.hashCode();
        return result;
    }

}
