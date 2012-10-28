package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Either;
import net.exathunk.jereal.base.core.Jitem;

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
        return "Schema{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                ", dollar_ref='" + dollar_ref + '\'' +
                ", dollar_schema='" + dollar_schema + '\'' +
                ", fragmentResolution='" + fragmentResolution + '\'' +
                ", defaultz=" + defaultz +
                ", required=" + required +
                ", uniqueItems=" + uniqueItems +
                ", minItems=" + minItems +
                ", minimum=" + minimum +
                ", additionalProperties=" + additionalProperties +
                ", type=" + type +
                ", items=" + items +
                ", extendz=" + extendz +
                ", properties=" + properties +
                ", links=" + links +
                ", dependencies=" + dependencies +
                '}';
    }
}
