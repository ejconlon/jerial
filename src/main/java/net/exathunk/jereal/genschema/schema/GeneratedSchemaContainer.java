package net.exathunk.jereal.genschema.schema;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.Long;
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
import net.exathunk.jereal.genschema.schema.GeneratedSchema;
import net.exathunk.jereal.genschema.schema.GeneratedSchemaContainer;

public class GeneratedSchemaContainer implements GeneratedSchemaContainerLike, GeneratedSchemaContainerRefable {

    private final Ref<Any2<GeneratedSchema,String>> generatedSchema;

    public GeneratedSchemaContainer() {
        generatedSchema = new RefImpl<Any2<GeneratedSchema,String>>();
    }

    @Override
    public boolean hasGeneratedSchema() {
        return !generatedSchema.isEmptyRef();
    }
    @Override
    public Any2<GeneratedSchema,String> getGeneratedSchema() {
        return generatedSchema.getRef();
    }
    @Override
    public void setGeneratedSchema(Any2<GeneratedSchema,String> value) {
        generatedSchema.setRef(value);
    }
    @Override
    public Ref<Any2<GeneratedSchema,String>> getGeneratedSchemaRef() {
        return generatedSchema;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedSchemaContainer{ ");
        if (!generatedSchema.isEmptyRef()) sb.append("generatedSchema='").append(generatedSchema).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedSchemaContainerLike) {
            GeneratedSchemaContainerLike other = (GeneratedSchemaContainerLike) o;
            if (hasGeneratedSchema()) {
                if (!other.hasGeneratedSchema()) return false;
                else if (!getGeneratedSchema().equals(other.getGeneratedSchema())) return false;
            } else if (other.hasGeneratedSchema()) return false;
            return true;
        } else if (o instanceof GeneratedSchemaContainerRefable) {
            GeneratedSchemaContainerRefable other = (GeneratedSchemaContainerRefable) o;
            if (!getGeneratedSchemaRef().equals(other.getGeneratedSchemaRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + generatedSchema.hashCode();
        return result;
    }

}
