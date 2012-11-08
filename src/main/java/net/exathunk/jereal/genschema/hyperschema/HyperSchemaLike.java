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

public interface HyperSchemaLike {

        boolean hasAdditionalItems();
        Any2<HyperSchemaOrUriContainer,Boolean> getAdditionalItems();
        void setAdditionalItems(Any2<HyperSchemaOrUriContainer,Boolean> value);

        boolean hasAdditionalProperties();
        Any2<HyperSchemaOrUriContainer,Boolean> getAdditionalProperties();
        void setAdditionalProperties(Any2<HyperSchemaOrUriContainer,Boolean> value);

        boolean hasAlternate();
        List<HyperSchemaOrUriContainer> getAlternate();
        void setAlternate(List<HyperSchemaOrUriContainer> value);

        boolean hasContentEncoding();
        String getContentEncoding();
        void setContentEncoding(String value);

        boolean hasDefaultField();
        JThing getDefaultField();
        void setDefaultField(JThing value);

        boolean hasDisallow();
        Any3<String,List<Any2<String,HyperSchemaOrUriContainer>>,HyperSchemaOrUriContainer> getDisallow();
        void setDisallow(Any3<String,List<Any2<String,HyperSchemaOrUriContainer>>,HyperSchemaOrUriContainer> value);

        boolean hasExtendsField();
        Any2<HyperSchemaOrUriContainer,List<HyperSchemaOrUriContainer>> getExtendsField();
        void setExtendsField(Any2<HyperSchemaOrUriContainer,List<HyperSchemaOrUriContainer>> value);

        boolean hasFragmentResolution();
        String getFragmentResolution();
        void setFragmentResolution(String value);

        boolean hasItems();
        Any2<HyperSchemaOrUriContainer,List<HyperSchemaOrUriContainer>> getItems();
        void setItems(Any2<HyperSchemaOrUriContainer,List<HyperSchemaOrUriContainer>> value);

        boolean hasLinks();
        List<LinksContainer> getLinks();
        void setLinks(List<LinksContainer> value);

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
        Any2<String,HyperSchemaOrUriContainer> getRequires();
        void setRequires(Any2<String,HyperSchemaOrUriContainer> value);

        boolean hasRoot();
        Boolean getRoot();
        void setRoot(Boolean value);

        boolean hasType();
        Any2<String,List<Any2<String,HyperSchemaOrUriContainer>>> getType();
        void setType(Any2<String,List<Any2<String,HyperSchemaOrUriContainer>>> value);

}
