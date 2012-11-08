package net.exathunk.jereal.genschema.hyperschema;

import java.lang.Boolean;
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
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchema;
import net.exathunk.jereal.genschema.hyperschemaoruri.GeneratedHyperSchemaOrUriContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedHyperSchemaContainer implements GeneratedHyperSchemaContainerLike, GeneratedHyperSchemaContainerRefable {

    private final Ref<GeneratedHyperSchema> GeneratedHyperSchema;

    public GeneratedHyperSchemaContainer() {
        GeneratedHyperSchema = new RefImpl<GeneratedHyperSchema>();
    }

    @Override
    public boolean hasGeneratedHyperSchema() {
        return !GeneratedHyperSchema.isEmptyRef();
    }
    @Override
    public GeneratedHyperSchema getGeneratedHyperSchema() {
        return GeneratedHyperSchema.getRef();
    }
    @Override
    public void setGeneratedHyperSchema(GeneratedHyperSchema value) {
        GeneratedHyperSchema.setRef(value);
    }
    @Override
    public Ref<GeneratedHyperSchema> getGeneratedHyperSchemaRef() {
        return GeneratedHyperSchema;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedHyperSchemaContainer{ ");
        if (!GeneratedHyperSchema.isEmptyRef()) sb.append("GeneratedHyperSchema='").append(GeneratedHyperSchema).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedHyperSchemaContainerLike) {
            GeneratedHyperSchemaContainerLike other = (GeneratedHyperSchemaContainerLike) o;
            if (hasGeneratedHyperSchema()) {
                if (!other.hasGeneratedHyperSchema()) return false;
                else if (!getGeneratedHyperSchema().equals(other.getGeneratedHyperSchema())) return false;
            } else if (other.hasGeneratedHyperSchema()) return false;
            return true;
        } else if (o instanceof GeneratedHyperSchemaContainerRefable) {
            GeneratedHyperSchemaContainerRefable other = (GeneratedHyperSchemaContainerRefable) o;
            if (!getGeneratedHyperSchemaRef().equals(other.getGeneratedHyperSchemaRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + GeneratedHyperSchema.hashCode();
        return result;
    }

}
