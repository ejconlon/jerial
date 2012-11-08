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
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.schema.SchemaContainer;

public interface SchemaLike {

        boolean hasAdditionalItems();
        boolean hasAdditionalProperties();
        boolean hasDescription();
        String getDescription();
        void setDescription(String value);

        boolean hasDisallow();
        boolean hasEnumField();
        List<Ref<JThing>> getEnumField();
        void setEnumField(List<Ref<JThing>> value);

        boolean hasExclusiveMaximum();
        Double getExclusiveMaximum();
        void setExclusiveMaximum(Double value);

        boolean hasExclusiveMinimum();
        Double getExclusiveMinimum();
        void setExclusiveMinimum(Double value);

        boolean hasExtendsField();
        boolean hasFormat();
        String getFormat();
        void setFormat(String value);

        boolean hasItems();
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
        SchemaContainer getProperties();
        void setProperties(SchemaContainer value);

        boolean hasRequired();
        Boolean getRequired();
        void setRequired(Boolean value);

        boolean hasRequires();
        boolean hasTitle();
        String getTitle();
        void setTitle(String value);

        boolean hasType();
        boolean hasUniqueItems();
        Boolean getUniqueItems();
        void setUniqueItems(Boolean value);

}
