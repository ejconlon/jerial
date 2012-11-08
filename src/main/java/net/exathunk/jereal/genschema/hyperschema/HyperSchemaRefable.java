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

public interface HyperSchemaRefable {

        Ref2<HyperSchemaOrUriContainer,Boolean> getAdditionalItemsRef();

        Ref2<HyperSchemaOrUriContainer,Boolean> getAdditionalPropertiesRef();

        Ref<List<Ref<HyperSchemaOrUriContainer>>> getAlternateRef();

        Ref<String> getContentEncodingRef();

        Ref<JThing> getDefaultFieldRef();

        Ref3<String,List<Ref2<String,HyperSchemaOrUriContainer>>,HyperSchemaOrUriContainer> getDisallowRef();

        Ref2<HyperSchemaOrUriContainer,List<Ref<HyperSchemaOrUriContainer>>> getExtendsFieldRef();

        Ref<String> getFragmentResolutionRef();

        Ref2<HyperSchemaOrUriContainer,List<Ref<HyperSchemaOrUriContainer>>> getItemsRef();

        Ref<List<Ref<LinksContainer>>> getLinksRef();

        Ref<String> getMediaTypeRef();

        Ref<String> getPathStartRef();

        Ref<HyperSchemaOrUriContainer> getPropertiesRef();

        Ref<Boolean> getReadonlyRef();

        Ref2<String,HyperSchemaOrUriContainer> getRequiresRef();

        Ref<Boolean> getRootRef();

        Ref2<String,List<Ref2<String,HyperSchemaOrUriContainer>>> getTypeRef();

}
