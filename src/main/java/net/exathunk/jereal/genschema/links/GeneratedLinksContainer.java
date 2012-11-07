package net.exathunk.jereal.genschema.links;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchemaContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedLinksContainer {

    private final Ref<String> enctype;
    private final Ref<String> href;
    private final Ref<String> method;
    private final Ref<JThing> properties;
    private final Ref<String> rel;
    private final Ref<GeneratedHyperSchemaContainer> targetSchema;

    public GeneratedLinksContainer() {
        enctype = new RefImpl<String>();
        href = new RefImpl<String>();
        method = new RefImpl<String>();
        properties = new RefImpl<JThing>();
        rel = new RefImpl<String>();
        targetSchema = new RefImpl<GeneratedHyperSchemaContainer>();
    }

    public boolean hasEnctype() {
        return !enctype.isEmptyRef();
    }
    public String getEnctype() {
        return enctype.getRef();
    }
    public void setEnctype(String value) {
        enctype.setRef(value);
    }
    public Ref<String> getEnctypeRef() {
        return enctype;
    }

    public boolean hasHref() {
        return !href.isEmptyRef();
    }
    public String getHref() {
        return href.getRef();
    }
    public void setHref(String value) {
        href.setRef(value);
    }
    public Ref<String> getHrefRef() {
        return href;
    }

    public boolean hasMethod() {
        return !method.isEmptyRef();
    }
    public String getMethod() {
        return method.getRef();
    }
    public void setMethod(String value) {
        method.setRef(value);
    }
    public Ref<String> getMethodRef() {
        return method;
    }

    public boolean hasProperties() {
        return !properties.isEmptyRef();
    }
    public JThing getProperties() {
        return properties.getRef();
    }
    public void setProperties(JThing value) {
        properties.setRef(value);
    }
    public Ref<JThing> getPropertiesRef() {
        return properties;
    }

    public boolean hasRel() {
        return !rel.isEmptyRef();
    }
    public String getRel() {
        return rel.getRef();
    }
    public void setRel(String value) {
        rel.setRef(value);
    }
    public Ref<String> getRelRef() {
        return rel;
    }

    public boolean hasTargetSchema() {
        return !targetSchema.isEmptyRef();
    }
    public GeneratedHyperSchemaContainer getTargetSchema() {
        return targetSchema.getRef();
    }
    public void setTargetSchema(GeneratedHyperSchemaContainer value) {
        targetSchema.setRef(value);
    }
    public Ref<GeneratedHyperSchemaContainer> getTargetSchemaRef() {
        return targetSchema;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedLinksContainer{ ");
        if (!enctype.isEmptyRef()) sb.append("enctype='").append(enctype).append("', ");
        if (!href.isEmptyRef()) sb.append("href='").append(href).append("', ");
        if (!method.isEmptyRef()) sb.append("method='").append(method).append("', ");
        if (!properties.isEmptyRef()) sb.append("properties='").append(properties).append("', ");
        if (!rel.isEmptyRef()) sb.append("rel='").append(rel).append("', ");
        if (!targetSchema.isEmptyRef()) sb.append("targetSchema='").append(targetSchema).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedLinksContainer) {
            GeneratedLinksContainer other = (GeneratedLinksContainer) o;
            if (hasEnctype()) {
                if (!other.hasEnctype()) return false;
                else if (!getEnctype().equals(other.getEnctype())) return false;
            } else if (other.hasEnctype()) return false;
            if (hasHref()) {
                if (!other.hasHref()) return false;
                else if (!getHref().equals(other.getHref())) return false;
            } else if (other.hasHref()) return false;
            if (hasMethod()) {
                if (!other.hasMethod()) return false;
                else if (!getMethod().equals(other.getMethod())) return false;
            } else if (other.hasMethod()) return false;
            if (hasProperties()) {
                if (!other.hasProperties()) return false;
                else if (!getProperties().equals(other.getProperties())) return false;
            } else if (other.hasProperties()) return false;
            if (hasRel()) {
                if (!other.hasRel()) return false;
                else if (!getRel().equals(other.getRel())) return false;
            } else if (other.hasRel()) return false;
            if (hasTargetSchema()) {
                if (!other.hasTargetSchema()) return false;
                else if (!getTargetSchema().equals(other.getTargetSchema())) return false;
            } else if (other.hasTargetSchema()) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + enctype.hashCode();
        result = 31 * result + href.hashCode();
        result = 31 * result + method.hashCode();
        result = 31 * result + properties.hashCode();
        result = 31 * result + rel.hashCode();
        result = 31 * result + targetSchema.hashCode();
        return result;
    }

}
