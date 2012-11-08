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

public class SchemaJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Schema> {

    @Override
    public Schema prototype(Speclike spec) {
        return new Schema();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Schema domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeWritable("additionalItems", new RefImpl(recurser.seeCustom(dsl, domain.getAdditionalItemsRef().getFirstRef(), SchemaContainer.class)));
        objectDSL.seeBoolean("additionalItems", domain.getAdditionalItemsRef().getSecondRef());
        objectDSL.seeWritable("additionalProperties", new RefImpl(recurser.seeCustom(dsl, domain.getAdditionalPropertiesRef().getFirstRef(), SchemaContainer.class)));
        objectDSL.seeBoolean("additionalProperties", domain.getAdditionalPropertiesRef().getSecondRef());
        objectDSL.seeString("description", domain.getDescriptionRef());
        // dsl.addSomething(domain.getDisallowRef());
        objectDSL.seeWritable("enumField", new RefImpl(recurser.seeThingRefList(dsl, domain.getEnumFieldRef())));
        objectDSL.seeDouble("exclusiveMaximum", domain.getExclusiveMaximumRef());
        objectDSL.seeDouble("exclusiveMinimum", domain.getExclusiveMinimumRef());
        objectDSL.seeWritable("extendsField", new RefImpl(recurser.seeCustom(dsl, domain.getExtendsFieldRef().getFirstRef(), SchemaContainer.class)));
        objectDSL.seeWritable("extendsField", new RefImpl(recurser.seeCustomRefList(dsl, domain.getExtendsFieldRef().getSecondRef(), SchemaContainer.class)));
        objectDSL.seeString("format", domain.getFormatRef());
        objectDSL.seeWritable("items", new RefImpl(recurser.seeCustom(dsl, domain.getItemsRef().getFirstRef(), SchemaContainer.class)));
        objectDSL.seeWritable("items", new RefImpl(recurser.seeCustomRefList(dsl, domain.getItemsRef().getSecondRef(), SchemaContainer.class)));
        objectDSL.seeDouble("maxDecimal", domain.getMaxDecimalRef());
        objectDSL.seeLong("maxItems", domain.getMaxItemsRef());
        objectDSL.seeLong("maxLength", domain.getMaxLengthRef());
        objectDSL.seeDouble("maximum", domain.getMaximumRef());
        objectDSL.seeLong("minItems", domain.getMinItemsRef());
        objectDSL.seeLong("minLength", domain.getMinLengthRef());
        objectDSL.seeDouble("minimum", domain.getMinimumRef());
        objectDSL.seeString("pattern", domain.getPatternRef());
        objectDSL.seeWritable("properties", new RefImpl(recurser.seeCustom(dsl, domain.getPropertiesRef(), SchemaContainer.class)));
        objectDSL.seeBoolean("required", domain.getRequiredRef());
        objectDSL.seeString("requires", domain.getRequiresRef().getFirstRef());
        objectDSL.seeWritable("requires", new RefImpl(recurser.seeCustom(dsl, domain.getRequiresRef().getSecondRef(), SchemaContainer.class)));
        objectDSL.seeString("title", domain.getTitleRef());
        objectDSL.seeString("type", domain.getTypeRef().getFirstRef());
        objectDSL.seeWritable("type", new RefImpl(recurser.seeStringRefList(dsl, domain.getTypeRef().getSecondRef())));
        objectDSL.seeBoolean("uniqueItems", domain.getUniqueItemsRef());
        return objectDSL;
    }

}
