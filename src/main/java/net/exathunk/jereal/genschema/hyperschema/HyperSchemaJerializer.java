package net.exathunk.jereal.genschema.hyperschema;

import java.lang.Boolean;
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
import net.exathunk.jereal.genschema.hyperschemaoruri.HyperSchemaOrUriContainer;
import net.exathunk.jereal.genschema.links.LinksContainer;

public class HyperSchemaJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, HyperSchema> {

    @Override
    public HyperSchema prototype(Speclike spec) {
        return new HyperSchema();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, HyperSchema domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeWritable("additionalItems", new RefImpl(recurser.seeCustom(dsl, domain.getAdditionalItemsRef().getFirstRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeBoolean("additionalItems", domain.getAdditionalItemsRef().getSecondRef());
        objectDSL.seeWritable("additionalProperties", new RefImpl(recurser.seeCustom(dsl, domain.getAdditionalPropertiesRef().getFirstRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeBoolean("additionalProperties", domain.getAdditionalPropertiesRef().getSecondRef());
        objectDSL.seeWritable("alternate", new RefImpl(recurser.seeCustomRefList(dsl, domain.getAlternateRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeString("contentEncoding", domain.getContentEncodingRef());
        objectDSL.seeWritable("defaultField", new RefImpl(recurser.seeThing(dsl, domain.getDefaultFieldRef())));
        // dsl.addSomething(domain.getDisallowRef());
        objectDSL.seeWritable("extendsField", new RefImpl(recurser.seeCustom(dsl, domain.getExtendsFieldRef().getFirstRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeWritable("extendsField", new RefImpl(recurser.seeCustomRefList(dsl, domain.getExtendsFieldRef().getSecondRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeString("fragmentResolution", domain.getFragmentResolutionRef());
        objectDSL.seeWritable("items", new RefImpl(recurser.seeCustom(dsl, domain.getItemsRef().getFirstRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeWritable("items", new RefImpl(recurser.seeCustomRefList(dsl, domain.getItemsRef().getSecondRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeWritable("links", new RefImpl(recurser.seeCustomRefList(dsl, domain.getLinksRef(), LinksContainer.class)));
        objectDSL.seeString("mediaType", domain.getMediaTypeRef());
        objectDSL.seeString("pathStart", domain.getPathStartRef());
        objectDSL.seeWritable("properties", new RefImpl(recurser.seeCustom(dsl, domain.getPropertiesRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeBoolean("readonly", domain.getReadonlyRef());
        objectDSL.seeString("requires", domain.getRequiresRef().getFirstRef());
        objectDSL.seeWritable("requires", new RefImpl(recurser.seeCustom(dsl, domain.getRequiresRef().getSecondRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeBoolean("root", domain.getRootRef());
        objectDSL.seeString("type", domain.getTypeRef().getFirstRef());
        objectDSL.seeWritable("type", new RefImpl(recurser.seeStringRefList(dsl, domain.getTypeRef().getSecondRef())));
        return objectDSL;
    }

}
