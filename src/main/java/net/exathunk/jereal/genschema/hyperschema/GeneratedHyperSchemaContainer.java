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
import net.exathunk.jereal.genschema.hyperschemaoruri.GeneratedHyperSchemaOrUriContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedHyperSchemaContainer implements GeneratedHyperSchemaContainerLike, GeneratedHyperSchemaContainerRefable {

    private final Ref<JThing> generatedHyperSchema;

    public GeneratedHyperSchemaContainer() {
        generatedHyperSchema = new RefImpl<JThing>();
    }

    @Override
    public boolean hasGeneratedHyperSchema() {
        return !generatedHyperSchema.isEmptyRef();
    }
    @Override
    public JThing getGeneratedHyperSchema() {
        return generatedHyperSchema.getRef();
    }
    @Override
    public void setGeneratedHyperSchema(JThing value) {
        generatedHyperSchema.setRef(value);
    }
    @Override
    public Ref<JThing> getGeneratedHyperSchemaRef() {
        return generatedHyperSchema;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedHyperSchemaContainer{ ");
        if (!generatedHyperSchema.isEmptyRef()) sb.append("generatedHyperSchema='").append(generatedHyperSchema).append("', ");
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
        result = 31 * result + generatedHyperSchema.hashCode();
        return result;
    }

}
