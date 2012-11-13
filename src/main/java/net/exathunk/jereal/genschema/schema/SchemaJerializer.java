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

public class SchemaJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Schema> {

    @Override
    public Schema prototype(Speclike spec) {
        return new Schema();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Schema domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeCustom("additionalItems", new RefImpl(recurser.seeCustom(dsl, domain.getAdditionalItemsRef().getFirstRef(), SchemaContainer.class)));
        objectDSL.seeBoolean("additionalItems", domain.getAdditionalItemsRef().getSecondRef());
        objectDSL.seeCustom("additionalProperties", new RefImpl(recurser.seeCustom(dsl, domain.getAdditionalPropertiesRef().getFirstRef(), SchemaContainer.class)));
        objectDSL.seeBoolean("additionalProperties", domain.getAdditionalPropertiesRef().getSecondRef());
        objectDSL.seeString("description", domain.getDescriptionRef());
        objectDSL.seeString("disallow", domain.getDisallowRef().getFirstRef());
        objectDSL.seeList("disallow", new RefImpl(recurser.seeCustomRefList2(dsl, domain.getDisallowRef().getSecondRef(), String.class, SchemaContainer.class)));
        objectDSL.seeCustom("disallow", new RefImpl(recurser.seeCustom(dsl, domain.getDisallowRef().getThirdRef(), SchemaContainer.class)));
        objectDSL.seeList("enumField", new RefImpl(recurser.seeCustomRefList(dsl, domain.getEnumFieldRef(), JThing.class)));
        objectDSL.seeDouble("exclusiveMaximum", domain.getExclusiveMaximumRef());
        objectDSL.seeDouble("exclusiveMinimum", domain.getExclusiveMinimumRef());
        objectDSL.seeCustom("extendsField", new RefImpl(recurser.seeCustom(dsl, domain.getExtendsFieldRef().getFirstRef(), SchemaContainer.class)));
        objectDSL.seeList("extendsField", new RefImpl(recurser.seeCustomRefList(dsl, domain.getExtendsFieldRef().getSecondRef(), SchemaContainer.class)));
        objectDSL.seeString("format", domain.getFormatRef());
        objectDSL.seeCustom("items", new RefImpl(recurser.seeCustom(dsl, domain.getItemsRef().getFirstRef(), SchemaContainer.class)));
        objectDSL.seeList("items", new RefImpl(recurser.seeCustomRefList(dsl, domain.getItemsRef().getSecondRef(), SchemaContainer.class)));
        objectDSL.seeDouble("maxDecimal", domain.getMaxDecimalRef());
        objectDSL.seeLong("maxItems", domain.getMaxItemsRef());
        objectDSL.seeLong("maxLength", domain.getMaxLengthRef());
        objectDSL.seeDouble("maximum", domain.getMaximumRef());
        objectDSL.seeLong("minItems", domain.getMinItemsRef());
        objectDSL.seeLong("minLength", domain.getMinLengthRef());
        objectDSL.seeDouble("minimum", domain.getMinimumRef());
        objectDSL.seeString("pattern", domain.getPatternRef());
        objectDSL.seeCustom("properties", new RefImpl(recurser.seeCustomMap(dsl, domain.getPropertiesRef(), net.exathunk.jereal.genschema.schema.SchemaContainer.class)));
        objectDSL.seeBoolean("required", domain.getRequiredRef());
        objectDSL.seeString("requires", domain.getRequiresRef().getFirstRef());
        objectDSL.seeCustom("requires", new RefImpl(recurser.seeCustom(dsl, domain.getRequiresRef().getSecondRef(), SchemaContainer.class)));
        objectDSL.seeString("title", domain.getTitleRef());
        objectDSL.seeString("type", domain.getTypeRef().getFirstRef());
        objectDSL.seeList("type", new RefImpl(recurser.seeCustomRefList2(dsl, domain.getTypeRef().getSecondRef(), String.class, SchemaContainer.class)));
        objectDSL.seeBoolean("uniqueItems", domain.getUniqueItemsRef());
        return objectDSL;
    }

}
