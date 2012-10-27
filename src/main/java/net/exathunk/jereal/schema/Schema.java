package net.exathunk.jereal.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * charolastra 10/27/12 1:45 PM
 */
public class Schema {
    public final Meta meta = new Meta();
    public final Map<String, Meta> properties = new TreeMap<String, Meta>();
    public final List<Link> links = new ArrayList<Link>();
}
