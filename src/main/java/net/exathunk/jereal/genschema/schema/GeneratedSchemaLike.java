package net.exathunk.jereal.genschema.schema;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.schema.GeneratedSchema;

public interface GeneratedSchemaLike {

        boolean hasAdditionalItems();
        Any2<GeneratedSchema,Boolean> getAdditionalItems();
        void setAdditionalItems(Any2<GeneratedSchema,Boolean> value);

        boolean hasAdditionalProperties();
        Any2<GeneratedSchema,Boolean> getAdditionalProperties();
        void setAdditionalProperties(Any2<GeneratedSchema,Boolean> value);

        boolean hasDescription();
        String getDescription();
        void setDescription(String value);

        boolean hasDisallow();
        Any3<String,List<Any2<String,GeneratedSchema>>,GeneratedSchema> getDisallow();
        void setDisallow(Any3<String,List<Any2<String,GeneratedSchema>>,GeneratedSchema> value);

        boolean hasEnumField();
        List<JThing> getEnumField();
        void setEnumField(List<JThing> value);

        boolean hasExclusiveMaximum();
        Double getExclusiveMaximum();
        void setExclusiveMaximum(Double value);

        boolean hasExclusiveMinimum();
        Double getExclusiveMinimum();
        void setExclusiveMinimum(Double value);

        boolean hasExtendsField();
        Any2<GeneratedSchema,List<GeneratedSchema>> getExtendsField();
        void setExtendsField(Any2<GeneratedSchema,List<GeneratedSchema>> value);

        boolean hasFormat();
        String getFormat();
        void setFormat(String value);

        boolean hasItems();
        Any2<GeneratedSchema,List<GeneratedSchema>> getItems();
        void setItems(Any2<GeneratedSchema,List<GeneratedSchema>> value);

        boolean hasMaxDecimal();
        Double getMaxDecimal();
        void setMaxDecimal(Double value);

        boolean hasMaxItems();
        Long getMaxItems();
        void setMaxItems(Long value);

        boolean hasMaxLength();
        Long getMaxLength();
        void setMaxLength(Long value);

        boolean hasMaximum();
        Double getMaximum();
        void setMaximum(Double value);

        boolean hasMinItems();
        Long getMinItems();
        void setMinItems(Long value);

        boolean hasMinLength();
        Long getMinLength();
        void setMinLength(Long value);

        boolean hasMinimum();
        Double getMinimum();
        void setMinimum(Double value);

        boolean hasPattern();
        String getPattern();
        void setPattern(String value);

        boolean hasProperties();
        GeneratedSchema getProperties();
        void setProperties(GeneratedSchema value);

        boolean hasRequired();
        Boolean getRequired();
        void setRequired(Boolean value);

        boolean hasRequires();
        Any2<String,GeneratedSchema> getRequires();
        void setRequires(Any2<String,GeneratedSchema> value);

        boolean hasTitle();
        String getTitle();
        void setTitle(String value);

        boolean hasType();
        Any2<String,List<Any2<String,GeneratedSchema>>> getType();
        void setType(Any2<String,List<Any2<String,GeneratedSchema>>> value);

        boolean hasUniqueItems();
        Boolean getUniqueItems();
        void setUniqueItems(Boolean value);

}
