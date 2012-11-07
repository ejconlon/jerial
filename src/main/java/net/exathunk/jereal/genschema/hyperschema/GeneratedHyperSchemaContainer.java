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

public class GeneratedHyperSchemaContainer {

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

    public GeneratedHyperSchemaContainer() {
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

    public boolean hasAdditionalItems() {
        return !additionalItems.isEmptyRef();
    }
    public Any2<GeneratedHyperSchemaOrUriContainer,Boolean> getAdditionalItems() {
        return additionalItems.getRef();
    }
    public void setAdditionalItems(Any2<GeneratedHyperSchemaOrUriContainer,Boolean> value) {
        additionalItems.setRef(value);
    }
    public Ref<Any2<GeneratedHyperSchemaOrUriContainer,Boolean>> getAdditionalItemsRef() {
        return additionalItems;
    }

    public boolean hasAdditionalProperties() {
        return !additionalProperties.isEmptyRef();
    }
    public Any2<GeneratedHyperSchemaOrUriContainer,Boolean> getAdditionalProperties() {
        return additionalProperties.getRef();
    }
    public void setAdditionalProperties(Any2<GeneratedHyperSchemaOrUriContainer,Boolean> value) {
        additionalProperties.setRef(value);
    }
    public Ref<Any2<GeneratedHyperSchemaOrUriContainer,Boolean>> getAdditionalPropertiesRef() {
        return additionalProperties;
    }

    public boolean hasAlternate() {
        return !alternate.isEmptyRef();
    }
    public List<GeneratedHyperSchemaOrUriContainer> getAlternate() {
        return alternate.getRef();
    }
    public void setAlternate(List<GeneratedHyperSchemaOrUriContainer> value) {
        alternate.setRef(value);
    }
    public Ref<List<GeneratedHyperSchemaOrUriContainer>> getAlternateRef() {
        return alternate;
    }

    public boolean hasContentEncoding() {
        return !contentEncoding.isEmptyRef();
    }
    public String getContentEncoding() {
        return contentEncoding.getRef();
    }
    public void setContentEncoding(String value) {
        contentEncoding.setRef(value);
    }
    public Ref<String> getContentEncodingRef() {
        return contentEncoding;
    }

    public boolean hasDefaultField() {
        return !defaultField.isEmptyRef();
    }
    public JThing getDefaultField() {
        return defaultField.getRef();
    }
    public void setDefaultField(JThing value) {
        defaultField.setRef(value);
    }
    public Ref<JThing> getDefaultFieldRef() {
        return defaultField;
    }

    public boolean hasDisallow() {
        return !disallow.isEmptyRef();
    }
    public Any3<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>,GeneratedHyperSchemaOrUriContainer> getDisallow() {
        return disallow.getRef();
    }
    public void setDisallow(Any3<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>,GeneratedHyperSchemaOrUriContainer> value) {
        disallow.setRef(value);
    }
    public Ref<Any3<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>,GeneratedHyperSchemaOrUriContainer>> getDisallowRef() {
        return disallow;
    }

    public boolean hasExtendsField() {
        return !extendsField.isEmptyRef();
    }
    public Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>> getExtendsField() {
        return extendsField.getRef();
    }
    public void setExtendsField(Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>> value) {
        extendsField.setRef(value);
    }
    public Ref<Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>>> getExtendsFieldRef() {
        return extendsField;
    }

    public boolean hasFragmentResolution() {
        return !fragmentResolution.isEmptyRef();
    }
    public String getFragmentResolution() {
        return fragmentResolution.getRef();
    }
    public void setFragmentResolution(String value) {
        fragmentResolution.setRef(value);
    }
    public Ref<String> getFragmentResolutionRef() {
        return fragmentResolution;
    }

    public boolean hasItems() {
        return !items.isEmptyRef();
    }
    public Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>> getItems() {
        return items.getRef();
    }
    public void setItems(Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>> value) {
        items.setRef(value);
    }
    public Ref<Any2<GeneratedHyperSchemaOrUriContainer,List<GeneratedHyperSchemaOrUriContainer>>> getItemsRef() {
        return items;
    }

    public boolean hasLinks() {
        return !links.isEmptyRef();
    }
    public List<GeneratedLinksContainer> getLinks() {
        return links.getRef();
    }
    public void setLinks(List<GeneratedLinksContainer> value) {
        links.setRef(value);
    }
    public Ref<List<GeneratedLinksContainer>> getLinksRef() {
        return links;
    }

    public boolean hasMediaType() {
        return !mediaType.isEmptyRef();
    }
    public String getMediaType() {
        return mediaType.getRef();
    }
    public void setMediaType(String value) {
        mediaType.setRef(value);
    }
    public Ref<String> getMediaTypeRef() {
        return mediaType;
    }

    public boolean hasPathStart() {
        return !pathStart.isEmptyRef();
    }
    public String getPathStart() {
        return pathStart.getRef();
    }
    public void setPathStart(String value) {
        pathStart.setRef(value);
    }
    public Ref<String> getPathStartRef() {
        return pathStart;
    }

    public boolean hasProperties() {
        return !properties.isEmptyRef();
    }
    public JThing getProperties() {
        return properties.getRef();
    }
    public void setProperties(JThing value) {
        properties.setRef(value);
    }
    public Ref<JThing> getPropertiesRef() {
        return properties;
    }

    public boolean hasReadonly() {
        return !readonly.isEmptyRef();
    }
    public Boolean getReadonly() {
        return readonly.getRef();
    }
    public void setReadonly(Boolean value) {
        readonly.setRef(value);
    }
    public Ref<Boolean> getReadonlyRef() {
        return readonly;
    }

    public boolean hasRequires() {
        return !requires.isEmptyRef();
    }
    public Any2<String,GeneratedHyperSchemaOrUriContainer> getRequires() {
        return requires.getRef();
    }
    public void setRequires(Any2<String,GeneratedHyperSchemaOrUriContainer> value) {
        requires.setRef(value);
    }
    public Ref<Any2<String,GeneratedHyperSchemaOrUriContainer>> getRequiresRef() {
        return requires;
    }

    public boolean hasRoot() {
        return !root.isEmptyRef();
    }
    public Boolean getRoot() {
        return root.getRef();
    }
    public void setRoot(Boolean value) {
        root.setRef(value);
    }
    public Ref<Boolean> getRootRef() {
        return root;
    }

    public boolean hasType() {
        return !type.isEmptyRef();
    }
    public Any2<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>> getType() {
        return type.getRef();
    }
    public void setType(Any2<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>> value) {
        type.setRef(value);
    }
    public Ref<Any2<String,List<Any2<String,GeneratedHyperSchemaOrUriContainer>>>> getTypeRef() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedHyperSchemaContainer{ ");
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
        if (o instanceof GeneratedHyperSchemaContainer) {
            GeneratedHyperSchemaContainer other = (GeneratedHyperSchemaContainer) o;
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
