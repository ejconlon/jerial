package net.exathunk.jereal.genschema.schema;

import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.*;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.schema.*;

public class Schema implements SchemaLike, SchemaRefable {

    private final Ref2<SchemaContainer,Boolean> additionalItems;
    private final Ref2<SchemaContainer,Boolean> additionalProperties;
    private final Ref<String> description;
    private final Ref3<String,List<Ref2<String,SchemaContainer>>,SchemaContainer> disallow;
    private final Ref<List<Ref<JThing>>> enumField;
    private final Ref<Double> exclusiveMaximum;
    private final Ref<Double> exclusiveMinimum;
    private final Ref2<SchemaContainer,List<Ref<SchemaContainer>>> extendsField;
    private final Ref<String> format;
    private final Ref2<SchemaContainer,List<Ref<SchemaContainer>>> items;
    private final Ref<Double> maxDecimal;
    private final Ref<Long> maxItems;
    private final Ref<Long> maxLength;
    private final Ref<Double> maximum;
    private final Ref<Long> minItems;
    private final Ref<Long> minLength;
    private final Ref<Double> minimum;
    private final Ref<String> pattern;
    private final Ref<SchemaContainer> properties;
    private final Ref<Boolean> required;
    private final Ref2<String,SchemaContainer> requires;
    private final Ref<String> title;
    private final Ref2<String,List<Ref2<String,SchemaContainer>>> type;
    private final Ref<Boolean> uniqueItems;

    public Schema() {
        additionalItems = new Ref2<SchemaContainer,Boolean>();
        additionalProperties = new Ref2<SchemaContainer,Boolean>();
        description = new RefImpl<String>();
        disallow = new Ref3<String,List<Ref2<String,SchemaContainer>>,SchemaContainer>();
        enumField = new RefImpl<List<Ref<JThing>>>();
        exclusiveMaximum = new RefImpl<Double>();
        exclusiveMinimum = new RefImpl<Double>();
        extendsField = new Ref2<SchemaContainer,List<Ref<SchemaContainer>>>();
        format = new RefImpl<String>();
        items = new Ref2<SchemaContainer,List<Ref<SchemaContainer>>>();
        maxDecimal = new RefImpl<Double>();
        maxItems = new RefImpl<Long>();
        maxLength = new RefImpl<Long>();
        maximum = new RefImpl<Double>();
        minItems = new RefImpl<Long>();
        minLength = new RefImpl<Long>();
        minimum = new RefImpl<Double>();
        pattern = new RefImpl<String>();
        properties = new RefImpl<SchemaContainer>();
        required = new RefImpl<Boolean>();
        requires = new Ref2<String,SchemaContainer>();
        title = new RefImpl<String>();
        type = new Ref2<String,List<Ref2<String,SchemaContainer>>>();
        uniqueItems = new RefImpl<Boolean>();
    }

    @Override
    public boolean hasAdditionalItems() {
        return !additionalItems.isEmptyRef();
    }
    @Override
    public Ref2<SchemaContainer,Boolean> getAdditionalItemsRef() {
        return additionalItems;
    }

    @Override
    public boolean hasAdditionalProperties() {
        return !additionalProperties.isEmptyRef();
    }
    @Override
    public Ref2<SchemaContainer,Boolean> getAdditionalPropertiesRef() {
        return additionalProperties;
    }

    @Override
    public boolean hasDescription() {
        return !description.isEmptyRef();
    }
    @Override
    public String getDescription() {
        return description.getRef();
    }
    @Override
    public void setDescription(String value) {
        description.setRef(value);
    }
    @Override
    public Ref<String> getDescriptionRef() {
        return description;
    }

    @Override
    public boolean hasDisallow() {
        return !disallow.isEmptyRef();
    }
    @Override
    public Ref3<String,List<Ref2<String,SchemaContainer>>,SchemaContainer> getDisallowRef() {
        return disallow;
    }

