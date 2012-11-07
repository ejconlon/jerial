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

public interface GeneratedSchemaRefable {

        Ref<Any2<GeneratedSchema,Boolean>> getAdditionalItemsRef();

        Ref<Any2<GeneratedSchema,Boolean>> getAdditionalPropertiesRef();

        Ref<String> getDescriptionRef();

        Ref<Any3<String,List<JThing>,GeneratedSchema>> getDisallowRef();

        Ref<List<JThing>> getEnumFieldRef();

        Ref<Double> getExclusiveMaximumRef();

        Ref<Double> getExclusiveMinimumRef();

        Ref<Any2<GeneratedSchema,List<JThing>>> getExtendsFieldRef();

        Ref<String> getFormatRef();

        Ref<Any2<GeneratedSchema,List<JThing>>> getItemsRef();

        Ref<Double> getMaxDecimalRef();

        Ref<Long> getMaxItemsRef();

        Ref<Long> getMaxLengthRef();

        Ref<Double> getMaximumRef();

        Ref<Long> getMinItemsRef();

        Ref<Long> getMinLengthRef();

        Ref<Double> getMinimumRef();

        Ref<String> getPatternRef();

        Ref<JThing> getPropertiesRef();

        Ref<Boolean> getRequiredRef();

        Ref<Any2<String,GeneratedSchema>> getRequiresRef();

        Ref<String> getTitleRef();

        Ref<Any2<String,List<JThing>>> getTypeRef();

        Ref<Boolean> getUniqueItemsRef();

}
