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

public interface HyperSchemaLike {

        boolean hasAdditionalItems();
        boolean hasAdditionalProperties();
        boolean hasAlternate();
        List<Ref<HyperSchemaOrUriContainer>> getAlternate();
        void setAlternate(List<Ref<HyperSchemaOrUriContainer>> value);

        boolean hasContentEncoding();
        String getContentEncoding();
        void setContentEncoding(String value);

        boolean hasDefaultField();
        JThing getDefaultField();
        void setDefaultField(JThing value);

        boolean hasDisallow();
        boolean hasExtendsField();
        boolean hasFragmentResolution();
        String getFragmentResolution();
        void setFragmentResolution(String value);

        boolean hasItems();
        boolean hasLinks();
        List<Ref<LinksContainer>> getLinks();
        void setLinks(List<Ref<LinksContainer>> value);

        boolean hasMediaType();
        String getMediaType();
        void setMediaType(String value);

        boolean hasPathStart();
        String getPathStart();
        void setPathStart(String value);

        boolean hasProperties();
        HyperSchemaOrUriContainer getProperties();
        void setProperties(HyperSchemaOrUriContainer value);

        boolean hasReadonly();
        Boolean getReadonly();
        void setReadonly(Boolean value);

        boolean hasRequires();
        boolean hasRoot();
        Boolean getRoot();
        void setRoot(Boolean value);

        boolean hasType();
}