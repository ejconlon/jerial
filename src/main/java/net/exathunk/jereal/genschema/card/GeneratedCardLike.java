package net.exathunk.jereal.genschema.card;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.address.GeneratedAddress;
import net.exathunk.jereal.genschema.address.GeneratedAddressContainer;
import net.exathunk.jereal.genschema.geo.GeneratedGeo;
import net.exathunk.jereal.genschema.geo.GeneratedGeoContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public interface GeneratedCardLike {

        boolean hasAdditionalName();
        List<String> getAdditionalName();
        void setAdditionalName(List<String> value);

        boolean hasAdr();
        GeneratedAddressContainer getAdr();
        void setAdr(GeneratedAddressContainer value);

        boolean hasBday();
        String getBday();
        void setBday(String value);

        boolean hasEmail();
        JThing getEmail();
        void setEmail(JThing value);

        boolean hasFamilyName();
        String getFamilyName();
        void setFamilyName(String value);

        boolean hasFn();
        String getFn();
        void setFn(String value);

        boolean hasGeo();
        GeneratedGeoContainer getGeo();
        void setGeo(GeneratedGeoContainer value);

        boolean hasGivenName();
        String getGivenName();
        void setGivenName(String value);

        boolean hasHonorificPrefix();
        List<String> getHonorificPrefix();
        void setHonorificPrefix(List<String> value);

        boolean hasHonorificSuffix();
        List<String> getHonorificSuffix();
        void setHonorificSuffix(List<String> value);

        boolean hasLogo();
        String getLogo();
        void setLogo(String value);

        boolean hasNickname();
        String getNickname();
        void setNickname(String value);

        boolean hasOrg();
        JThing getOrg();
        void setOrg(JThing value);

        boolean hasPhoto();
        String getPhoto();
        void setPhoto(String value);

        boolean hasRole();
        String getRole();
        void setRole(String value);

        boolean hasSound();
        String getSound();
        void setSound(String value);

        boolean hasTel();
        JThing getTel();
        void setTel(JThing value);

        boolean hasTitle();
        String getTitle();
        void setTitle(String value);

        boolean hasTz();
        String getTz();
        void setTz(String value);

        boolean hasUrl();
        String getUrl();
        void setUrl(String value);

}
