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

public class GeneratedSchemaJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedSchema> {

    @Override
    public GeneratedSchema prototype(Speclike spec) {
        return new GeneratedSchema();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedSchema domain) throws JerializerException {
        // dsl.addSomething(domain.getAdditionalItemsRef());
        // dsl.addSomething(domain.getAdditionalPropertiesRef());
        // dsl.addSomething(domain.getDescriptionRef());
        // dsl.addSomething(domain.getDisallowRef());
        // dsl.addSomething(domain.getEnumFieldRef());
        // dsl.addSomething(domain.getExclusiveMaximumRef());
        // dsl.addSomething(domain.getExclusiveMinimumRef());
        // dsl.addSomething(domain.getExtendsFieldRef());
        // dsl.addSomething(domain.getFormatRef());
        // dsl.addSomething(domain.getItemsRef());
        // dsl.addSomething(domain.getMaxDecimalRef());
        // dsl.addSomething(domain.getMaxItemsRef());
        // dsl.addSomething(domain.getMaxLengthRef());
        // dsl.addSomething(domain.getMaximumRef());
        // dsl.addSomething(domain.getMinItemsRef());
        // dsl.addSomething(domain.getMinLengthRef());
        // dsl.addSomething(domain.getMinimumRef());
        // dsl.addSomething(domain.getPatternRef());
        // dsl.addSomething(domain.getPropertiesRef());
        // dsl.addSomething(domain.getRequiredRef());
        // dsl.addSomething(domain.getRequiresRef());
        // dsl.addSomething(domain.getTitleRef());
        // dsl.addSomething(domain.getTypeRef());
        // dsl.addSomething(domain.getUniqueItemsRef());
        return null;
    }

}
