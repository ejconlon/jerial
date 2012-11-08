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
import net.exathunk.jereal.genschema.schema.SchemaContainer;

public interface SchemaRefable {

        Ref<Any2<SchemaContainer,Boolean>> getAdditionalItemsRef();

        Ref<Any2<SchemaContainer,Boolean>> getAdditionalPropertiesRef();

        Ref<String> getDescriptionRef();

        Ref<Any3<String,List<Any2<String,SchemaContainer>>,SchemaContainer>> getDisallowRef();

        Ref<List<JThing>> getEnumFieldRef();

        Ref<Double> getExclusiveMaximumRef();

        Ref<Double> getExclusiveMinimumRef();

        Ref<Any2<SchemaContainer,List<SchemaContainer>>> getExtendsFieldRef();

        Ref<String> getFormatRef();

        Ref<Any2<SchemaContainer,List<SchemaContainer>>> getItemsRef();

        Ref<Double> getMaxDecimalRef();

        Ref<Long> getMaxItemsRef();

        Ref<Long> getMaxLengthRef();

        Ref<Double> getMaximumRef();

        Ref<Long> getMinItemsRef();

        Ref<Long> getMinLengthRef();

        Ref<Double> getMinimumRef();

        Ref<String> getPatternRef();

        Ref<SchemaContainer> getPropertiesRef();

        Ref<Boolean> getRequiredRef();

        Ref<Any2<String,SchemaContainer>> getRequiresRef();

        Ref<String> getTitleRef();

        Ref<Any2<String,List<Any2<String,SchemaContainer>>>> getTypeRef();

        Ref<Boolean> getUniqueItemsRef();

}
