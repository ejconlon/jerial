package net.exathunk.jereal.genschema.hyperschema;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.hyperschemaoruri.GeneratedHyperSchemaOrUriContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedHyperSchema implements GeneratedHyperSchemaLike, GeneratedHyperSchemaRefable {

    private final Ref<Any2<GeneratedHyperSchemaOrUriContainer,Boolean>> additionalItems;
    private final Ref<Any2<GeneratedHyperSchemaOrUriContainer,Boolean>> additionalProperties;
    private final Ref<List<GeneratedHyperSchemaOrUriContainer>> alternate;
    private final Ref<String> contentEncoding;
    private final Ref<JThing> defaultField;
    private final Ref<Any3<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>,GeneratedHyperSchemaOrUriContainer>> disallow;
    private final Ref<Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>>> extendsField;
    private final Ref<String> fragmentResolution;
    private final Ref<Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>>> items;
    private final Ref<List<GeneratedLinksContainer>> links;
    private final Ref<String> mediaType;
    private final Ref<String> pathStart;
    private final Ref<JThing> properties;
    private final Ref<Boolean> readonly;
    private final Ref<Any2<String,GeneratedHyperSchemaOrUriContainer>> requires;
    private final Ref<Boolean> root;
    private final Ref<Any2<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>>> type;

    public GeneratedHyperSchema() {
        additionalItems = new RefImpl<Any2<GeneratedHyperSchemaOrUriContainer,Boolean>>();
        additionalProperties = new RefImpl<Any2<GeneratedHyperSchemaOrUriContainer,Boolean>>();
        alternate = new RefImpl<List<GeneratedHyperSchemaOrUriContainer>>();
        contentEncoding = new RefImpl<String>();
        defaultField = new RefImpl<JThing>();
        disallow = new RefImpl<Any3<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>,GeneratedHyperSchemaOrUriContainer>>();
        extendsField = new RefImpl<Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>>>();
        fragmentResolution = new RefImpl<String>();
        items = new RefImpl<Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>>>();
        links = new RefImpl<List<GeneratedLinksContainer>>();
        mediaType = new RefImpl<String>();
        pathStart = new RefImpl<String>();
        properties = new RefImpl<JThing>();
        readonly = new RefImpl<Boolean>();
        requires = new RefImpl<Any2<String,GeneratedHyperSchemaOrUriContainer>>();
        root = new RefImpl<Boolean>();
        type = new RefImpl<Any2<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>>>();
    }

    @Override
    public boolean hasAdditionalItems() {
        return !additionalItems.isEmptyRef();
    }
    @Override
    public Any2<GeneratedHyperSchemaOrUriContainer,Boolean> getAdditionalItems() {
        return additionalItems.getRef();
    }
    @Override
    public void setAdditionalItems(Any2<GeneratedHyperSchemaOrUriContainer,Boolean> value) {
        additionalItems.setRef(value);
    }
    @Override
    public Ref<Any2<GeneratedHyperSchemaOrUriContainer,Boolean>> getAdditionalItemsRef() {
        return additionalItems;
    }

    @Override
    public boolean hasAdditionalProperties() {
        return !additionalProperties.isEmptyRef();
    }
    @Override
    public Any2<GeneratedHyperSchemaOrUriContainer,Boolean> getAdditionalProperties() {
        return additionalProperties.getRef();
    }
    @Override
    public void setAdditionalProperties(Any2<GeneratedHyperSchemaOrUriContainer,Boolean> value) {
        additionalProperties.setRef(value);
    }
    @Override
    public Ref<Any2<GeneratedHyperSchemaOrUriContainer,Boolean>> getAdditionalPropertiesRef() {
        return additionalProperties;
    }

    @Override
    public boolean hasAlternate() {
        return !alternate.isEmptyRef();
    }
    @Override
    public List<GeneratedHyperSchemaOrUriContainer> getAlternate() {
        return alternate.getRef();
    }
    @Override
    public void setAlternate(List<GeneratedHyperSchemaOrUriContainer> value) {
        alternate.setRef(value);
    }
    @Override
    public Ref<List<GeneratedHyperSchemaOrUriContainer>> getAlternateRef() {
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
    public Any3<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>,GeneratedHyperSchemaOrUriContainer> getDisallow() {
        return disallow.getRef();
    }
    @Override
    public void setDisallow(Any3<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>,GeneratedHyperSchemaOrUriContainer> value) {
        disallow.setRef(value);
    }
    @Override
    public Ref<Any3<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>,GeneratedHyperSchemaOrUriContainer>> getDisallowRef() {
        return disallow;
    }

    @Override
    public boolean hasExtendsField() {
        return !extendsField.isEmptyRef();
    }
    @Override
    public Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>> getExtendsField() {
        return extendsField.getRef();
    }
    @Override
    public void setExtendsField(Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>> value) {
        extendsField.setRef(value);
    }
    @Override
    public Ref<Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>>> getExtendsFieldRef() {
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
    public Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>> getItems() {
        return items.getRef();
    }
    @Override
    public void setItems(Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>> value) {
        items.setRef(value);
    }
    @Override
    public Ref<Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>>> getItemsRef() {
        return items;
    }

    @Override
    public boolean hasLinks() {
        return !links.isEmptyRef();
    }
    @Override
    public List<GeneratedLinksContainer> getLinks() {
        return links.getRef();
    }
    @Override
    public void setLinks(List<GeneratedLinksContainer> value) {
        links.setRef(value);
    }
    @Override
    public Ref<List<GeneratedLinksContainer>> getLinksRef() {
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
    public JThing getProperties() {
        return properties.getRef();
    }
    @Override
    public void setProperties(JThing value) {
        properties.setRef(value);
    }
    @Override
    public Ref<JThing> getPropertiesRef() {
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
    public Any2<String,GeneratedHyperSchemaOrUriContainer> getRequires() {
        return requires.getRef();
    }
    @Override
    public void setRequires(Any2<String,GeneratedHyperSchemaOrUriContainer> value) {
        requires.setRef(value);
    }
    @Override
    public Ref<Any2<String,GeneratedHyperSchemaOrUriContainer>> getRequiresRef() {
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
    public Any2<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>> getType() {
        return type.getRef();
    }
    @Override
    public void setType(Any2<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>> value) {
        type.setRef(value);
    }
    @Override
    public Ref<Any2<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>>> getTypeRef() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedHyperSchema{ ");
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
        if (o instanceof GeneratedHyperSchemaLike) {
            GeneratedHyperSchemaLike other = (GeneratedHyperSchemaLike) o;
            if (hasAdditionalItems()) {
                if (!other.hasAdditionalItems()) return false;
                else if (!getAdditionalItems().equals(other.getAdditionalItems())) return false;
            } else if (other.hasAdditionalItems()) return false;
            if (hasAdditionalProperties()) {
                if (!other.hasAdditionalProperties()) return false;
                else if (!getAdditionalProperties().equals(other.getAdditionalProperties())) return false;
            } else if (other.hasAdditionalProperties()) return false;
            if (hasAlternate()) {
                if (!other.hasAlternate()) return false;
                else if (!getAlternate().equals(other.getAlternate())) return false;
            } else if (other.hasAlternate()) return false;
            if (hasContentEncoding()) {
                if (!other.hasContentEncoding()) return false;
                else if (!getContentEncoding().equals(other.getContentEncoding())) return false;
            } else if (other.hasContentEncoding()) return false;
            if (hasDefaultField()) {
                if (!other.hasDefaultField()) return false;
                else if (!getDefaultField().equals(other.getDefaultField())) return false;
            } else if (other.hasDefaultField()) return false;
            if (hasDisallow()) {
                if (!other.hasDisallow()) return false;
                else if (!getDisallow().equals(other.getDisallow())) return false;
            } else if (other.hasDisallow()) return false;
            if (hasExtendsField()) {
                if (!other.hasExtendsField()) return false;
                else if (!getExtendsField().equals(other.getExtendsField())) return false;
            } else if (other.hasExtendsField()) return false;
            if (hasFragmentResolution()) {
                if (!other.hasFragmentResolution()) return false;
                else if (!getFragmentResolution().equals(other.getFragmentResolution())) return false;
            } else if (other.hasFragmentResolution()) return false;
            if (hasItems()) {
                if (!other.hasItems()) return false;
                else if (!getItems().equals(other.getItems())) return false;
            } else if (other.hasItems()) return false;
            if (hasLinks()) {
                if (!other.hasLinks()) return false;
                else if (!getLinks().equals(other.getLinks())) return false;
            } else if (other.hasLinks()) return false;
            if (hasMediaType()) {
                if (!other.hasMediaType()) return false;
                else if (!getMediaType().equals(other.getMediaType())) return false;
            } else if (other.hasMediaType()) return false;
            if (hasPathStart()) {
                if (!other.hasPathStart()) return false;
                else if (!getPathStart().equals(other.getPathStart())) return false;
            } else if (other.hasPathStart()) return false;
            if (hasProperties()) {
                if (!other.hasProperties()) return false;
                else if (!getProperties().equals(other.getProperties())) return false;
            } else if (other.hasProperties()) return false;
            if (hasReadonly()) {
                if (!other.hasReadonly()) return false;
                else if (!getReadonly().equals(other.getReadonly())) return false;
            } else if (other.hasReadonly()) return false;
            if (hasRequires()) {
                if (!other.hasRequires()) return false;
                else if (!getRequires().equals(other.getRequires())) return false;
            } else if (other.hasRequires()) return false;
            if (hasRoot()) {
                if (!other.hasRoot()) return false;
                else if (!getRoot().equals(other.getRoot())) return false;
            } else if (other.hasRoot()) return false;
            if (hasType()) {
                if (!other.hasType()) return false;
                else if (!getType().equals(other.getType())) return false;
            } else if (other.hasType()) return false;
            return true;
        } else if (o instanceof GeneratedHyperSchemaRefable) {
            GeneratedHyperSchemaRefable other = (GeneratedHyperSchemaRefable) o;
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
