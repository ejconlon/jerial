package net.exathunk.jereal.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * charolastra 10/27/12 1:45 PM
 */
public class Schema {

    public enum TYPE {
        STRING, NUMBER, INTEGER, BOOLEAN, OBJECT, ARRAY, NULL, ANY
    }

    public String name;
    public String title;
    public String description;
    public String format;
    public String dollar_ref;
    public String dollar_schema;
    public boolean required;

    public List<TYPE> type = new ArrayList<TYPE>();
    public Schema items;

    public final Map<String, Schema> properties = new TreeMap<String, Schema>();
    public final List<Link> links = new ArrayList<Link>();
    public final Map<String, String> dependencies = new TreeMap<String, String>();

    @Override
    public String toString() {
        return "Schema{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                ", dollar_ref='" + dollar_ref + '\'' +
                ", dollar_schema='" + dollar_schema + '\'' +
                ", required=" + required +
                ", type=" + type +
                ", items=" + items +
                ", properties=" + properties +
                ", links=" + links +
                ", dependencies=" + dependencies +
                '}';
    }
}
