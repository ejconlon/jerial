package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Jerial;
import net.exathunk.jereal.base.jerializers.Dejerializer;
import net.exathunk.jereal.base.jerializers.DejerializerRegistry;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.core.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.Map;

/**
 * charolastra 10/27/12 5:51 PM
 */
public class LinkDejerializer implements Dejerializer<Link> {
    @Override
    public void dejerialize(DejerializerRegistry registry, JObject object, Link link) throws JerializerException {
        for (Map.Entry<String, JThing> item : object.seq()) {
            final String key = item.getKey();
            final JThing value = item.getValue();
            if (!item.getValue().isString()) {
                throw new JerializerException("Unexpected value: "+key+" "+value);
            }
            final String strValue = value.rawGetString().runResFunc();
            if ("rel".equals(key)) {
                link.rel = strValue;
            } else if ("href".equals(key)) {
                link.href = strValue;
            } else if ("schema".equals(key)) {
                link.schema = strValue;
            } else if ("targetSchema".equals(key)) {
                link.targetSchema = strValue;
            } else if ("enctype".equals(key)) {
                link.enctype = strValue;
            } else if ("method".equals(key)) {
                link.method = strValue;
            } else if ("properties".equals(key)) {
                throw new JerializerException("TODO");
            } else {
                throw new JerializerException("Unexpected key: "+key);
            }
        }
    }
}
