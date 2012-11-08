package net.exathunk.jereal.genschema.hyperschemaoruri;

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

public class HyperSchemaOrUriContainer implements HyperSchemaOrUriContainerLike, HyperSchemaOrUriContainerRefable {

    private final Ref2<String,HyperSchemaContainer> hyperSchemaOrUri;

    public HyperSchemaOrUriContainer() {
        hyperSchemaOrUri = new Ref2<String,HyperSchemaContainer>();
    }

    @Override
    public boolean hasHyperSchemaOrUri() {
        return !hyperSchemaOrUri.isEmptyRef();
    }
    @Override
    public Ref2<String,HyperSchemaContainer> getHyperSchemaOrUriRef() {
        return hyperSchemaOrUri;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("HyperSchemaOrUriContainer{ ");
        if (!hyperSchemaOrUri.isEmptyRef()) sb.append("hyperSchemaOrUri='").append(hyperSchemaOrUri).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof HyperSchemaOrUriContainerRefable) {
            HyperSchemaOrUriContainerRefable other = (HyperSchemaOrUriContainerRefable) o;
            if (!getHyperSchemaOrUriRef().equals(other.getHyperSchemaOrUriRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + hyperSchemaOrUri.hashCode();
        return result;
    }

}
