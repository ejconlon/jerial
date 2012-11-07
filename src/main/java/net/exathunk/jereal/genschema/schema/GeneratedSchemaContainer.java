package net.exathunk.jereal.genschema.schema;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;
import net.exathunk.jereal.genschema.schema.GeneratedSchema;

public class GeneratedSchemaContainer {

    private final Ref<Any2<GeneratedSchema,Boolean>> additionalItems;
    private final Ref<Any2<GeneratedSchema,Boolean>> additionalProperties;
    private final Ref<String> description;
    private final Ref<Any3<String,List<Any2<String,GeneratedSchema>>,GeneratedSchema>> disallow;
    private final Ref<List<JThing>> enumField;
    private final Ref<Double> exclusiveMaximum;
    private final Ref<Double> exclusiveMinimum;
    private final Ref<Any2<GeneratedSchema,List<GeneratedSchema>>> extendsField;
    private final Ref<String> format;
    private final Ref<Any2<GeneratedSchema,List<GeneratedSchema>>> items;
    private final Ref<Double> maxDecimal;
    private final Ref<Long> maxItems;
    private final Ref<Long> maxLength;
    private final Ref<Double> maximum;
    private final Ref<Long> minItems;
    private final Ref<Long> minLength;
    private final Ref<Double> minimum;
    private final Ref<String> pattern;
    private final Ref<JThing> properties;
    private final Ref<Boolean> required;
    private final Ref<Any2<String,GeneratedSchema>> requires;
    private final Ref<String> title;
    private final Ref<Any2<String,List<Any2<String,GeneratedSchema>>>> type;
    private final Ref<Boolean> uniqueItems;

    public GeneratedSchemaContainer() {
        additionalItems = new RefImpl<Any2<GeneratedSchema,Boolean>>();
        additionalProperties = new RefImpl<Any2<GeneratedSchema,Boolean>>();
        description = new RefImpl<String>();
        disallow = new RefImpl<Any3<String,List<Any2<String,GeneratedSchema>>,GeneratedSchema>>();
        enumField = new RefImpl<List<JThing>>();
        exclusiveMaximum = new RefImpl<Double>();
        exclusiveMinimum = new RefImpl<Double>();
        extendsField = new RefImpl<Any2<GeneratedSchema,List<GeneratedSchema>>>();
        format = new RefImpl<String>();
        items = new RefImpl<Any2<GeneratedSchema,List<GeneratedSchema>>>();
        maxDecimal = new RefImpl<Double>();
        maxItems = new RefImpl<Long>();
        maxLength = new RefImpl<Long>();
        maximum = new RefImpl<Double>();
        minItems = new RefImpl<Long>();
        minLength = new RefImpl<Long>();
        minimum = new RefImpl<Double>();
        pattern = new RefImpl<String>();
        properties = new RefImpl<JThing>();
        required = new RefImpl<Boolean>();
        requires = new RefImpl<Any2<String,GeneratedSchema>>();
        title = new RefImpl<String>();
        type = new RefImpl<Any2<String,List<Any2<String,GeneratedSchema>>>>();
        uniqueItems = new RefImpl<Boolean>();
    }

    public boolean hasAdditionalItems() {
        return !additionalItems.isEmptyRef();
    }
    public Any2<GeneratedSchema,Boolean> getAdditionalItems() {
        return additionalItems.getRef();
    }
    public void setAdditionalItems(Any2<GeneratedSchema,Boolean> value) {
        additionalItems.setRef(value);
    }
    public Ref<Any2<GeneratedSchema,Boolean>> getAdditionalItemsRef() {
        return additionalItems;
    }

    public boolean hasAdditionalProperties() {
        return !additionalProperties.isEmptyRef();
    }
    public Any2<GeneratedSchema,Boolean> getAdditionalProperties() {
        return additionalProperties.getRef();
    }
    public void setAdditionalProperties(Any2<GeneratedSchema,Boolean> value) {
        additionalProperties.setRef(value);
    }
    public Ref<Any2<GeneratedSchema,Boolean>> getAdditionalPropertiesRef() {
        return additionalProperties;
    }

