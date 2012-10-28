package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.Dejerializer;
import net.exathunk.jereal.base.DejerializerRegistry;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;

import java.util.List;

/**
 * charolastra 10/27/12 4:12 PM
 */
public class MetaDejerializer implements Dejerializer<Meta> {
    @Override
    public void dejerialize(DejerializerRegistry registry, Jerial jerial, Meta meta) throws JerializerException {
        for (Jitem item : jerial) {
            final String key = item.getPart().getLeft();
            if ("name".equals(key)) {
                meta.name = item.getString();
            } else if ("description".equals(key)) {
                meta.description = item.getString();
            } else if ("title".equals(key)) {
                meta.title = item.getString();
            } else if ("format".equals(key)) {
                meta.format = item.getString();
            } else if ("required".equals(key)) {
                meta.required = item.getBoolean();
            } else if ("type".equals(key)) {
                addTypes(item, meta.type);
            } else if ("items".equals(key)) {
                addTypes(item, meta.itemType);
            } else {
                throw new JerializerException("Unexpected part: "+item.getPart());
            }
        }
    }

    private static void addTypes(Jitem item, List<Meta.TYPE> types) throws JerializerException{
        if (item.isArray()) {
            for (Jitem child : item.getArray()) {
                types.add(Meta.TYPE.valueOf(child.getString().toUpperCase()));
            }
        } else if (item.isString()) {
            types.add(Meta.TYPE.valueOf(item.getString().toUpperCase()));
        } else {
            throw new JerializerException("Bad type format: "+item);
        }
    }
}
