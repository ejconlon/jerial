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

public class GeneratedJsonRefContainer implements GeneratedJsonRefContainerLike, GeneratedJsonRefContainerRefable {

    private final Ref<JThing> generatedJsonRef;

    public GeneratedJsonRefContainer() {
        generatedJsonRef = new RefImpl<JThing>();
    }

    @Override
    public boolean hasGeneratedJsonRef() {
        return !generatedJsonRef.isEmptyRef();
    }
    @Override
    public JThing getGeneratedJsonRef() {
        return generatedJsonRef.getRef();
    }
    @Override
    public void setGeneratedJsonRef(JThing value) {
        generatedJsonRef.setRef(value);
    }
    @Override
    public Ref<JThing> getGeneratedJsonRefRef() {
        return generatedJsonRef;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedJsonRefContainer{ ");
        if (!generatedJsonRef.isEmptyRef()) sb.append("generatedJsonRef='").append(generatedJsonRef).append("', ");
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
        result = 31 * result + generatedJsonRef.hashCode();
        return result;
    }

}
