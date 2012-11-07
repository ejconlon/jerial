package net.exathunk.jereal.genschema.links;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchemaContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public interface GeneratedLinksRefable {

        Ref<String> getEnctypeRef();

        Ref<String> getHrefRef();

        Ref<String> getMethodRef();

        Ref<JThing> getPropertiesRef();

        Ref<String> getRelRef();

        Ref<GeneratedHyperSchemaContainer> getTargetSchemaRef();

}
