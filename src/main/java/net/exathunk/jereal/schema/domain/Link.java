package net.exathunk.jereal.schema.domain;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

import java.util.Map;

/**
 * charolastra 10/27/12 1:45 PM
 */
public class Link {
    public final Ref<String> rel = new RefImpl<String>();
    public final Ref<String> href = new RefImpl<String>();
    public final Ref<String> schema = new RefImpl<String>();
    public final Ref<String> targetSchema = new RefImpl<String>();
    public final Ref<String> enctype = new RefImpl<String>();
    public final Ref<String> method = new RefImpl<String>();
    public final Ref<Map<String, SchemaRef>> properties = new RefImpl<Map<String, SchemaRef>>();

    @Override
    public String toString() {
        return "Link{" +
                (!rel.isEmptyRef() ? "rel='" + rel + '\'' : "") +
                (!href.isEmptyRef() ? ", href='" + href + '\'' : "") +
                (!schema.isEmptyRef() ? ", schema='" + schema + '\'' : "") +
                (!targetSchema.isEmptyRef() ? ", targetSchema='" + targetSchema + '\'' : "") +
                (!enctype.isEmptyRef() ? ", enctype='" + enctype + '\'' : "") +
                (!method.isEmptyRef() ? ", method='" + method + '\'' : "") +
                (!properties.isEmptyRef() ? ", properties=" + properties : "") +
                '}';
    }
}
