package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.JerialContext;
import net.exathunk.jereal.base.Jerializer;
import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.JerializerRegistry;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.ArrayList;
import java.util.List;

/**
 * charolastra 10/27/12 4:11 PM
 */
public class MetaJerializer implements Jerializer<Meta> {
    @Override
    public void jerialize(JerializerRegistry registry, Meta meta, JerialContext context) throws JerializerException {
        if (meta.name != null) context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("name"), meta.name));
        if (meta.description != null) context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("description"), meta.description));
        if (meta.title != null) context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("title"), meta.title));
        if (meta.format != null) context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("format"), meta.format));
        if (meta.required) context.builder.addJitem(Jitem.makeBoolean(PathPart.makeLeft("required"), meta.required));
        if (!meta.type.isEmpty()) {
            addTypes(meta.type, "type", context);
        }
        if (!meta.itemType.isEmpty()) {
            addTypes(meta.itemType, "items", context);
        }
    }

    private static void addTypes(List<Meta.TYPE> types, String key, JerialContext context) {
        assert (types.size() > 0);
        List<Jitem> arr = new ArrayList<Jitem>(types.size());
        for (int i = 0; i < types.size(); ++i) {
            arr.add(Jitem.makeString(PathPart.makeRight(i), types.get(i).name().toLowerCase()));
        }
        if (arr.size() == 1) {
            context.builder.addJitem(Jitem.makeString(PathPart.makeLeft(key), arr.get(0).getString()));
        } else {
            context.builder.addJitem(Jitem.makeArray(PathPart.makeLeft(key), arr));
        }
    }
}
