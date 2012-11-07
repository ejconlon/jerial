package net.exathunk.jereal.genschema.hyperschema;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.hyperschemaoruri.GeneratedHyperSchemaOrUriContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public interface GeneratedHyperSchemaLike {

        boolean hasAdditionalItems();
        Any2<GeneratedHyperSchemaOrUriContainer,Boolean> getAdditionalItems();
        void setAdditionalItems(Any2<GeneratedHyperSchemaOrUriContainer,Boolean> value);

        boolean hasAdditionalProperties();
        Any2<GeneratedHyperSchemaOrUriContainer,Boolean> getAdditionalProperties();
        void setAdditionalProperties(Any2<GeneratedHyperSchemaOrUriContainer,Boolean> value);

        boolean hasAlternate();
        List<GeneratedHyperSchemaOrUriContainer> getAlternate();
        void setAlternate(List<GeneratedHyperSchemaOrUriContainer> value);

        boolean hasContentEncoding();
        String getContentEncoding();
        void setContentEncoding(String value);

        boolean hasDefaultField();
        JThing getDefaultField();
        void setDefaultField(JThing value);

        boolean hasDisallow();
        Any3<String,List<JThing>,GeneratedHyperSchemaOrUriContainer> getDisallow();
        void setDisallow(Any3<String,List<JThing>,GeneratedHyperSchemaOrUriContainer> value);

        boolean hasExtendsField();
        Any2<GeneratedHyperSchemaOrUriContainer,List<JThing>> getExtendsField();
        void setExtendsField(Any2<GeneratedHyperSchemaOrUriContainer,List<JThing>> value);

        boolean hasFragmentResolution();
        String getFragmentResolution();
        void setFragmentResolution(String value);

        boolean hasItems();
        Any2<GeneratedHyperSchemaOrUriContainer,List<JThing>> getItems();
        void setItems(Any2<GeneratedHyperSchemaOrUriContainer,List<JThing>> value);

        boolean hasLinks();
        List<GeneratedLinksContainer> getLinks();
        void setLinks(List<GeneratedLinksContainer> value);

        boolean hasMediaType();
        String getMediaType();
        void setMediaType(String value);

        boolean hasPathStart();
        String getPathStart();
        void setPathStart(String value);

        boolean hasProperties();
        JThing getProperties();
        void setProperties(JThing value);

        boolean hasReadonly();
        Boolean getReadonly();
        void setReadonly(Boolean value);

        boolean hasRequires();
        Any2<String,GeneratedHyperSchemaOrUriContainer> getRequires();
        void setRequires(Any2<String,GeneratedHyperSchemaOrUriContainer> value);

        boolean hasRoot();
        Boolean getRoot();
        void setRoot(Boolean value);

        boolean hasType();
        Any2<String,List<JThing>> getType();
        void setType(Any2<String,List<JThing>> value);

}
