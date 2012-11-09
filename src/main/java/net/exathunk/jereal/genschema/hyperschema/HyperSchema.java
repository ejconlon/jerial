package net.exathunk.jereal.genschema.hyperschema;

import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.*;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschemaoruri.*;
import net.exathunk.jereal.genschema.links.*;

public class HyperSchema implements HyperSchemaLike, HyperSchemaRefable {

    private final Ref2<HyperSchemaOrUriContainer,Boolean> additionalItems;
    private final Ref2<HyperSchemaOrUriContainer,Boolean> additionalProperties;
    private final Ref<List<Ref<HyperSchemaOrUriContainer>>> alternate;
    private final Ref<String> contentEncoding;
    private final Ref<JThing> defaultField;
    private final Ref3<String,List<Ref2<String,HyperSchemaOrUriContainer>>,HyperSchemaOrUriContainer> disallow;
    private final Ref2<HyperSchemaOrUriContainer,List<Ref<HyperSchemaOrUriContainer>>> extendsField;
    private final Ref<String> fragmentResolution;
    private final Ref2<HyperSchemaOrUriContainer,List<Ref<HyperSchemaOrUriContainer>>> items;
    private final Ref<List<Ref<LinksContainer>>> links;
    private final Ref<String> mediaType;
    private final Ref<String> pathStart;
    private final Ref<HyperSchemaOrUriContainer> properties;
    private final Ref<Boolean> readonly;
    private final Ref2<String,HyperSchemaOrUriContainer> requires;
    private final Ref<Boolean> root;
    private final Ref2<String,List<Ref2<String,HyperSchemaOrUriContainer>>> type;

    public HyperSchema() {
        additionalItems = new Ref2<HyperSchemaOrUriContainer,Boolean>();
        additionalProperties = new Ref2<HyperSchemaOrUriContainer,Boolean>();
        alternate = new RefImpl<List<Ref<HyperSchemaOrUriContainer>>>();
        contentEncoding = new RefImpl<String>();
        defaultField = new RefImpl<JThing>();
        disallow = new Ref3<String,List<Ref2<String,HyperSchemaOrUriContainer>>,HyperSchemaOrUriContainer>();
        extendsField = new Ref2<HyperSchemaOrUriContainer,List<Ref<HyperSchemaOrUriContainer>>>();
        fragmentResolution = new RefImpl<String>();
        items = new Ref2<HyperSchemaOrUriContainer,List<Ref<HyperSchemaOrUriContainer>>>();
        links = new RefImpl<List<Ref<LinksContainer>>>();
        mediaType = new RefImpl<String>();
        pathStart = new RefImpl<String>();
        properties = new RefImpl<HyperSchemaOrUriContainer>();
        readonly = new RefImpl<Boolean>();
        requires = new Ref2<String,HyperSchemaOrUriContainer>();
        root = new RefImpl<Boolean>();
        type = new Ref2<String,List<Ref2<String,HyperSchemaOrUriContainer>>>();
    }

    @Override
    public boolean hasAdditionalItems() {
        return !additionalItems.isEmptyRef();
    }
    @Override
    public Ref2<HyperSchemaOrUriContainer,Boolean> getAdditionalItemsRef() {
        return additionalItems;
    }

    @Override
    public boolean hasAdditionalProperties() {
        return !additionalProperties.isEmptyRef();
    }
    @Override
    public Ref2<HyperSchemaOrUriContainer,Boolean> getAdditionalPropertiesRef() {
        return additionalProperties;
    }

    @Override
    public boolean hasAlternate() {
        return !alternate.isEmptyRef();
    }
    @Override
    public List<Ref<HyperSchemaOrUriContainer>> getAlternate() {
        return alternate.getRef();
    }
    @Override
    public void setAlternate(List<Ref<HyperSchemaOrUriContainer>> value) {
        alternate.setRef(value);
    }
    @Override
    public Ref<List<Ref<HyperSchemaOrUriContainer>>> getAlternateRef() {
        return alternate;
    }

    @Override
    public boolean hasContentEncoding() {
        return !contentEncoding.isEmptyRef();
    }
    @Override
    public String getContentEncoding() {
        return contentEncoding.getRef();
    }
    @Override
    public void setContentEncoding(String value) {
        contentEncoding.setRef(value);
    }
    @Override
    public Ref<String> getContentEncodingRef() {
        return contentEncoding;
    }