    @Override
    public boolean hasEnumField() {
        return !enumField.isEmptyRef();
    }
    @Override
    public List<Ref<JThing>> getEnumField() {
        return enumField.getRef();
    }
    @Override
    public void setEnumField(List<Ref<JThing>> value) {
        enumField.setRef(value);
    }
    @Override
    public Ref<List<Ref<JThing>>> getEnumFieldRef() {
        return enumField;
    }

    @Override
    public boolean hasExclusiveMaximum() {
        return !exclusiveMaximum.isEmptyRef();
    }
    @Override
    public Double getExclusiveMaximum() {
        return exclusiveMaximum.getRef();
    }
    @Override
    public void setExclusiveMaximum(Double value) {
        exclusiveMaximum.setRef(value);
    }
    @Override
    public Ref<Double> getExclusiveMaximumRef() {
        return exclusiveMaximum;
    }

    @Override
    public boolean hasExclusiveMinimum() {
        return !exclusiveMinimum.isEmptyRef();
    }
    @Override
    public Double getExclusiveMinimum() {
        return exclusiveMinimum.getRef();
    }
    @Override
    public void setExclusiveMinimum(Double value) {
        exclusiveMinimum.setRef(value);
    }
    @Override
    public Ref<Double> getExclusiveMinimumRef() {
        return exclusiveMinimum;
    }

    @Override
    public boolean hasExtendsField() {
        return !extendsField.isEmptyRef();
    }
    @Override
    public Ref2<SchemaContainer,List<Ref<SchemaContainer>>> getExtendsFieldRef() {
        return extendsField;
    }

    @Override
    public boolean hasFormat() {
        return !format.isEmptyRef();
    }
    @Override
    public String getFormat() {
        return format.getRef();
    }
    @Override
    public void setFormat(String value) {
        format.setRef(value);
    }
    @Override
    public Ref<String> getFormatRef() {
        return format;
    }

    @Override
    public boolean hasItems() {
        return !items.isEmptyRef();
    }
    @Override
    public Ref2<SchemaContainer,List<Ref<SchemaContainer>>> getItemsRef() {
        return items;
    }

    @Override
    public boolean hasMaxDecimal() {
        return !maxDecimal.isEmptyRef();
    }
    @Override
    public Double getMaxDecimal() {
        return maxDecimal.getRef();
    }
    @Override
    public void setMaxDecimal(Double value) {
        maxDecimal.setRef(value);
    }
    @Override
    public Ref<Double> getMaxDecimalRef() {
        return maxDecimal;
    }

    @Override
    public boolean hasMaxItems() {
        return !maxItems.isEmptyRef();
    }
    @Override
    public Long getMaxItems() {
        return maxItems.getRef();
    }
    @Override
    public void setMaxItems(Long value) {
        maxItems.setRef(value);
    }
    @Override
    public Ref<Long> getMaxItemsRef() {
        return maxItems;
    }

    @Override
    public boolean hasMaxLength() {
        return !maxLength.isEmptyRef();
    }
    @Override
    public Long getMaxLength() {
        return maxLength.getRef();
    }
    @Override
    public void setMaxLength(Long value) {
        maxLength.setRef(value);
    }
    @Override
    public Ref<Long> getMaxLengthRef() {
        return maxLength;
    }

    @Override
    public boolean hasMaximum() {
        return !maximum.isEmptyRef();
    }
    @Override
    public Double getMaximum() {
        return maximum.getRef();
    }
    @Override
    public void setMaximum(Double value) {
        maximum.setRef(value);
    }
    @Override
    public Ref<Double> getMaximumRef() {
        return maximum;
    }

    @Override
    public boolean hasMinItems() {
        return !minItems.isEmptyRef();
    }
    @Override
    public Long getMinItems() {
        return minItems.getRef();
    }
    @Override
    public void setMinItems(Long value) {
        minItems.setRef(value);
    }
    @Override
    public Ref<Long> getMinItemsRef() {
        return minItems;
    }

    @Override
    public boolean hasMinLength() {
        return !minLength.isEmptyRef();
    }
    @Override
    public Long getMinLength() {
        return minLength.getRef();
    }
    @Override
    public void setMinLength(Long value) {
        minLength.setRef(value);
    }
    @Override
    public Ref<Long> getMinLengthRef() {
        return minLength;
    }

