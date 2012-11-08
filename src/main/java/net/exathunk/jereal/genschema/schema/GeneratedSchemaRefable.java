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
import net.exathunk.jereal.genschema.schema.GeneratedSchemaContainer;

public interface GeneratedSchemaRefable {

        Ref<Any2<GeneratedSchemaContainer,Boolean>> getAdditionalItemsRef();

        Ref<Any2<GeneratedSchemaContainer,Boolean>> getAdditionalPropertiesRef();

        Ref<String> getDescriptionRef();

        Ref<Any3<String,List<Any2<String,GeneratedSchemaContainer>>,GeneratedSchemaContainer>> getDisallowRef();

        Ref<List<JThing>> getEnumFieldRef();

        Ref<Double> getExclusiveMaximumRef();

        Ref<Double> getExclusiveMinimumRef();

        Ref<Any2<GeneratedSchemaContainer,List<GeneratedSchemaContainer>>> getExtendsFieldRef();

        Ref<String> getFormatRef();

        Ref<Any2<GeneratedSchemaContainer,List<GeneratedSchemaContainer>>> getItemsRef();

        Ref<Double> getMaxDecimalRef();

        Ref<Long> getMaxItemsRef();

        Ref<Long> getMaxLengthRef();

        Ref<Double> getMaximumRef();

        Ref<Long> getMinItemsRef();

        Ref<Long> getMinLengthRef();

        Ref<Double> getMinimumRef();

        Ref<String> getPatternRef();

        Ref<GeneratedSchemaContainer> getPropertiesRef();

        Ref<Boolean> getRequiredRef();

        Ref<Any2<String,GeneratedSchemaContainer>> getRequiresRef();

        Ref<String> getTitleRef();

        Ref<Any2<String,List<Any2<String,GeneratedSchemaContainer>>>> getTypeRef();

        Ref<Boolean> getUniqueItemsRef();

}