    @Override
    public boolean hasDefaultField() {
        return !defaultField.isEmptyRef();
    }
    @Override
    public JThing getDefaultField() {
        return defaultField.getRef();
    }
    @Override
    public void setDefaultField(JThing value) {
        defaultField.setRef(value);
    }
    @Override
    public Ref<JThing> getDefaultFieldRef() {
        return defaultField;
    }

    @Override
    public boolean hasDisallow() {
        return !disallow.isEmptyRef();
    }
    @Override
    public Ref3<String,List<Ref2<String,HyperSchemaOrUriContainer>>,HyperSchemaOrUriContainer> getDisallowRef() {
        return disallow;
    }

    @Override
    public boolean hasExtendsField() {
        return !extendsField.isEmptyRef();
    }
    @Override
    public Ref2<HyperSchemaOrUriContainer,List<Ref<HyperSchemaOrUriContainer>>> getExtendsFieldRef() {
        return extendsField;
    }

    @Override
    public boolean hasFragmentResolution() {
        return !fragmentResolution.isEmptyRef();
    }
    @Override
    public String getFragmentResolution() {
        return fragmentResolution.getRef();
    }
    @Override
    public void setFragmentResolution(String value) {
        fragmentResolution.setRef(value);
    }
    @Override
    public Ref<String> getFragmentResolutionRef() {
        return fragmentResolution;
    }

    @Override
    public boolean hasItems() {
        return !items.isEmptyRef();
    }
    @Override
    public Ref2<HyperSchemaOrUriContainer,List<Ref<HyperSchemaOrUriContainer>>> getItemsRef() {
        return items;
    }

    @Override
    public boolean hasLinks() {
        return !links.isEmptyRef();
    }
    @Override
    public List<Ref<LinksContainer>> getLinks() {
        return links.getRef();
    }
    @Override
    public void setLinks(List<Ref<LinksContainer>> value) {
        links.setRef(value);
    }
    @Override
    public Ref<List<Ref<LinksContainer>>> getLinksRef() {
        return links;
    }

    @Override
    public boolean hasMediaType() {
        return !mediaType.isEmptyRef();
    }
    @Override
    public String getMediaType() {
        return mediaType.getRef();
    }
    @Override
    public void setMediaType(String value) {
        mediaType.setRef(value);
    }
    @Override
    public Ref<String> getMediaTypeRef() {
        return mediaType;
    }

    @Override
    public boolean hasPathStart() {
        return !pathStart.isEmptyRef();
    }
    @Override
    public String getPathStart() {
        return pathStart.getRef();
    }
    @Override
    public void setPathStart(String value) {
        pathStart.setRef(value);
    }
    @Override
    public Ref<String> getPathStartRef() {
        return pathStart;
    }

    @Override
    public boolean hasProperties() {
        return !properties.isEmptyRef();
    }
    @Override
    public HyperSchemaOrUriContainer getProperties() {
        return properties.getRef();
    }
    @Override
    public void setProperties(HyperSchemaOrUriContainer value) {
        properties.setRef(value);
    }
    @Override
    public Ref<HyperSchemaOrUriContainer> getPropertiesRef() {
        return properties;
    }

    @Override
    public boolean hasReadonly() {
        return !readonly.isEmptyRef();
    }
    @Override
    public Boolean getReadonly() {
        return readonly.getRef();
    }
    @Override
    public void setReadonly(Boolean value) {
        readonly.setRef(value);
    }
    @Override
    public Ref<Boolean> getReadonlyRef() {
        return readonly;
    }

    @Override
    public boolean hasRequires() {
        return !requires.isEmptyRef();
    }
    @Override
    public Ref2<String,HyperSchemaOrUriContainer> getRequiresRef() {
        return requires;
    }

    @Override
    public boolean hasRoot() {
        return !root.isEmptyRef();
    }
    @Override
    public Boolean getRoot() {
        return root.getRef();
    }
    @Override
    public void setRoot(Boolean value) {
        root.setRef(value);
    }
    @Override
    public Ref<Boolean> getRootRef() {
        return root;
    }

