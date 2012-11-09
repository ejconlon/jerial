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

public interface SchemaRefable {

        Ref2<SchemaContainer,Boolean> getAdditionalItemsRef();

        Ref2<SchemaContainer,Boolean> getAdditionalPropertiesRef();

        Ref<String> getDescriptionRef();

        Ref3<String,List<Ref2<String,SchemaContainer>>,SchemaContainer> getDisallowRef();

        Ref<List<Ref<JThing>>> getEnumFieldRef();

        Ref<Double> getExclusiveMaximumRef();

        Ref<Double> getExclusiveMinimumRef();

        Ref2<SchemaContainer,List<Ref<SchemaContainer>>> getExtendsFieldRef();

        Ref<String> getFormatRef();

        Ref2<SchemaContainer,List<Ref<SchemaContainer>>> getItemsRef();

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

        Ref2<String,SchemaContainer> getRequiresRef();

        Ref<String> getTitleRef();

        Ref2<String,List<Ref2<String,SchemaContainer>>> getTypeRef();

        Ref<Boolean> getUniqueItemsRef();

}
