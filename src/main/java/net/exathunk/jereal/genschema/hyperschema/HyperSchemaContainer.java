package net.exathunk.jereal.genschema.hyperschema;

import java.lang.Boolean;
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
import net.exathunk.jereal.genschema.hyperschema.HyperSchema;
import net.exathunk.jereal.genschema.hyperschemaoruri.HyperSchemaOrUriContainer;
import net.exathunk.jereal.genschema.links.LinksContainer;

public class HyperSchemaContainer implements HyperSchemaContainerLike, HyperSchemaContainerRefable {

    private final Ref<HyperSchema> hyperSchema;

    public HyperSchemaContainer() {
        hyperSchema = new RefImpl<HyperSchema>();
    }

    @Override
    public boolean hasHyperSchema() {
        return !hyperSchema.isEmptyRef();
    }
    @Override
    public HyperSchema getHyperSchema() {
        return hyperSchema.getRef();
    }
    @Override
    public void setHyperSchema(HyperSchema value) {
        hyperSchema.setRef(value);
    }
    @Override
    public Ref<HyperSchema> getHyperSchemaRef() {
        return hyperSchema;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("HyperSchemaContainer{ ");
        if (!hyperSchema.isEmptyRef()) sb.append("hyperSchema='").append(hyperSchema).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof HyperSchemaContainerRefable) {
            HyperSchemaContainerRefable other = (HyperSchemaContainerRefable) o;
            if (!getHyperSchemaRef().equals(other.getHyperSchemaRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + hyperSchema.hashCode();
        return result;
    }

}
