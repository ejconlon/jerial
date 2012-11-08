package net.exathunk.jereal.genschema.links;

import java.lang.String;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchemaContainer;

public class GeneratedLinksContainer implements GeneratedLinksContainerLike, GeneratedLinksContainerRefable {

    private final Ref<JThing> generatedLinks;

    public GeneratedLinksContainer() {
        generatedLinks = new RefImpl<JThing>();
    }

    @Override
    public boolean hasGeneratedLinks() {
        return !generatedLinks.isEmptyRef();
    }
    @Override
    public JThing getGeneratedLinks() {
        return generatedLinks.getRef();
    }
    @Override
    public void setGeneratedLinks(JThing value) {
        generatedLinks.setRef(value);
    }
    @Override
    public Ref<JThing> getGeneratedLinksRef() {
        return generatedLinks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedLinksContainer{ ");
        if (!generatedLinks.isEmptyRef()) sb.append("generatedLinks='").append(generatedLinks).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedLinksContainerLike) {
            GeneratedLinksContainerLike other = (GeneratedLinksContainerLike) o;
            if (hasGeneratedLinks()) {
                if (!other.hasGeneratedLinks()) return false;
                else if (!getGeneratedLinks().equals(other.getGeneratedLinks())) return false;
            } else if (other.hasGeneratedLinks()) return false;
            return true;
        } else if (o instanceof GeneratedLinksContainerRefable) {
            GeneratedLinksContainerRefable other = (GeneratedLinksContainerRefable) o;
            if (!getGeneratedLinksRef().equals(other.getGeneratedLinksRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + generatedLinks.hashCode();
        return result;
    }

}
