package net.exathunk.jereal.genschema.hyperschema;

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
import net.exathunk.jereal.genschema.hyperschemaoruri.*;
import net.exathunk.jereal.genschema.links.*;

public class HyperSchemaJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, HyperSchema> {

    @Override
    public HyperSchema prototype(Speclike spec) {
        return new HyperSchema();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, HyperSchema domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeCustom("additionalItems", new RefImpl(recurser.seeCustom(dsl, domain.getAdditionalItemsRef().getFirstRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeBoolean("additionalItems", domain.getAdditionalItemsRef().getSecondRef());
        objectDSL.seeCustom("additionalProperties", new RefImpl(recurser.seeCustom(dsl, domain.getAdditionalPropertiesRef().getFirstRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeBoolean("additionalProperties", domain.getAdditionalPropertiesRef().getSecondRef());
        objectDSL.seeList("alternate", new RefImpl(recurser.seeCustomRefList(dsl, domain.getAlternateRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeString("contentEncoding", domain.getContentEncodingRef());
        objectDSL.seeCustom("defaultField", new RefImpl(recurser.seeThing(dsl, domain.getDefaultFieldRef())));
        objectDSL.seeString("disallow", domain.getDisallowRef().getFirstRef());
        objectDSL.seeList("disallow", new RefImpl(recurser.seeCustomRefList2(dsl, domain.getDisallowRef().getSecondRef(), String.class, HyperSchemaOrUriContainer.class)));
        objectDSL.seeCustom("disallow", new RefImpl(recurser.seeCustom(dsl, domain.getDisallowRef().getThirdRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeCustom("extendsField", new RefImpl(recurser.seeCustom(dsl, domain.getExtendsFieldRef().getFirstRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeList("extendsField", new RefImpl(recurser.seeCustomRefList(dsl, domain.getExtendsFieldRef().getSecondRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeString("fragmentResolution", domain.getFragmentResolutionRef());
        objectDSL.seeCustom("items", new RefImpl(recurser.seeCustom(dsl, domain.getItemsRef().getFirstRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeList("items", new RefImpl(recurser.seeCustomRefList(dsl, domain.getItemsRef().getSecondRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeList("links", new RefImpl(recurser.seeCustomRefList(dsl, domain.getLinksRef(), LinksContainer.class)));
        objectDSL.seeString("mediaType", domain.getMediaTypeRef());
        objectDSL.seeString("pathStart", domain.getPathStartRef());
        objectDSL.seeCustom("properties", new RefImpl(recurser.seeCustomMap(dsl, domain.getPropertiesRef(), net.exathunk.jereal.genschema.hyperschemaoruri.HyperSchemaOrUriContainer.class)));
        objectDSL.seeBoolean("readonly", domain.getReadonlyRef());
        objectDSL.seeString("requires", domain.getRequiresRef().getFirstRef());
        objectDSL.seeCustom("requires", new RefImpl(recurser.seeCustom(dsl, domain.getRequiresRef().getSecondRef(), HyperSchemaOrUriContainer.class)));
        objectDSL.seeBoolean("root", domain.getRootRef());
        objectDSL.seeString("type", domain.getTypeRef().getFirstRef());
        objectDSL.seeList("type", new RefImpl(recurser.seeCustomRefList2(dsl, domain.getTypeRef().getSecondRef(), String.class, HyperSchemaOrUriContainer.class)));
        return objectDSL;
    }

}
