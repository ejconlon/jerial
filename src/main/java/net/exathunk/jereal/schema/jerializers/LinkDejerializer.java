package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.jerializers.Dejerializer;
import net.exathunk.jereal.base.jerializers.DejerializerRegistry;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.schema.domain.Link;

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
                link.rel.setRef(strValue);
            } else if ("href".equals(key)) {
                link.href.setRef(strValue);
            } else if ("schema".equals(key)) {
                link.schema.setRef(strValue);
            } else if ("targetSchema".equals(key)) {
                link.targetSchema.setRef(strValue);
            } else if ("enctype".equals(key)) {
                link.enctype.setRef(strValue);
            } else if ("method".equals(key)) {
                link.method.setRef(strValue);
            } else if ("properties".equals(key)) {
                throw new JerializerException("TODO");
            } else {
                throw new JerializerException("Unexpected key: "+key);
            }
        }
    }
}
