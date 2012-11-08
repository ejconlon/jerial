package net.exathunk.jereal.genschema.card;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.address.GeneratedAddress;
import net.exathunk.jereal.genschema.address.GeneratedAddressContainer;
import net.exathunk.jereal.genschema.geo.GeneratedGeo;
import net.exathunk.jereal.genschema.geo.GeneratedGeoContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedCard implements GeneratedCardLike, GeneratedCardRefable {

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

    public GeneratedCard() {
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

    @Override
    public boolean hasAdditionalName() {
        return !additionalName.isEmptyRef();
    }
    @Override
    public List<String> getAdditionalName() {
        return additionalName.getRef();
    }
    @Override
    public void setAdditionalName(List<String> value) {
        additionalName.setRef(value);
    }
    @Override
    public Ref<List<String>> getAdditionalNameRef() {
        return additionalName;
    }

    @Override
    public boolean hasAdr() {
        return !adr.isEmptyRef();
    }
    @Override
    public GeneratedAddressContainer getAdr() {
        return adr.getRef();
    }
    @Override
    public void setAdr(GeneratedAddressContainer value) {
        adr.setRef(value);
    }
    @Override
    public Ref<GeneratedAddressContainer> getAdrRef() {
        return adr;
    }

    @Override
    public boolean hasBday() {
        return !bday.isEmptyRef();
    }
    @Override
    public String getBday() {
        return bday.getRef();
    }
    @Override
    public void setBday(String value) {
        bday.setRef(value);
    }
    @Override
    public Ref<String> getBdayRef() {
        return bday;
    }

    @Override
    public boolean hasEmail() {
        return !email.isEmptyRef();
    }
    @Override
    public JThing getEmail() {
        return email.getRef();
    }
    @Override
    public void setEmail(JThing value) {
        email.setRef(value);
    }
    @Override
    public Ref<JThing> getEmailRef() {
        return email;
    }

    @Override
    public boolean hasFamilyName() {
        return !familyName.isEmptyRef();
    }
    @Override
    public String getFamilyName() {
        return familyName.getRef();
    }
    @Override
    public void setFamilyName(String value) {
        familyName.setRef(value);
    }
    @Override
    public Ref<String> getFamilyNameRef() {
        return familyName;
    }

    @Override
    public boolean hasFn() {
        return !fn.isEmptyRef();
    }
    @Override
    public String getFn() {
        return fn.getRef();
    }
    @Override
    public void setFn(String value) {
        fn.setRef(value);
    }
    @Override
    public Ref<String> getFnRef() {
        return fn;
    }

    @Override
    public boolean hasGeo() {
        return !geo.isEmptyRef();
    }
    @Override
    public GeneratedGeoContainer getGeo() {
        return geo.getRef();
    }
    @Override
    public void setGeo(GeneratedGeoContainer value) {
        geo.setRef(value);
    }
    @Override
    public Ref<GeneratedGeoContainer> getGeoRef() {
        return geo;
    }

    @Override
    public boolean hasGivenName() {
        return !givenName.isEmptyRef();
    }
    @Override
    public String getGivenName() {
        return givenName.getRef();
    }
    @Override
    public void setGivenName(String value) {
        givenName.setRef(value);
    }
    @Override
    public Ref<String> getGivenNameRef() {
        return givenName;
    }

    @Override
    public boolean hasHonorificPrefix() {
        return !honorificPrefix.isEmptyRef();
    }
    @Override
    public List<String> getHonorificPrefix() {
        return honorificPrefix.getRef();
    }
    @Override
    public void setHonorificPrefix(List<String> value) {
        honorificPrefix.setRef(value);
    }
    @Override
    public Ref<List<String>> getHonorificPrefixRef() {
        return honorificPrefix;
    }

    @Override
    public boolean hasHonorificSuffix() {
        return !honorificSuffix.isEmptyRef();
    }
    @Override
    public List<String> getHonorificSuffix() {
        return honorificSuffix.getRef();
    }
    @Override
    public void setHonorificSuffix(List<String> value) {
        honorificSuffix.setRef(value);
    }
    @Override
    public Ref<List<String>> getHonorificSuffixRef() {
        return honorificSuffix;
    }

    @Override
    public boolean hasLogo() {
        return !logo.isEmptyRef();
    }
    @Override
    public String getLogo() {
        return logo.getRef();
    }
    @Override
    public void setLogo(String value) {
        logo.setRef(value);
    }
    @Override
    public Ref<String> getLogoRef() {
        return logo;
    }

    @Override
    public boolean hasNickname() {
        return !nickname.isEmptyRef();
    }
    @Override
    public String getNickname() {
        return nickname.getRef();
    }
    @Override
    public void setNickname(String value) {
        nickname.setRef(value);
    }
    @Override
    public Ref<String> getNicknameRef() {
        return nickname;
    }

    @Override
    public boolean hasOrg() {
        return !org.isEmptyRef();
    }
    @Override
    public JThing getOrg() {
        return org.getRef();
    }
    @Override
    public void setOrg(JThing value) {
        org.setRef(value);
    }
    @Override
    public Ref<JThing> getOrgRef() {
        return org;
    }

    @Override
    public boolean hasPhoto() {
        return !photo.isEmptyRef();
    }
    @Override
    public String getPhoto() {
        return photo.getRef();
    }
    @Override
    public void setPhoto(String value) {
        photo.setRef(value);
    }
    @Override
    public Ref<String> getPhotoRef() {
        return photo;
    }

    @Override
    public boolean hasRole() {
        return !role.isEmptyRef();
    }
    @Override
    public String getRole() {
        return role.getRef();
    }
    @Override
    public void setRole(String value) {
        role.setRef(value);
    }
    @Override
    public Ref<String> getRoleRef() {
        return role;
    }

    @Override
    public boolean hasSound() {
        return !sound.isEmptyRef();
    }
    @Override
    public String getSound() {
        return sound.getRef();
    }
    @Override
    public void setSound(String value) {
        sound.setRef(value);
    }
    @Override
    public Ref<String> getSoundRef() {
        return sound;
    }

    @Override
    public boolean hasTel() {
        return !tel.isEmptyRef();
    }
    @Override
    public JThing getTel() {
        return tel.getRef();
    }
    @Override
    public void setTel(JThing value) {
        tel.setRef(value);
    }
    @Override
    public Ref<JThing> getTelRef() {
        return tel;
    }

    @Override
    public boolean hasTitle() {
        return !title.isEmptyRef();
    }
    @Override
    public String getTitle() {
        return title.getRef();
    }
    @Override
    public void setTitle(String value) {
        title.setRef(value);
    }
    @Override
    public Ref<String> getTitleRef() {
        return title;
    }

    @Override
    public boolean hasTz() {
        return !tz.isEmptyRef();
    }
    @Override
    public String getTz() {
        return tz.getRef();
    }
    @Override
    public void setTz(String value) {
        tz.setRef(value);
    }
    @Override
    public Ref<String> getTzRef() {
        return tz;
    }

    @Override
    public boolean hasUrl() {
        return !url.isEmptyRef();
    }
    @Override
    public String getUrl() {
        return url.getRef();
    }
    @Override
    public void setUrl(String value) {
        url.setRef(value);
    }
    @Override
    public Ref<String> getUrlRef() {
        return url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedCard{ ");
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
        if (o instanceof GeneratedCardLike) {
            GeneratedCardLike other = (GeneratedCardLike) o;
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
        } else if (o instanceof GeneratedCardRefable) {
            GeneratedCardRefable other = (GeneratedCardRefable) o;
            if (!getAdditionalNameRef().equals(other.getAdditionalNameRef())) return false;
            if (!getAdrRef().equals(other.getAdrRef())) return false;
            if (!getBdayRef().equals(other.getBdayRef())) return false;
            if (!getEmailRef().equals(other.getEmailRef())) return false;
            if (!getFamilyNameRef().equals(other.getFamilyNameRef())) return false;
            if (!getFnRef().equals(other.getFnRef())) return false;
            if (!getGeoRef().equals(other.getGeoRef())) return false;
            if (!getGivenNameRef().equals(other.getGivenNameRef())) return false;
            if (!getHonorificPrefixRef().equals(other.getHonorificPrefixRef())) return false;
            if (!getHonorificSuffixRef().equals(other.getHonorificSuffixRef())) return false;
            if (!getLogoRef().equals(other.getLogoRef())) return false;
            if (!getNicknameRef().equals(other.getNicknameRef())) return false;
            if (!getOrgRef().equals(other.getOrgRef())) return false;
            if (!getPhotoRef().equals(other.getPhotoRef())) return false;
            if (!getRoleRef().equals(other.getRoleRef())) return false;
            if (!getSoundRef().equals(other.getSoundRef())) return false;
            if (!getTelRef().equals(other.getTelRef())) return false;
            if (!getTitleRef().equals(other.getTitleRef())) return false;
            if (!getTzRef().equals(other.getTzRef())) return false;
            if (!getUrlRef().equals(other.getUrlRef())) return false;
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
