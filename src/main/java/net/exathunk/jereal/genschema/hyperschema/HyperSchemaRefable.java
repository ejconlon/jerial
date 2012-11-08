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

public interface HyperSchemaRefable {

        Ref<Any2<HyperSchemaOrUriContainer,Boolean>> getAdditionalItemsRef();

        Ref<Any2<HyperSchemaOrUriContainer,Boolean>> getAdditionalPropertiesRef();

        Ref<List<HyperSchemaOrUriContainer>> getAlternateRef();

        Ref<String> getContentEncodingRef();

        Ref<JThing> getDefaultFieldRef();

        Ref<Any3<String,List<Any2<String,HyperSchemaOrUriContainer>>,HyperSchemaOrUriContainer>> getDisallowRef();

        Ref<Any2<HyperSchemaOrUriContainer,List<HyperSchemaOrUriContainer>>> getExtendsFieldRef();

        Ref<String> getFragmentResolutionRef();

        Ref<Any2<HyperSchemaOrUriContainer,List<HyperSchemaOrUriContainer>>> getItemsRef();

        Ref<List<LinksContainer>> getLinksRef();

        Ref<String> getMediaTypeRef();

        Ref<String> getPathStartRef();

        Ref<HyperSchemaOrUriContainer> getPropertiesRef();

        Ref<Boolean> getReadonlyRef();

        Ref<Any2<String,HyperSchemaOrUriContainer>> getRequiresRef();

        Ref<Boolean> getRootRef();

        Ref<Any2<String,List<Any2<String,HyperSchemaOrUriContainer>>>> getTypeRef();

}
