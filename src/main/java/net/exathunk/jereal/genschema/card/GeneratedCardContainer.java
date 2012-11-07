package net.exathunk.jereal.genschema.card;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.address.GeneratedAddressContainer;
import net.exathunk.jereal.genschema.geo.GeneratedGeoContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedCardContainer {

    private final Ref<List<String>> additionalName;
    private final Ref<GeneratedAddressContainer> adr;
    private final Ref<String> bday;
    private final Ref<JThing> email;
    private final Ref<String> familyName;
    private final Ref<String> fn;
    private final Ref<GeneratedGeoContainer> geo;
    private final Ref<String> givenName;
    private final Ref<List<String>> honorificPrefix;
    private final Ref<List<String>> honorificSuffix;
    private final Ref<String> logo;
    private final Ref<String> nickname;
    private final Ref<JThing> org;
    private final Ref<String> photo;
    private final Ref<String> role;
    private final Ref<String> sound;
    private final Ref<JThing> tel;
    private final Ref<String> title;
    private final Ref<String> tz;
    private final Ref<String> url;

    public GeneratedCardContainer() {
        additionalName = new RefImpl<List<String>>();
        adr = new RefImpl<GeneratedAddressContainer>();
        bday = new RefImpl<String>();
        email = new RefImpl<JThing>();
        familyName = new RefImpl<String>();
        fn = new RefImpl<String>();
        geo = new RefImpl<GeneratedGeoContainer>();
        givenName = new RefImpl<String>();
        honorificPrefix = new RefImpl<List<String>>();
        honorificSuffix = new RefImpl<List<String>>();
        logo = new RefImpl<String>();
        nickname = new RefImpl<String>();
        org = new RefImpl<JThing>();
        photo = new RefImpl<String>();
        role = new RefImpl<String>();
        sound = new RefImpl<String>();
        tel = new RefImpl<JThing>();
        title = new RefImpl<String>();
        tz = new RefImpl<String>();
        url = new RefImpl<String>();
    }

    public boolean hasAdditionalName() {
        return !additionalName.isEmptyRef();
    }
    public List<String> getAdditionalName() {
        return additionalName.getRef();
    }
    public void setAdditionalName(List<String> value) {
        additionalName.setRef(value);
    }
    public Ref<List<String>> getAdditionalNameRef() {
        return additionalName;
    }

    public boolean hasAdr() {
        return !adr.isEmptyRef();
    }
    public GeneratedAddressContainer getAdr() {
        return adr.getRef();
    }
    public void setAdr(GeneratedAddressContainer value) {
        adr.setRef(value);
    }
    public Ref<GeneratedAddressContainer> getAdrRef() {
        return adr;
    }

    public boolean hasBday() {
        return !bday.isEmptyRef();
    }
    public String getBday() {
        return bday.getRef();
    }
    public void setBday(String value) {
        bday.setRef(value);
    }
    public Ref<String> getBdayRef() {
        return bday;
    }

    public boolean hasEmail() {
        return !email.isEmptyRef();
    }
    public JThing getEmail() {
        return email.getRef();
    }
    public void setEmail(JThing value) {
        email.setRef(value);
    }
    public Ref<JThing> getEmailRef() {
        return email;
    }

    public boolean hasFamilyName() {
        return !familyName.isEmptyRef();
    }
    public String getFamilyName() {
        return familyName.getRef();
    }
    public void setFamilyName(String value) {
        familyName.setRef(value);
    }
    public Ref<String> getFamilyNameRef() {
        return familyName;
    }

    public boolean hasFn() {
        return !fn.isEmptyRef();
    }
    public String getFn() {
        return fn.getRef();
    }
    public void setFn(String value) {
        fn.setRef(value);
    }
    public Ref<String> getFnRef() {
        return fn;
    }

    public boolean hasGeo() {
        return !geo.isEmptyRef();
    }
    public GeneratedGeoContainer getGeo() {
        return geo.getRef();
    }
    public void setGeo(GeneratedGeoContainer value) {
        geo.setRef(value);
    }
    public Ref<GeneratedGeoContainer> getGeoRef() {
        return geo;
    }

    public boolean hasGivenName() {
        return !givenName.isEmptyRef();
    }
    public String getGivenName() {
        return givenName.getRef();
    }
    public void setGivenName(String value) {
        givenName.setRef(value);
    }
    public Ref<String> getGivenNameRef() {
        return givenName;
    }

    public boolean hasHonorificPrefix() {
        return !honorificPrefix.isEmptyRef();
    }
    public List<String> getHonorificPrefix() {
        return honorificPrefix.getRef();
    }
    public void setHonorificPrefix(List<String> value) {
        honorificPrefix.setRef(value);
    }
    public Ref<List<String>> getHonorificPrefixRef() {
        return honorificPrefix;
    }

    public boolean hasHonorificSuffix() {
        return !honorificSuffix.isEmptyRef();
    }
    public List<String> getHonorificSuffix() {
        return honorificSuffix.getRef();
    }
    public void setHonorificSuffix(List<String> value) {
        honorificSuffix.setRef(value);
    }
    public Ref<List<String>> getHonorificSuffixRef() {
        return honorificSuffix;
    }

    public boolean hasLogo() {
        return !logo.isEmptyRef();
    }
    public String getLogo() {
        return logo.getRef();
    }
    public void setLogo(String value) {
        logo.setRef(value);
    }
    public Ref<String> getLogoRef() {
        return logo;
    }

    public boolean hasNickname() {
        return !nickname.isEmptyRef();
    }
    public String getNickname() {
        return nickname.getRef();
    }
    public void setNickname(String value) {
        nickname.setRef(value);
    }
    public Ref<String> getNicknameRef() {
        return nickname;
    }

    public boolean hasOrg() {
        return !org.isEmptyRef();
    }
    public JThing getOrg() {
        return org.getRef();
    }
    public void setOrg(JThing value) {
        org.setRef(value);
    }
    public Ref<JThing> getOrgRef() {
        return org;
    }

    public boolean hasPhoto() {
        return !photo.isEmptyRef();
    }
    public String getPhoto() {
        return photo.getRef();
    }
    public void setPhoto(String value) {
        photo.setRef(value);
    }
    public Ref<String> getPhotoRef() {
        return photo;
    }

    public boolean hasRole() {
        return !role.isEmptyRef();
    }
    public String getRole() {
        return role.getRef();
    }
    public void setRole(String value) {
        role.setRef(value);
    }
    public Ref<String> getRoleRef() {
        return role;
    }

    public boolean hasSound() {
        return !sound.isEmptyRef();
    }
    public String getSound() {
        return sound.getRef();
    }
    public void setSound(String value) {
        sound.setRef(value);
    }
    public Ref<String> getSoundRef() {
        return sound;
    }

    public boolean hasTel() {
        return !tel.isEmptyRef();
    }
    public JThing getTel() {
        return tel.getRef();
    }
    public void setTel(JThing value) {
        tel.setRef(value);
    }
    public Ref<JThing> getTelRef() {
        return tel;
    }

    public boolean hasTitle() {
        return !title.isEmptyRef();
    }
    public String getTitle() {
        return title.getRef();
    }
    public void setTitle(String value) {
        title.setRef(value);
    }
    public Ref<String> getTitleRef() {
        return title;
    }

    public boolean hasTz() {
        return !tz.isEmptyRef();
    }
    public String getTz() {
        return tz.getRef();
    }
    public void setTz(String value) {
        tz.setRef(value);
    }
    public Ref<String> getTzRef() {
        return tz;
    }

    public boolean hasUrl() {
        return !url.isEmptyRef();
    }
    public String getUrl() {
        return url.getRef();
    }
    public void setUrl(String value) {
        url.setRef(value);
    }
    public Ref<String> getUrlRef() {
        return url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedCardContainer{ ");
        if (!additionalName.isEmptyRef()) sb.append("additionalName='").append(additionalName).append("', ");
        if (!adr.isEmptyRef()) sb.append("adr='").append(adr).append("', ");
        if (!bday.isEmptyRef()) sb.append("bday='").append(bday).append("', ");
        if (!email.isEmptyRef()) sb.append("email='").append(email).append("', ");
        if (!familyName.isEmptyRef()) sb.append("familyName='").append(familyName).append("', ");
        if (!fn.isEmptyRef()) sb.append("fn='").append(fn).append("', ");
        if (!geo.isEmptyRef()) sb.append("geo='").append(geo).append("', ");
        if (!givenName.isEmptyRef()) sb.append("givenName='").append(givenName).append("', ");
        if (!honorificPrefix.isEmptyRef()) sb.append("honorificPrefix='").append(honorificPrefix).append("', ");
        if (!honorificSuffix.isEmptyRef()) sb.append("honorificSuffix='").append(honorificSuffix).append("', ");
        if (!logo.isEmptyRef()) sb.append("logo='").append(logo).append("', ");
        if (!nickname.isEmptyRef()) sb.append("nickname='").append(nickname).append("', ");
        if (!org.isEmptyRef()) sb.append("org='").append(org).append("', ");
        if (!photo.isEmptyRef()) sb.append("photo='").append(photo).append("', ");
        if (!role.isEmptyRef()) sb.append("role='").append(role).append("', ");
        if (!sound.isEmptyRef()) sb.append("sound='").append(sound).append("', ");
        if (!tel.isEmptyRef()) sb.append("tel='").append(tel).append("', ");
        if (!title.isEmptyRef()) sb.append("title='").append(title).append("', ");
        if (!tz.isEmptyRef()) sb.append("tz='").append(tz).append("', ");
        if (!url.isEmptyRef()) sb.append("url='").append(url).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedCardContainer) {
            GeneratedCardContainer other = (GeneratedCardContainer) o;
            if (hasAdditionalName()) {
                if (!other.hasAdditionalName()) return false;
                else if (!getAdditionalName().equals(other.getAdditionalName())) return false;
            } else if (other.hasAdditionalName()) return false;
            if (hasAdr()) {
                if (!other.hasAdr()) return false;
                else if (!getAdr().equals(other.getAdr())) return false;
            } else if (other.hasAdr()) return false;
            if (hasBday()) {
                if (!other.hasBday()) return false;
                else if (!getBday().equals(other.getBday())) return false;
            } else if (other.hasBday()) return false;
            if (hasEmail()) {
                if (!other.hasEmail()) return false;
                else if (!getEmail().equals(other.getEmail())) return false;
            } else if (other.hasEmail()) return false;
            if (hasFamilyName()) {
                if (!other.hasFamilyName()) return false;
                else if (!getFamilyName().equals(other.getFamilyName())) return false;
            } else if (other.hasFamilyName()) return false;
            if (hasFn()) {
                if (!other.hasFn()) return false;
                else if (!getFn().equals(other.getFn())) return false;
            } else if (other.hasFn()) return false;
            if (hasGeo()) {
                if (!other.hasGeo()) return false;
                else if (!getGeo().equals(other.getGeo())) return false;
            } else if (other.hasGeo()) return false;
            if (hasGivenName()) {
                if (!other.hasGivenName()) return false;
                else if (!getGivenName().equals(other.getGivenName())) return false;
            } else if (other.hasGivenName()) return false;
            if (hasHonorificPrefix()) {
                if (!other.hasHonorificPrefix()) return false;
                else if (!getHonorificPrefix().equals(other.getHonorificPrefix())) return false;
            } else if (other.hasHonorificPrefix()) return false;
            if (hasHonorificSuffix()) {
                if (!other.hasHonorificSuffix()) return false;
                else if (!getHonorificSuffix().equals(other.getHonorificSuffix())) return false;
            } else if (other.hasHonorificSuffix()) return false;
            if (hasLogo()) {
                if (!other.hasLogo()) return false;
                else if (!getLogo().equals(other.getLogo())) return false;
            } else if (other.hasLogo()) return false;
            if (hasNickname()) {
                if (!other.hasNickname()) return false;
                else if (!getNickname().equals(other.getNickname())) return false;
            } else if (other.hasNickname()) return false;
            if (hasOrg()) {
                if (!other.hasOrg()) return false;
                else if (!getOrg().equals(other.getOrg())) return false;
            } else if (other.hasOrg()) return false;
            if (hasPhoto()) {
                if (!other.hasPhoto()) return false;
                else if (!getPhoto().equals(other.getPhoto())) return false;
            } else if (other.hasPhoto()) return false;
            if (hasRole()) {
                if (!other.hasRole()) return false;
                else if (!getRole().equals(other.getRole())) return false;
            } else if (other.hasRole()) return false;
            if (hasSound()) {
                if (!other.hasSound()) return false;
                else if (!getSound().equals(other.getSound())) return false;
            } else if (other.hasSound()) return false;
            if (hasTel()) {
                if (!other.hasTel()) return false;
                else if (!getTel().equals(other.getTel())) return false;
            } else if (other.hasTel()) return false;
            if (hasTitle()) {
                if (!other.hasTitle()) return false;
                else if (!getTitle().equals(other.getTitle())) return false;
            } else if (other.hasTitle()) return false;
            if (hasTz()) {
                if (!other.hasTz()) return false;
                else if (!getTz().equals(other.getTz())) return false;
            } else if (other.hasTz()) return false;
            if (hasUrl()) {
                if (!other.hasUrl()) return false;
                else if (!getUrl().equals(other.getUrl())) return false;
            } else if (other.hasUrl()) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + additionalName.hashCode();
        result = 31 * result + adr.hashCode();
        result = 31 * result + bday.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + familyName.hashCode();
        result = 31 * result + fn.hashCode();
        result = 31 * result + geo.hashCode();
        result = 31 * result + givenName.hashCode();
        result = 31 * result + honorificPrefix.hashCode();
        result = 31 * result + honorificSuffix.hashCode();
        result = 31 * result + logo.hashCode();
        result = 31 * result + nickname.hashCode();
        result = 31 * result + org.hashCode();
        result = 31 * result + photo.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + sound.hashCode();
        result = 31 * result + tel.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + tz.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

}
