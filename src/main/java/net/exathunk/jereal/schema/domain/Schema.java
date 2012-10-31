package net.exathunk.jereal.schema.domain;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Either;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    public final Ref<Either<Ref<SchemaRef<String>>, Ref<Boolean>>> additionalProperties = new RefImpl<Either<Ref<SchemaRef<String>>, Ref<Boolean>>>();

    public final Ref<List<Ref<SchemaRef<TYPE>>>> type = new RefImpl<List<Ref<SchemaRef<TYPE>>>>(new ArrayList<Ref<SchemaRef<TYPE>>>());

    public final Ref<SchemaRef<String>> items = new RefImpl<SchemaRef<String>>();

    public final Ref<SchemaRef<String>> extendz = new RefImpl<SchemaRef<String>>();

    public final Ref<Map<String, Ref<SchemaRef<String>>>> properties = new RefImpl<Map<String, Ref<SchemaRef<String>>>>(new TreeMap<String, Ref<SchemaRef<String>>>());
    public final Ref<List<Ref<Link>>> links = new RefImpl<List<Ref<Link>>>(new ArrayList<Ref<Link>>());
    public final Ref<Map<String, Ref<String>>> dependencies = new RefImpl<Map<String, Ref<String>>>(new TreeMap<String, Ref<String>>());

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
        if (!additionalProperties.isEmptyRef()) sb.append("additionalProperties=" + additionalProperties+", ");
        if (!type.isEmptyRef()) sb.append("type=" + type+", ");
        if (!items.isEmptyRef()) sb.append("items=" + items+", ");
        if (!extendz.isEmptyRef()) sb.append("extendz=" + extendz+", ");
        if (!properties.isEmptyRef()) sb.append("properties=" + properties+", ");
        if (!links.isEmptyRef()) sb.append("links=" + links+", ");
        if (!dependencies.isEmptyRef()) sb.append("dependencies=" + dependencies+", ");
        sb.append('}');
        return sb.toString();
    }
}