    public boolean hasDescription() {
        return !description.isEmptyRef();
    }
    public String getDescription() {
        return description.getRef();
    }
    public void setDescription(String value) {
        description.setRef(value);
    }
    public Ref<String> getDescriptionRef() {
        return description;
    }

    public boolean hasDisallow() {
        return !disallow.isEmptyRef();
    }
    public Any3<String,List<Any2<String,GeneratedSchema>>,GeneratedSchema> getDisallow() {
        return disallow.getRef();
    }
    public void setDisallow(Any3<String,List<Any2<String,GeneratedSchema>>,GeneratedSchema> value) {
        disallow.setRef(value);
    }
    public Ref<Any3<String,List<Any2<String,GeneratedSchema>>,GeneratedSchema>> getDisallowRef() {
        return disallow;
    }

    public boolean hasEnumField() {
        return !enumField.isEmptyRef();
    }
    public List<JThing> getEnumField() {
        return enumField.getRef();
    }
    public void setEnumField(List<JThing> value) {
        enumField.setRef(value);
    }
    public Ref<List<JThing>> getEnumFieldRef() {
        return enumField;
    }

    public boolean hasExclusiveMaximum() {
        return !exclusiveMaximum.isEmptyRef();
    }
    public Double getExclusiveMaximum() {
        return exclusiveMaximum.getRef();
    }
    public void setExclusiveMaximum(Double value) {
        exclusiveMaximum.setRef(value);
    }
    public Ref<Double> getExclusiveMaximumRef() {
        return exclusiveMaximum;
    }

    public boolean hasExclusiveMinimum() {
        return !exclusiveMinimum.isEmptyRef();
    }
    public Double getExclusiveMinimum() {
        return exclusiveMinimum.getRef();
    }
    public void setExclusiveMinimum(Double value) {
        exclusiveMinimum.setRef(value);
    }
    public Ref<Double> getExclusiveMinimumRef() {
        return exclusiveMinimum;
    }

    public boolean hasExtendsField() {
        return !extendsField.isEmptyRef();
    }
    public Any2<GeneratedSchema,List<GeneratedSchema>> getExtendsField() {
        return extendsField.getRef();
    }
    public void setExtendsField(Any2<GeneratedSchema,List<GeneratedSchema>> value) {
        extendsField.setRef(value);
    }
    public Ref<Any2<GeneratedSchema,List<GeneratedSchema>>> getExtendsFieldRef() {
        return extendsField;
    }

    public boolean hasFormat() {
        return !format.isEmptyRef();
    }
    public String getFormat() {
        return format.getRef();
    }
    public void setFormat(String value) {
        format.setRef(value);
    }
    public Ref<String> getFormatRef() {
        return format;
    }

    public boolean hasItems() {
        return !items.isEmptyRef();
    }
    public Any2<GeneratedSchema,List<GeneratedSchema>> getItems() {
        return items.getRef();
    }
    public void setItems(Any2<GeneratedSchema,List<GeneratedSchema>> value) {
        items.setRef(value);
    }
    public Ref<Any2<GeneratedSchema,List<GeneratedSchema>>> getItemsRef() {
        return items;
    }

    public boolean hasMaxDecimal() {
        return !maxDecimal.isEmptyRef();
    }
    public Double getMaxDecimal() {
        return maxDecimal.getRef();
    }
    public void setMaxDecimal(Double value) {
        maxDecimal.setRef(value);
    }
    public Ref<Double> getMaxDecimalRef() {
        return maxDecimal;
    }

    public boolean hasMaxItems() {
        return !maxItems.isEmptyRef();
    }
    public Long getMaxItems() {
        return maxItems.getRef();
    }
    public void setMaxItems(Long value) {
        maxItems.setRef(value);
    }
    public Ref<Long> getMaxItemsRef() {
        return maxItems;
    }

    public boolean hasMaxLength() {
        return !maxLength.isEmptyRef();
    }
    public Long getMaxLength() {
        return maxLength.getRef();
    }
    public void setMaxLength(Long value) {
        maxLength.setRef(value);
    }
    public Ref<Long> getMaxLengthRef() {
        return maxLength;
    }

