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

public class SchemaContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, SchemaContainer> {

    @Override
    public SchemaContainer prototype(Speclike spec) throws JerializerException {
        SchemaContainer domain = new SchemaContainer();
        final Model model = spec.getModel();
        switch (model) {
            case OBJECT:
                domain.getSchemaRef().setFirst(new Schema());
                break;
            case ARRAY:
                throw new JerializerException("No matching model found for "+spec);
            case STRING:
                domain.getSchemaRef().setSecond(new String());
                break;
            case BOOLEAN:
                throw new JerializerException("No matching model found for "+spec);
            case LONG:
                throw new JerializerException("No matching model found for "+spec);
            case DOUBLE:
                throw new JerializerException("No matching model found for "+spec);
            default:
                throw new JerializerException("No matching model found for "+spec);
        }
        return domain;
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, SchemaContainer domain) throws JerializerException {
        if (!domain.getSchemaRef().getFirstRef().isEmptyRef())
            return (new SchemaJerializer()).jerialize(recurser, dsl, domain.getSchemaRef().getFirstRef().getRef());
        else if (!domain.getSchemaRef().getSecondRef().isEmptyRef())
            return dsl.seeString(domain.getSchemaRef().getSecondRef());
        else throw new JerializerException("Nil ref - no return");
    }

}