    @Override
    public boolean hasMinimum() {
        return !minimum.isEmptyRef();
    }
    @Override
    public Double getMinimum() {
        return minimum.getRef();
    }
    @Override
    public void setMinimum(Double value) {
        minimum.setRef(value);
    }
    @Override
    public Ref<Double> getMinimumRef() {
        return minimum;
    }

    @Override
    public boolean hasPattern() {
        return !pattern.isEmptyRef();
    }
    @Override
    public String getPattern() {
        return pattern.getRef();
    }
    @Override
    public void setPattern(String value) {
        pattern.setRef(value);
    }
    @Override
    public Ref<String> getPatternRef() {
        return pattern;
    }

    @Override
    public boolean hasProperties() {
        return !properties.isEmptyRef();
    }
    @Override
    public SchemaContainer getProperties() {
        return properties.getRef();
    }
    @Override
    public void setProperties(SchemaContainer value) {
        properties.setRef(value);
    }
    @Override
    public Ref<SchemaContainer> getPropertiesRef() {
        return properties;
    }

    @Override
    public boolean hasRequired() {
        return !required.isEmptyRef();
    }
    @Override
    public Boolean getRequired() {
        return required.getRef();
    }
    @Override
    public void setRequired(Boolean value) {
        required.setRef(value);
    }
    @Override
    public Ref<Boolean> getRequiredRef() {
        return required;
    }

    @Override
    public boolean hasRequires() {
        return !requires.isEmptyRef();
    }
    @Override
    public Ref2<String,SchemaContainer> getRequiresRef() {
        return requires;
    }

    @Override
    public boolean hasTitle() {
        return !title.isEmptyRef();
    }
    @Override
    public String getTitle() {
        return title.getRef();
    }
    @Override
    public void setTitle(String value) {
        title.setRef(value);
    }
    @Override
    public Ref<String> getTitleRef() {
        return title;
    }

    @Override
    public boolean hasType() {
        return !type.isEmptyRef();
    }
    @Override
    public Ref2<String,List<Ref2<String,SchemaContainer>>> getTypeRef() {
        return type;
    }

