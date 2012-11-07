package net.exathunk.jereal.genschema.hyperschemaoruri;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchema;
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchemaContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedHyperSchemaOrUriContainer implements GeneratedHyperSchemaOrUriContainerLike, GeneratedHyperSchemaOrUriContainerRefable {

    private final Ref<Any2<String,GeneratedHyperSchemaContainer>> GeneratedHyperSchemaOrUri;

    public GeneratedHyperSchemaOrUriContainer() {
        GeneratedHyperSchemaOrUri = new RefImpl<Any2<String,GeneratedHyperSchemaContainer>>();
    }

    @Override
    public boolean hasGeneratedHyperSchemaOrUri() {
        return !GeneratedHyperSchemaOrUri.isEmptyRef();
    }
    @Override
    public Any2<String,GeneratedHyperSchemaContainer> getGeneratedHyperSchemaOrUri() {
        return GeneratedHyperSchemaOrUri.getRef();
    }
    @Override
    public void setGeneratedHyperSchemaOrUri(Any2<String,GeneratedHyperSchemaContainer> value) {
        GeneratedHyperSchemaOrUri.setRef(value);
    }
    @Override
    public Ref<Any2<String,GeneratedHyperSchemaContainer>> getGeneratedHyperSchemaOrUriRef() {
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
