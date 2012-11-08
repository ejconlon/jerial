package net.exathunk.jereal.genschema.links;

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
import net.exathunk.jereal.genschema.hyperschema.HyperSchemaContainer;

public interface LinksLike {

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
        HyperSchemaContainer getProperties();
        void setProperties(HyperSchemaContainer value);

        boolean hasRel();
        String getRel();
        void setRel(String value);

        boolean hasTargetSchema();
        HyperSchemaContainer getTargetSchema();
        void setTargetSchema(HyperSchemaContainer value);

}