    @Override
    public boolean hasUniqueItems() {
        return !uniqueItems.isEmptyRef();
    }
    @Override
    public Boolean getUniqueItems() {
        return uniqueItems.getRef();
    }
    @Override
    public void setUniqueItems(Boolean value) {
        uniqueItems.setRef(value);
    }
    @Override
    public Ref<Boolean> getUniqueItemsRef() {
        return uniqueItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Schema{ ");
        if (!additionalItems.isEmptyRef()) sb.append("additionalItems='").append(additionalItems).append("', ");
        if (!additionalProperties.isEmptyRef()) sb.append("additionalProperties='").append(additionalProperties).append("', ");
        if (!description.isEmptyRef()) sb.append("description='").append(description).append("', ");
        if (!disallow.isEmptyRef()) sb.append("disallow='").append(disallow).append("', ");
        if (!enumField.isEmptyRef()) sb.append("enumField='").append(enumField).append("', ");
        if (!exclusiveMaximum.isEmptyRef()) sb.append("exclusiveMaximum='").append(exclusiveMaximum).append("', ");
        if (!exclusiveMinimum.isEmptyRef()) sb.append("exclusiveMinimum='").append(exclusiveMinimum).append("', ");
        if (!extendsField.isEmptyRef()) sb.append("extendsField='").append(extendsField).append("', ");
        if (!format.isEmptyRef()) sb.append("format='").append(format).append("', ");
        if (!items.isEmptyRef()) sb.append("items='").append(items).append("', ");
        if (!maxDecimal.isEmptyRef()) sb.append("maxDecimal='").append(maxDecimal).append("', ");
        if (!maxItems.isEmptyRef()) sb.append("maxItems='").append(maxItems).append("', ");
        if (!maxLength.isEmptyRef()) sb.append("maxLength='").append(maxLength).append("', ");
        if (!maximum.isEmptyRef()) sb.append("maximum='").append(maximum).append("', ");
        if (!minItems.isEmptyRef()) sb.append("minItems='").append(minItems).append("', ");
        if (!minLength.isEmptyRef()) sb.append("minLength='").append(minLength).append("', ");
        if (!minimum.isEmptyRef()) sb.append("minimum='").append(minimum).append("', ");
        if (!pattern.isEmptyRef()) sb.append("pattern='").append(pattern).append("', ");
        if (!properties.isEmptyRef()) sb.append("properties='").append(properties).append("', ");
        if (!required.isEmptyRef()) sb.append("required='").append(required).append("', ");
        if (!requires.isEmptyRef()) sb.append("requires='").append(requires).append("', ");
        if (!title.isEmptyRef()) sb.append("title='").append(title).append("', ");
        if (!type.isEmptyRef()) sb.append("type='").append(type).append("', ");
        if (!uniqueItems.isEmptyRef()) sb.append("uniqueItems='").append(uniqueItems).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof SchemaRefable) {
            SchemaRefable other = (SchemaRefable) o;
            if (!getAdditionalItemsRef().equals(other.getAdditionalItemsRef())) return false;
            if (!getAdditionalPropertiesRef().equals(other.getAdditionalPropertiesRef())) return false;
            if (!getDescriptionRef().equals(other.getDescriptionRef())) return false;
            if (!getDisallowRef().equals(other.getDisallowRef())) return false;
            if (!getEnumFieldRef().equals(other.getEnumFieldRef())) return false;
            if (!getExclusiveMaximumRef().equals(other.getExclusiveMaximumRef())) return false;
            if (!getExclusiveMinimumRef().equals(other.getExclusiveMinimumRef())) return false;
            if (!getExtendsFieldRef().equals(other.getExtendsFieldRef())) return false;
            if (!getFormatRef().equals(other.getFormatRef())) return false;
            if (!getItemsRef().equals(other.getItemsRef())) return false;
            if (!getMaxDecimalRef().equals(other.getMaxDecimalRef())) return false;
            if (!getMaxItemsRef().equals(other.getMaxItemsRef())) return false;
            if (!getMaxLengthRef().equals(other.getMaxLengthRef())) return false;
            if (!getMaximumRef().equals(other.getMaximumRef())) return false;
            if (!getMinItemsRef().equals(other.getMinItemsRef())) return false;
            if (!getMinLengthRef().equals(other.getMinLengthRef())) return false;
            if (!getMinimumRef().equals(other.getMinimumRef())) return false;
            if (!getPatternRef().equals(other.getPatternRef())) return false;
            if (!getPropertiesRef().equals(other.getPropertiesRef())) return false;
            if (!getRequiredRef().equals(other.getRequiredRef())) return false;
            if (!getRequiresRef().equals(other.getRequiresRef())) return false;
            if (!getTitleRef().equals(other.getTitleRef())) return false;
            if (!getTypeRef().equals(other.getTypeRef())) return false;
            if (!getUniqueItemsRef().equals(other.getUniqueItemsRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + additionalItems.hashCode();
        result = 31 * result + additionalProperties.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + disallow.hashCode();
        result = 31 * result + enumField.hashCode();
        result = 31 * result + exclusiveMaximum.hashCode();
        result = 31 * result + exclusiveMinimum.hashCode();
        result = 31 * result + extendsField.hashCode();
        result = 31 * result + format.hashCode();
        result = 31 * result + items.hashCode();
        result = 31 * result + maxDecimal.hashCode();
        result = 31 * result + maxItems.hashCode();
        result = 31 * result + maxLength.hashCode();
        result = 31 * result + maximum.hashCode();
        result = 31 * result + minItems.hashCode();
        result = 31 * result + minLength.hashCode();
        result = 31 * result + minimum.hashCode();
        result = 31 * result + pattern.hashCode();
        result = 31 * result + properties.hashCode();
        result = 31 * result + required.hashCode();
        result = 31 * result + requires.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + uniqueItems.hashCode();
        return result;
    }

}
