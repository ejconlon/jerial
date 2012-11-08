package net.exathunk.jereal.genschema.hyperschemaoruri;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschemaoruri.GeneratedHyperSchemaOrUri;

public class GeneratedHyperSchemaOrUriContainer implements GeneratedHyperSchemaOrUriContainerLike, GeneratedHyperSchemaOrUriContainerRefable {

    private final Ref<GeneratedHyperSchemaOrUri> GeneratedHyperSchemaOrUri;

    public GeneratedHyperSchemaOrUriContainer() {
        GeneratedHyperSchemaOrUri = new RefImpl<GeneratedHyperSchemaOrUri>();
    }

    @Override
    public boolean hasGeneratedHyperSchemaOrUri() {
        return !GeneratedHyperSchemaOrUri.isEmptyRef();
    }
    @Override
    public GeneratedHyperSchemaOrUri getGeneratedHyperSchemaOrUri() {
        return GeneratedHyperSchemaOrUri.getRef();
    }
    @Override
    public void setGeneratedHyperSchemaOrUri(GeneratedHyperSchemaOrUri value) {
        GeneratedHyperSchemaOrUri.setRef(value);
    }
    @Override
    public Ref<GeneratedHyperSchemaOrUri> getGeneratedHyperSchemaOrUriRef() {
        return GeneratedHyperSchemaOrUri;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedHyperSchemaOrUriContainer{ ");
        if (!GeneratedHyperSchemaOrUri.isEmptyRef()) sb.append("GeneratedHyperSchemaOrUri='").append(GeneratedHyperSchemaOrUri).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedHyperSchemaOrUriContainerLike) {
            GeneratedHyperSchemaOrUriContainerLike other = (GeneratedHyperSchemaOrUriContainerLike) o;
            if (hasGeneratedHyperSchemaOrUri()) {
                if (!other.hasGeneratedHyperSchemaOrUri()) return false;
                else if (!getGeneratedHyperSchemaOrUri().equals(other.getGeneratedHyperSchemaOrUri())) return false;
            } else if (other.hasGeneratedHyperSchemaOrUri()) return false;
            return true;
        } else if (o instanceof GeneratedHyperSchemaOrUriContainerRefable) {
            GeneratedHyperSchemaOrUriContainerRefable other = (GeneratedHyperSchemaOrUriContainerRefable) o;
            if (!getGeneratedHyperSchemaOrUriRef().equals(other.getGeneratedHyperSchemaOrUriRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + GeneratedHyperSchemaOrUri.hashCode();
        return result;
    }

}