    @Override
    public boolean hasType() {
        return !type.isEmptyRef();
    }
    @Override
    public Ref2<String,List<Ref2<String,HyperSchemaOrUriContainer>>> getTypeRef() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("HyperSchema{ ");
        if (!additionalItems.isEmptyRef()) sb.append("additionalItems='").append(additionalItems).append("', ");
        if (!additionalProperties.isEmptyRef()) sb.append("additionalProperties='").append(additionalProperties).append("', ");
        if (!alternate.isEmptyRef()) sb.append("alternate='").append(alternate).append("', ");
        if (!contentEncoding.isEmptyRef()) sb.append("contentEncoding='").append(contentEncoding).append("', ");
        if (!defaultField.isEmptyRef()) sb.append("defaultField='").append(defaultField).append("', ");
        if (!disallow.isEmptyRef()) sb.append("disallow='").append(disallow).append("', ");
        if (!extendsField.isEmptyRef()) sb.append("extendsField='").append(extendsField).append("', ");
        if (!fragmentResolution.isEmptyRef()) sb.append("fragmentResolution='").append(fragmentResolution).append("', ");
        if (!items.isEmptyRef()) sb.append("items='").append(items).append("', ");
        if (!links.isEmptyRef()) sb.append("links='").append(links).append("', ");
        if (!mediaType.isEmptyRef()) sb.append("mediaType='").append(mediaType).append("', ");
        if (!pathStart.isEmptyRef()) sb.append("pathStart='").append(pathStart).append("', ");
        if (!properties.isEmptyRef()) sb.append("properties='").append(properties).append("', ");
        if (!readonly.isEmptyRef()) sb.append("readonly='").append(readonly).append("', ");
        if (!requires.isEmptyRef()) sb.append("requires='").append(requires).append("', ");
        if (!root.isEmptyRef()) sb.append("root='").append(root).append("', ");
        if (!type.isEmptyRef()) sb.append("type='").append(type).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof HyperSchemaRefable) {
            HyperSchemaRefable other = (HyperSchemaRefable) o;
            if (!getAdditionalItemsRef().equals(other.getAdditionalItemsRef())) return false;
            if (!getAdditionalPropertiesRef().equals(other.getAdditionalPropertiesRef())) return false;
            if (!getAlternateRef().equals(other.getAlternateRef())) return false;
            if (!getContentEncodingRef().equals(other.getContentEncodingRef())) return false;
            if (!getDefaultFieldRef().equals(other.getDefaultFieldRef())) return false;
            if (!getDisallowRef().equals(other.getDisallowRef())) return false;
            if (!getExtendsFieldRef().equals(other.getExtendsFieldRef())) return false;
            if (!getFragmentResolutionRef().equals(other.getFragmentResolutionRef())) return false;
            if (!getItemsRef().equals(other.getItemsRef())) return false;
            if (!getLinksRef().equals(other.getLinksRef())) return false;
            if (!getMediaTypeRef().equals(other.getMediaTypeRef())) return false;
            if (!getPathStartRef().equals(other.getPathStartRef())) return false;
            if (!getPropertiesRef().equals(other.getPropertiesRef())) return false;
            if (!getReadonlyRef().equals(other.getReadonlyRef())) return false;
            if (!getRequiresRef().equals(other.getRequiresRef())) return false;
            if (!getRootRef().equals(other.getRootRef())) return false;
            if (!getTypeRef().equals(other.getTypeRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + additionalItems.hashCode();
        result = 31 * result + additionalProperties.hashCode();
        result = 31 * result + alternate.hashCode();
        result = 31 * result + contentEncoding.hashCode();
        result = 31 * result + defaultField.hashCode();
        result = 31 * result + disallow.hashCode();
        result = 31 * result + extendsField.hashCode();
        result = 31 * result + fragmentResolution.hashCode();
        result = 31 * result + items.hashCode();
        result = 31 * result + links.hashCode();
        result = 31 * result + mediaType.hashCode();
        result = 31 * result + pathStart.hashCode();
        result = 31 * result + properties.hashCode();
        result = 31 * result + readonly.hashCode();
        result = 31 * result + requires.hashCode();
        result = 31 * result + root.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

}
