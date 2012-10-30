package net.exathunk.jereal.schema.domain;

import java.util.Map;
import java.util.TreeMap;

/**
 * charolastra 10/27/12 1:45 PM
 */
public class Link {
    public String rel;
    public String href;
    public String schema;
    public String targetSchema;
    public String enctype;
    public String method;
    public final Map<String, SchemaRef<String>> properties = new TreeMap<String, SchemaRef<String>>();

    @Override
    public String toString() {
        return "Link{" +
                "rel='" + rel + '\'' +
                ", href='" + href + '\'' +
                (schema != null ? ", schema='" + schema + '\'' : "") +
                (targetSchema != null ? ", targetSchema='" + targetSchema + '\'' : "") +
                (enctype != null ? ", enctype='" + enctype + '\'' : "") +
                (method != null ? ", method='" + method + '\'' : "") +
                (!properties.isEmpty() ? ", properties=" + properties : "") +
                '}';
    }
}
