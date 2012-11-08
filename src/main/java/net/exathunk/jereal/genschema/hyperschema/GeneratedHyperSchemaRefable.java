package net.exathunk.jereal.genschema.hyperschema;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschemaoruri.GeneratedHyperSchemaOrUri;
import net.exathunk.jereal.genschema.hyperschemaoruri.GeneratedHyperSchemaOrUriContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public interface GeneratedHyperSchemaRefable {

        Ref<Any2<GeneratedHyperSchemaOrUriContainer,Boolean>> getAdditionalItemsRef();

        Ref<Any2<GeneratedHyperSchemaOrUriContainer,Boolean>> getAdditionalPropertiesRef();

        Ref<List<GeneratedHyperSchemaOrUriContainer>> getAlternateRef();

        Ref<String> getContentEncodingRef();

        Ref<JThing> getDefaultFieldRef();

        Ref<Any3<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>,GeneratedHyperSchemaOrUriContainer>> getDisallowRef();

        Ref<Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>>> getExtendsFieldRef();

        Ref<String> getFragmentResolutionRef();

        Ref<Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>>> getItemsRef();

        Ref<List<GeneratedLinksContainer>> getLinksRef();

        Ref<String> getMediaTypeRef();

        Ref<String> getPathStartRef();

        Ref<GeneratedHyperSchemaOrUriContainer> getPropertiesRef();

        Ref<Boolean> getReadonlyRef();

        Ref<Any2<String,GeneratedHyperSchemaOrUriContainer>> getRequiresRef();

        Ref<Boolean> getRootRef();

        Ref<Any2<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>>> getTypeRef();

}
