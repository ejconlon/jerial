package net.exathunk.jereal.schema.domain;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Either;

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

    public String id;
    public String name;
    public String title;
    public String description;
    public String format;
    public String dollar_ref;
    public String dollar_schema;
    public String fragmentResolution;

    // This is an "unparsed" item
    public JThing defaultz;

    public Boolean required;
    public Boolean uniqueItems;

    public Long minItems;
    public Long minimum;

    public Either<SchemaRef<String>, Boolean> additionalProperties;

    public List<SchemaRef<TYPE>> type = new ArrayList<SchemaRef<TYPE>>();

    public SchemaRef<String> items;

    public SchemaRef<String> extendz;

    public final Map<String, SchemaRef<String>> properties = new TreeMap<String, SchemaRef<String>>();
    public final List<Link> links = new ArrayList<Link>();
    public final Map<String, String> dependencies = new TreeMap<String, String>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Schema{");
        if (id != null) sb.append("id='" + id + '\'' + ", ");
        if (name != null) sb.append("name='" + name + '\''+", ");
        if (title != null) sb.append("title='" + title + '\''+", ");
        if (description != null) sb.append("description='" + description + '\''+", ");
        if (format != null) sb.append("format='" + format + '\''+", ");
        if (dollar_ref != null) sb.append("dollar_ref='" + dollar_ref + '\''+", ");
        if (dollar_schema != null) sb.append("dollar_schema='" + dollar_schema + '\''+", ");
        if (fragmentResolution != null) sb.append("fragmentResolution='" + fragmentResolution + '\''+", ");
        if (defaultz != null) sb.append("defaultz=" + defaultz+", ");
        if (required != null) sb.append("required=" + required+", ");
        if (uniqueItems != null) sb.append("uniqueItems=" + uniqueItems+", ");
        if (minItems != null) sb.append("minItems=" + minItems+", ");
        if (minimum != null) sb.append("minimum=" + minimum+", ");
        if (additionalProperties != null) sb.append("additionalProperties=" + additionalProperties+", ");
        if (type != null) sb.append("type=" + type+", ");
        if (items != null) sb.append("items=" + items+", ");
        if (extendz != null) sb.append("extendz=" + extendz+", ");
        if (properties != null) sb.append("properties=" + properties+", ");
        if (links != null) sb.append("links=" + links+", ");
        if (dependencies != null) sb.append("dependencies=" + dependencies+", ");
        sb.append('}');
        return sb.toString();
    }
}
