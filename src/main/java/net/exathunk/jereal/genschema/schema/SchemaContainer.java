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
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.schema.Schema;
import net.exathunk.jereal.genschema.schema.SchemaContainer;

public class SchemaContainer implements SchemaContainerLike, SchemaContainerRefable {

    private final Ref2<Schema,String> schema;

    public SchemaContainer() {
        schema = new Ref2<Schema,String>();
    }

    @Override
    public boolean hasSchema() {
        return !schema.isEmptyRef();
    }
    @Override
    public Ref2<Schema,String> getSchemaRef() {
        return schema;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SchemaContainer{ ");
        if (!schema.isEmptyRef()) sb.append("schema='").append(schema).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof SchemaContainerRefable) {
            SchemaContainerRefable other = (SchemaContainerRefable) o;
            if (!getSchemaRef().equals(other.getSchemaRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + schema.hashCode();
        return result;
    }

}
