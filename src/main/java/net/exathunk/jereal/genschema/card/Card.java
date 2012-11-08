package net.exathunk.jereal.genschema.card;

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
import net.exathunk.jereal.genschema.address.AddressContainer;
import net.exathunk.jereal.genschema.geo.GeoContainer;

public class Card implements CardLike, CardRefable {

    private final Ref<List<Ref<String>>> additionalName;
    private final Ref<AddressContainer> adr;
    private final Ref<String> bday;
    private final Ref<JThing> email;
    private final Ref<String> familyName;
    private final Ref<String> fn;
    private final Ref<GeoContainer> geo;
    private final Ref<String> givenName;
    private final Ref<List<Ref<String>>> honorificPrefix;
    private final Ref<List<Ref<String>>> honorificSuffix;
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

    public Card() {
        additionalName = new RefImpl<List<Ref<String>>>();
        adr = new RefImpl<AddressContainer>();
        bday = new RefImpl<String>();
        email = new RefImpl<JThing>();
        familyName = new RefImpl<String>();
        fn = new RefImpl<String>();
        geo = new RefImpl<GeoContainer>();
        givenName = new RefImpl<String>();
        honorificPrefix = new RefImpl<List<Ref<String>>>();
        honorificSuffix = new RefImpl<List<Ref<String>>>();
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
    public List<Ref<String>> getAdditionalName() {
        return additionalName.getRef();
    }
    @Override
    public void setAdditionalName(List<Ref<String>> value) {
        additionalName.setRef(value);
    }
    @Override
    public Ref<List<Ref<String>>> getAdditionalNameRef() {
        return additionalName;
    }

    @Override
    public boolean hasAdr() {
        return !adr.isEmptyRef();
    }
    @Override
    public AddressContainer getAdr() {
        return adr.getRef();
    }
    @Override
    public void setAdr(AddressContainer value) {
        adr.setRef(value);
    }
    @Override
    public Ref<AddressContainer> getAdrRef() {
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
    public GeoContainer getGeo() {
        return geo.getRef();
    }
    @Override
    public void setGeo(GeoContainer value) {
        geo.setRef(value);
    }
    @Override
    public Ref<GeoContainer> getGeoRef() {
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
    public List<Ref<String>> getHonorificPrefix() {
        return honorificPrefix.getRef();
    }
    @Override
    public void setHonorificPrefix(List<Ref<String>> value) {
        honorificPrefix.setRef(value);
    }
    @Override
    public Ref<List<Ref<String>>> getHonorificPrefixRef() {
        return honorificPrefix;
    }

    @Override
    public boolean hasHonorificSuffix() {
        return !honorificSuffix.isEmptyRef();
    }
    @Override
    public List<Ref<String>> getHonorificSuffix() {
        return honorificSuffix.getRef();
    }
    @Override
    public void setHonorificSuffix(List<Ref<String>> value) {
        honorificSuffix.setRef(value);
    }
    @Override
    public Ref<List<Ref<String>>> getHonorificSuffixRef() {
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
        StringBuilder sb = new StringBuilder("Card{ ");
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
        if (o instanceof CardRefable) {
            CardRefable other = (CardRefable) o;
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
