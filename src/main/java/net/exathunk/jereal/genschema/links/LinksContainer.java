package net.exathunk.jereal.genschema.links;

import java.lang.String;
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
import net.exathunk.jereal.genschema.hyperschema.HyperSchemaContainer;
import net.exathunk.jereal.genschema.links.Links;

public class LinksContainer implements LinksContainerLike, LinksContainerRefable {

    private final Ref<Links> links;

    public LinksContainer() {
        links = new RefImpl<Links>();
    }

    @Override
    public boolean hasLinks() {
        return !links.isEmptyRef();
    }
    @Override
    public Links getLinks() {
        return links.getRef();
    }
    @Override
    public void setLinks(Links value) {
        links.setRef(value);
    }
    @Override
    public Ref<Links> getLinksRef() {
        return links;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LinksContainer{ ");
        if (!links.isEmptyRef()) sb.append("links='").append(links).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof LinksContainerRefable) {
            LinksContainerRefable other = (LinksContainerRefable) o;
            if (!getLinksRef().equals(other.getLinksRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + links.hashCode();
        return result;
    }

}
