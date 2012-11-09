package net.exathunk.jereal.genschema.hyperschemaoruri;

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
import net.exathunk.jereal.genschema.hyperschema.*;

public class HyperSchemaOrUriContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, HyperSchemaOrUriContainer> {

    @Override
    public HyperSchemaOrUriContainer prototype(Speclike spec) throws JerializerException {
        HyperSchemaOrUriContainer domain = new HyperSchemaOrUriContainer();
        final Model model = spec.getModel();
        switch (model) {
            case OBJECT:
                domain.getHyperSchemaOrUriRef().setSecond(new HyperSchemaContainer());
                break;
            case ARRAY:
                throw new JerializerException("No matching model found for "+spec);
            case STRING:
                domain.getHyperSchemaOrUriRef().setFirst(new String());
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
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, HyperSchemaOrUriContainer domain) throws JerializerException {
        if (!domain.getHyperSchemaOrUriRef().getFirstRef().isEmptyRef())
            return dsl.seeString(domain.getHyperSchemaOrUriRef().getFirstRef());
        else if (!domain.getHyperSchemaOrUriRef().getSecondRef().isEmptyRef())
            return (new HyperSchemaContainerJerializer()).jerialize(recurser, dsl, domain.getHyperSchemaOrUriRef().getSecondRef().getRef());
        else throw new JerializerException("Nil ref - no return");
    }

}
