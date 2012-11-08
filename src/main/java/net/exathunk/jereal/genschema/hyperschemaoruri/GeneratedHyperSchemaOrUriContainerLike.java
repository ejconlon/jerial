package net.exathunk.jereal.genschema.hyperschemaoruri;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchema;
import net.exathunk.jereal.genschema.hyperschema.GeneratedHyperSchemaContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public interface GeneratedHyperSchemaOrUriContainerLike {

        boolean hasGeneratedHyperSchemaOrUri();
        Any2<String,GeneratedHyperSchemaContainer> getGeneratedHyperSchemaOrUri();
        void setGeneratedHyperSchemaOrUri(Any2<String,GeneratedHyperSchemaContainer> value);

}
