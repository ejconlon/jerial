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
    public final Ref<Map<String, Ref<SchemaRef>>> properties = new RefImpl<Map<String, Ref<SchemaRef>>>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;

        Link link = (Link) o;

        if (!enctype.equals(link.enctype)) return false;
        if (!href.equals(link.href)) return false;
        if (!method.equals(link.method)) return false;
        if (!properties.equals(link.properties)) return false;
        if (!rel.equals(link.rel)) return false;
        if (!schema.equals(link.schema)) return false;
        if (!targetSchema.equals(link.targetSchema)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rel.hashCode();
        result = 31 * result + href.hashCode();
        result = 31 * result + schema.hashCode();
        result = 31 * result + targetSchema.hashCode();
        result = 31 * result + enctype.hashCode();
        result = 31 * result + method.hashCode();
        result = 31 * result + properties.hashCode();
        return result;
    }
}
