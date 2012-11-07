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

public interface GeneratedLinksLike {

        boolean hasEnctype();
        String getEnctype();
        void setEnctype(String value);

        boolean hasHref();
        String getHref();
        void setHref(String value);

        boolean hasMethod();
        String getMethod();
        void setMethod(String value);

        boolean hasProperties();
        JThing getProperties();
        void setProperties(JThing value);

        boolean hasRel();
        String getRel();
        void setRel(String value);

        boolean hasTargetSchema();
        GeneratedHyperSchemaContainer getTargetSchema();
        void setTargetSchema(GeneratedHyperSchemaContainer value);

}
