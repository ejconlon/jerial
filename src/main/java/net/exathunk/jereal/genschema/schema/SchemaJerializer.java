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

public class SchemaJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Schema> {

    @Override
    public Schema prototype(Speclike spec) {
        return new Schema();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Schema domain) throws JerializerException {
        // dsl.addSomething(domain.getAdditionalItemsRef());
        // dsl.addSomething(domain.getAdditionalPropertiesRef());
        dsl.seeString(domain.getDescriptionRef());
        // dsl.addSomething(domain.getDisallowRef());
        // dsl.addSomething(domain.getEnumFieldRef());
        dsl.seeDouble(domain.getExclusiveMaximumRef());
        dsl.seeDouble(domain.getExclusiveMinimumRef());
        // dsl.addSomething(domain.getExtendsFieldRef());
        dsl.seeString(domain.getFormatRef());
        // dsl.addSomething(domain.getItemsRef());
        dsl.seeDouble(domain.getMaxDecimalRef());
        dsl.seeLong(domain.getMaxItemsRef());
        dsl.seeLong(domain.getMaxLengthRef());
        dsl.seeDouble(domain.getMaximumRef());
        dsl.seeLong(domain.getMinItemsRef());
        dsl.seeLong(domain.getMinLengthRef());
        dsl.seeDouble(domain.getMinimumRef());
        dsl.seeString(domain.getPatternRef());
        recurser.seeCustom(dsl, domain.getPropertiesRef(), SchemaContainer.class);
        dsl.seeBoolean(domain.getRequiredRef());
        // dsl.addSomething(domain.getRequiresRef());
        dsl.seeString(domain.getTitleRef());
        // dsl.addSomething(domain.getTypeRef());
        dsl.seeBoolean(domain.getUniqueItemsRef());
        return null;
    }

}
