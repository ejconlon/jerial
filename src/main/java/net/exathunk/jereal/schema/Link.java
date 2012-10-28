package net.exathunk.jereal.schema;

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
}
