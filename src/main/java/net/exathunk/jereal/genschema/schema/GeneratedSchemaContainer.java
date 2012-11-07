package net.exathunk.jereal.genschema.schema;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;
import net.exathunk.jereal.genschema.schema.GeneratedSchema;

public class GeneratedSchemaContainer {

    private final Ref<List<JThing>> arrayValue;
    private final Ref<Boolean> booleanValue;
    private final Ref<Double> doubleValue;
    private final Ref<GeneratedLinksContainer> links;
    private final Ref<Long> longValue;
    private final Ref<GeneratedSchema> objectValue;
    private final Ref<String> stringValue;

    public GeneratedSchemaContainer() {
        arrayValue = new RefImpl<List<JThing>>();
        booleanValue = new RefImpl<Boolean>();
        doubleValue = new RefImpl<Double>();
        links = new RefImpl<GeneratedLinksContainer>();
        longValue = new RefImpl<Long>();
        objectValue = new RefImpl<GeneratedSchema>();
        stringValue = new RefImpl<String>();
    }

    public boolean hasArrayValue() {
        return !arrayValue.isEmptyRef();
    }
    public List<JThing> getArrayValue() {
        return arrayValue.getRef();
    }
    public void setArrayValue(List<JThing> value) {
        arrayValue.setRef(value);
    }
    public Ref<List<JThing>> getArrayValueRef() {
        return arrayValue;
    }

    public boolean hasBooleanValue() {
        return !booleanValue.isEmptyRef();
    }
    public Boolean getBooleanValue() {
        return booleanValue.getRef();
    }
    public void setBooleanValue(Boolean value) {
        booleanValue.setRef(value);
    }
    public Ref<Boolean> getBooleanValueRef() {
        return booleanValue;
    }

    public boolean hasDoubleValue() {
        return !doubleValue.isEmptyRef();
    }
    public Double getDoubleValue() {
        return doubleValue.getRef();
    }
    public void setDoubleValue(Double value) {
        doubleValue.setRef(value);
    }
    public Ref<Double> getDoubleValueRef() {
        return doubleValue;
    }

    public boolean hasLinks() {
        return !links.isEmptyRef();
    }
    public GeneratedLinksContainer getLinks() {
        return links.getRef();
    }
    public void setLinks(GeneratedLinksContainer value) {
        links.setRef(value);
    }
    public Ref<GeneratedLinksContainer> getLinksRef() {
        return links;
    }

    public boolean hasLongValue() {
        return !longValue.isEmptyRef();
    }
    public Long getLongValue() {
        return longValue.getRef();
    }
    public void setLongValue(Long value) {
        longValue.setRef(value);
    }
    public Ref<Long> getLongValueRef() {
        return longValue;
    }

    public boolean hasObjectValue() {
        return !objectValue.isEmptyRef();
    }
    public GeneratedSchema getObjectValue() {
        return objectValue.getRef();
    }
    public void setObjectValue(GeneratedSchema value) {
        objectValue.setRef(value);
    }
    public Ref<GeneratedSchema> getObjectValueRef() {
        return objectValue;
    }

    public boolean hasStringValue() {
        return !stringValue.isEmptyRef();
    }
    public String getStringValue() {
        return stringValue.getRef();
    }
    public void setStringValue(String value) {
        stringValue.setRef(value);
    }
    public Ref<String> getStringValueRef() {
        return stringValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedSchemaContainer{ ");
        if (!arrayValue.isEmptyRef()) sb.append("arrayValue='").append(arrayValue).append("', ");
        if (!booleanValue.isEmptyRef()) sb.append("booleanValue='").append(booleanValue).append("', ");
        if (!doubleValue.isEmptyRef()) sb.append("doubleValue='").append(doubleValue).append("', ");
        if (!links.isEmptyRef()) sb.append("links='").append(links).append("', ");
        if (!longValue.isEmptyRef()) sb.append("longValue='").append(longValue).append("', ");
        if (!objectValue.isEmptyRef()) sb.append("objectValue='").append(objectValue).append("', ");
        if (!stringValue.isEmptyRef()) sb.append("stringValue='").append(stringValue).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedSchemaContainer) {
            GeneratedSchemaContainer other = (GeneratedSchemaContainer) o;
            if (hasArrayValue()) {
                if (!other.hasArrayValue()) return false;
                else if (!getArrayValue().equals(other.getArrayValue())) return false;
            } else if (other.hasArrayValue()) return false;
            if (hasBooleanValue()) {
                if (!other.hasBooleanValue()) return false;
                else if (!getBooleanValue().equals(other.getBooleanValue())) return false;
            } else if (other.hasBooleanValue()) return false;
            if (hasDoubleValue()) {
                if (!other.hasDoubleValue()) return false;
                else if (!getDoubleValue().equals(other.getDoubleValue())) return false;
            } else if (other.hasDoubleValue()) return false;
            if (hasLinks()) {
                if (!other.hasLinks()) return false;
                else if (!getLinks().equals(other.getLinks())) return false;
            } else if (other.hasLinks()) return false;
            if (hasLongValue()) {
                if (!other.hasLongValue()) return false;
                else if (!getLongValue().equals(other.getLongValue())) return false;
            } else if (other.hasLongValue()) return false;
            if (hasObjectValue()) {
                if (!other.hasObjectValue()) return false;
                else if (!getObjectValue().equals(other.getObjectValue())) return false;
            } else if (other.hasObjectValue()) return false;
            if (hasStringValue()) {
                if (!other.hasStringValue()) return false;
                else if (!getStringValue().equals(other.getStringValue())) return false;
            } else if (other.hasStringValue()) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + arrayValue.hashCode();
        result = 31 * result + booleanValue.hashCode();
        result = 31 * result + doubleValue.hashCode();
        result = 31 * result + links.hashCode();
        result = 31 * result + longValue.hashCode();
        result = 31 * result + objectValue.hashCode();
        result = 31 * result + stringValue.hashCode();
        return result;
    }

}
