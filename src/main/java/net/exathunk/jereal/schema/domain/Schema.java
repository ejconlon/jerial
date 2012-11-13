package net.exathunk.jereal.schema.domain;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/27/12 1:45 PM
 */
public class Schema {

    public enum TYPE {
        SELF, STRING, NUMBER, INTEGER, BOOLEAN, OBJECT, ARRAY, NULL, ANY;

        public static TYPE fromString(String string) {
            if ("#".equals(string)) {
                return TYPE.SELF;
            } else {
                return TYPE.valueOf(string.toUpperCase());
            }
        }

        @Override
        public String toString() {
            if (TYPE.SELF.equals(this)) {
                return "#";
            } else {
                return super.toString().toLowerCase();
            }
        }
    }

    public final Ref<String> id = new RefImpl<String>();
    public final Ref<String> name = new RefImpl<String>();
    public final Ref<String> title = new RefImpl<String>();
    public final Ref<String> description = new RefImpl<String>();
    public final Ref<String> format = new RefImpl<String>();
    public final Ref<String> dollar_ref = new RefImpl<String>();
    public final Ref<String> dollar_schema = new RefImpl<String>();
    public final Ref<String> fragmentResolution = new RefImpl<String>();

    // This is an "unparsed" item
    public final Ref<JThing> defaultz = new RefImpl<JThing>();

    public final Ref<Boolean> required = new RefImpl<Boolean>();
    public final Ref<Boolean> uniqueItems = new RefImpl<Boolean>();

    public final Ref<Long> minItems = new RefImpl<Long>();
    public final Ref<Long> minimum = new RefImpl<Long>();

    public final Ref<SchemaRef> additionalProperties_SchemaRef = new RefImpl<SchemaRef>();
    public final Ref<Boolean> additionalProperties_Boolean = new RefImpl<Boolean>();

    public final Ref<List<SchemaRef>> type_SchemaRef = new RefImpl<List<SchemaRef>>();
    public final Ref<String> type_String = new RefImpl<String>();

    public final Ref<SchemaRef> items = new RefImpl<SchemaRef>();

    public final Ref<SchemaRef> extendz = new RefImpl<SchemaRef>();

    public final Ref<Map<String, Ref<SchemaRef>>> properties = new RefImpl<Map<String, Ref<SchemaRef>>>();
    public final Ref<List<Link>> links = new RefImpl<List<Link>>();
    public final Ref<Map<String, Ref<String>>> dependencies = new RefImpl<Map<String, Ref<String>>>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Schema{");
        if (!id.isEmptyRef()) sb.append("id='" + id + '\'' + ", ");
        if (!name.isEmptyRef()) sb.append("name='" + name + '\''+", ");
        if (!title.isEmptyRef()) sb.append("title='" + title + '\''+", ");
        if (!description.isEmptyRef()) sb.append("description='" + description + '\''+", ");
        if (!format.isEmptyRef()) sb.append("format='" + format + '\''+", ");
        if (!dollar_ref.isEmptyRef()) sb.append("dollar_ref='" + dollar_ref + '\''+", ");
        if (!dollar_schema.isEmptyRef()) sb.append("dollar_schema='" + dollar_schema + '\''+", ");
        if (!fragmentResolution.isEmptyRef()) sb.append("fragmentResolution='" + fragmentResolution + '\''+", ");
        if (!defaultz.isEmptyRef()) sb.append("defaultz=" + defaultz+", ");
        if (!required.isEmptyRef()) sb.append("required=" + required+", ");
        if (!uniqueItems.isEmptyRef()) sb.append("uniqueItems=" + uniqueItems+", ");
        if (!minItems.isEmptyRef()) sb.append("minItems=" + minItems+", ");
        if (!minimum.isEmptyRef()) sb.append("minimum=" + minimum+", ");
        if (!additionalProperties_SchemaRef.isEmptyRef()) sb.append("additionalProperties=" + additionalProperties_SchemaRef+", ");
        if (!additionalProperties_Boolean.isEmptyRef()) sb.append("additionalProperties=" + additionalProperties_Boolean+", ");
        if (!type_SchemaRef.isEmptyRef()) sb.append("type=" + type_SchemaRef+", ");
        if (!type_String.isEmptyRef()) sb.append("type=" + type_String+", ");
        if (!items.isEmptyRef()) sb.append("items=" + items+", ");
        if (!extendz.isEmptyRef()) sb.append("extendz=" + extendz+", ");
        if (!properties.isEmptyRef()) sb.append("properties=" + properties+", ");
        if (!links.isEmptyRef()) sb.append("links=" + links+", ");
        if (!dependencies.isEmptyRef()) sb.append("dependencies=" + dependencies+", ");
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schema)) return false;

        Schema schema = (Schema) o;

        if (!additionalProperties_Boolean.equals(schema.additionalProperties_Boolean)) return false;
        if (!additionalProperties_SchemaRef.equals(schema.additionalProperties_SchemaRef)) return false;
        if (!defaultz.equals(schema.defaultz)) return false;
        if (!dependencies.equals(schema.dependencies)) return false;
        if (!description.equals(schema.description)) return false;
        if (!dollar_ref.equals(schema.dollar_ref)) return false;
        if (!dollar_schema.equals(schema.dollar_schema)) return false;
        if (!extendz.equals(schema.extendz)) return false;
        if (!format.equals(schema.format)) return false;
        if (!fragmentResolution.equals(schema.fragmentResolution)) return false;
        if (!id.equals(schema.id)) return false;
        if (!items.equals(schema.items)) return false;
        if (!links.equals(schema.links)) return false;
        if (!minItems.equals(schema.minItems)) return false;
        if (!minimum.equals(schema.minimum)) return false;
        if (!name.equals(schema.name)) return false;
        if (!properties.equals(schema.properties)) return false;
        if (!required.equals(schema.required)) return false;
        if (!title.equals(schema.title)) return false;
        if (!type_SchemaRef.equals(schema.type_SchemaRef)) return false;
        if (!type_String.equals(schema.type_String)) return false;
        if (!uniqueItems.equals(schema.uniqueItems)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + format.hashCode();
        result = 31 * result + dollar_ref.hashCode();
        result = 31 * result + dollar_schema.hashCode();
        result = 31 * result + fragmentResolution.hashCode();
        result = 31 * result + defaultz.hashCode();
        result = 31 * result + required.hashCode();
        result = 31 * result + uniqueItems.hashCode();
        result = 31 * result + minItems.hashCode();
        result = 31 * result + minimum.hashCode();
        result = 31 * result + additionalProperties_SchemaRef.hashCode();
        result = 31 * result + additionalProperties_Boolean.hashCode();
        result = 31 * result + type_SchemaRef.hashCode();
        result = 31 * result + type_String.hashCode();
        result = 31 * result + items.hashCode();
        result = 31 * result + extendz.hashCode();
        result = 31 * result + properties.hashCode();
        result = 31 * result + links.hashCode();
        result = 31 * result + dependencies.hashCode();
        return result;
    }
}