    public boolean hasMaximum() {
        return !maximum.isEmptyRef();
    }
    public Double getMaximum() {
        return maximum.getRef();
    }
    public void setMaximum(Double value) {
        maximum.setRef(value);
    }
    public Ref<Double> getMaximumRef() {
        return maximum;
    }

    public boolean hasMinItems() {
        return !minItems.isEmptyRef();
    }
    public Long getMinItems() {
        return minItems.getRef();
    }
    public void setMinItems(Long value) {
        minItems.setRef(value);
    }
    public Ref<Long> getMinItemsRef() {
        return minItems;
    }

    public boolean hasMinLength() {
        return !minLength.isEmptyRef();
    }
    public Long getMinLength() {
        return minLength.getRef();
    }
    public void setMinLength(Long value) {
        minLength.setRef(value);
    }
    public Ref<Long> getMinLengthRef() {
        return minLength;
    }

    public boolean hasMinimum() {
        return !minimum.isEmptyRef();
    }
    public Double getMinimum() {
        return minimum.getRef();
    }
    public void setMinimum(Double value) {
        minimum.setRef(value);
    }
    public Ref<Double> getMinimumRef() {
        return minimum;
    }

    public boolean hasPattern() {
        return !pattern.isEmptyRef();
    }
    public String getPattern() {
        return pattern.getRef();
    }
    public void setPattern(String value) {
        pattern.setRef(value);
    }
    public Ref<String> getPatternRef() {
        return pattern;
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

    public boolean hasRequired() {
        return !required.isEmptyRef();
    }
    public Boolean getRequired() {
        return required.getRef();
    }
    public void setRequired(Boolean value) {
        required.setRef(value);
    }
    public Ref<Boolean> getRequiredRef() {
        return required;
    }

    public boolean hasRequires() {
        return !requires.isEmptyRef();
    }
    public Any2<String,GeneratedSchema> getRequires() {
        return requires.getRef();
    }
    public void setRequires(Any2<String,GeneratedSchema> value) {
        requires.setRef(value);
    }
    public Ref<Any2<String,GeneratedSchema>> getRequiresRef() {
        return requires;
    }

    public boolean hasTitle() {
        return !title.isEmptyRef();
    }
    public String getTitle() {
        return title.getRef();
    }
    public void setTitle(String value) {
        title.setRef(value);
    }
    public Ref<String> getTitleRef() {
        return title;
    }

    public boolean hasType() {
        return !type.isEmptyRef();
    }
    public Any2<String,List<Any2<String,GeneratedSchema>>> getType() {
        return type.getRef();
    }
    public void setType(Any2<String,List<Any2<String,GeneratedSchema>>> value) {
        type.setRef(value);
    }
    public Ref<Any2<String,List<Any2<String,GeneratedSchema>>>> getTypeRef() {
        return type;
    }

    public boolean hasUniqueItems() {
        return !uniqueItems.isEmptyRef();
    }
    public Boolean getUniqueItems() {
        return uniqueItems.getRef();
    }
    public void setUniqueItems(Boolean value) {
        uniqueItems.setRef(value);
    }
    public Ref<Boolean> getUniqueItemsRef() {
        return uniqueItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedSchemaContainer{ ");
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
        if (o instanceof GeneratedSchemaContainer) {
            GeneratedSchemaContainer other = (GeneratedSchemaContainer) o;
            if (hasAdditionalItems()) {
                if (!other.hasAdditionalItems()) return false;
                else if (!getAdditionalItems().equals(other.getAdditionalItems())) return false;
            } else if (other.hasAdditionalItems()) return false;
            if (hasAdditionalProperties()) {
                if (!other.hasAdditionalProperties()) return false;
                else if (!getAdditionalProperties().equals(other.getAdditionalProperties())) return false;
            } else if (other.hasAdditionalProperties()) return false;
            if (hasDescription()) {
                if (!other.hasDescription()) return false;
                else if (!getDescription().equals(other.getDescription())) return false;
            } else if (other.hasDescription()) return false;
            if (hasDisallow()) {
                if (!other.hasDisallow()) return false;
                else if (!getDisallow().equals(other.getDisallow())) return false;
            } else if (other.hasDisallow()) return false;
            if (hasEnumField()) {
                if (!other.hasEnumField()) return false;
                else if (!getEnumField().equals(other.getEnumField())) return false;
            } else if (other.hasEnumField()) return false;
            if (hasExclusiveMaximum()) {
                if (!other.hasExclusiveMaximum()) return false;
                else if (!getExclusiveMaximum().equals(other.getExclusiveMaximum())) return false;
            } else if (other.hasExclusiveMaximum()) return false;
            if (hasExclusiveMinimum()) {
                if (!other.hasExclusiveMinimum()) return false;
                else if (!getExclusiveMinimum().equals(other.getExclusiveMinimum())) return false;
            } else if (other.hasExclusiveMinimum()) return false;
            if (hasExtendsField()) {
                if (!other.hasExtendsField()) return false;
                else if (!getExtendsField().equals(other.getExtendsField())) return false;
            } else if (other.hasExtendsField()) return false;
            if (hasFormat()) {
                if (!other.hasFormat()) return false;
                else if (!getFormat().equals(other.getFormat())) return false;
            } else if (other.hasFormat()) return false;
            if (hasItems()) {
                if (!other.hasItems()) return false;
                else if (!getItems().equals(other.getItems())) return false;
            } else if (other.hasItems()) return false;
            if (hasMaxDecimal()) {
                if (!other.hasMaxDecimal()) return false;
                else if (!getMaxDecimal().equals(other.getMaxDecimal())) return false;
            } else if (other.hasMaxDecimal()) return false;
            if (hasMaxItems()) {
                if (!other.hasMaxItems()) return false;
                else if (!getMaxItems().equals(other.getMaxItems())) return false;
            } else if (other.hasMaxItems()) return false;
            if (hasMaxLength()) {
                if (!other.hasMaxLength()) return false;
                else if (!getMaxLength().equals(other.getMaxLength())) return false;
            } else if (other.hasMaxLength()) return false;
            if (hasMaximum()) {
                if (!other.hasMaximum()) return false;
                else if (!getMaximum().equals(other.getMaximum())) return false;
            } else if (other.hasMaximum()) return false;
            if (hasMinItems()) {
                if (!other.hasMinItems()) return false;
                else if (!getMinItems().equals(other.getMinItems())) return false;
            } else if (other.hasMinItems()) return false;
            if (hasMinLength()) {
                if (!other.hasMinLength()) return false;
                else if (!getMinLength().equals(other.getMinLength())) return false;
            } else if (other.hasMinLength()) return false;
            if (hasMinimum()) {
                if (!other.hasMinimum()) return false;
                else if (!getMinimum().equals(other.getMinimum())) return false;
            } else if (other.hasMinimum()) return false;
            if (hasPattern()) {
                if (!other.hasPattern()) return false;
                else if (!getPattern().equals(other.getPattern())) return false;
            } else if (other.hasPattern()) return false;
            if (hasProperties()) {
                if (!other.hasProperties()) return false;
                else if (!getProperties().equals(other.getProperties())) return false;
            } else if (other.hasProperties()) return false;
            if (hasRequired()) {
                if (!other.hasRequired()) return false;
                else if (!getRequired().equals(other.getRequired())) return false;
            } else if (other.hasRequired()) return false;
            if (hasRequires()) {
                if (!other.hasRequires()) return false;
                else if (!getRequires().equals(other.getRequires())) return false;
            } else if (other.hasRequires()) return false;
            if (hasTitle()) {
                if (!other.hasTitle()) return false;
                else if (!getTitle().equals(other.getTitle())) return false;
            } else if (other.hasTitle()) return false;
            if (hasType()) {
                if (!other.hasType()) return false;
                else if (!getType().equals(other.getType())) return false;
            } else if (other.hasType()) return false;
            if (hasUniqueItems()) {
                if (!other.hasUniqueItems()) return false;
                else if (!getUniqueItems().equals(other.getUniqueItems())) return false;
            } else if (other.hasUniqueItems()) return false;
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
