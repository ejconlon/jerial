package net.exathunk.jereal.genschema.hyperschema;

import java.lang.Boolean;
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
import net.exathunk.jereal.genschema.hyperschemaoruri.HyperSchemaOrUriContainer;
import net.exathunk.jereal.genschema.links.LinksContainer;

public class HyperSchemaJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, HyperSchema> {

    @Override
    public HyperSchema prototype(Speclike spec) {
        return new HyperSchema();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, HyperSchema domain) throws JerializerException {
        // dsl.addSomething(domain.getAdditionalItemsRef());
        // dsl.addSomething(domain.getAdditionalPropertiesRef());
        // dsl.addSomething(domain.getAlternateRef());
        dsl.seeString(domain.getContentEncodingRef());
        recurser.seeThing(dsl, domain.getDefaultFieldRef());
        // dsl.addSomething(domain.getDisallowRef());
        // dsl.addSomething(domain.getExtendsFieldRef());
        dsl.seeString(domain.getFragmentResolutionRef());
        // dsl.addSomething(domain.getItemsRef());
        // dsl.addSomething(domain.getLinksRef());
        dsl.seeString(domain.getMediaTypeRef());
        dsl.seeString(domain.getPathStartRef());
        recurser.seeCustom(dsl, domain.getPropertiesRef(), HyperSchemaOrUriContainer.class);
        dsl.seeBoolean(domain.getReadonlyRef());
        // dsl.addSomething(domain.getRequiresRef());
        dsl.seeBoolean(domain.getRootRef());
        // dsl.addSomething(domain.getTypeRef());
        return null;
    }

}
