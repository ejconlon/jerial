package net.exathunk.jereal.genschema.card;

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
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.address.*;
import net.exathunk.jereal.genschema.geo.*;

public interface CardLike {

        boolean hasAdditionalName();
        List<Ref<String>> getAdditionalName();
        void setAdditionalName(List<Ref<String>> value);

        boolean hasAdr();
        AddressContainer getAdr();
        void setAdr(AddressContainer value);

        boolean hasBday();
        String getBday();
        void setBday(String value);

        boolean hasEmail();
        Map<String,Ref<JThing>> getEmail();
        void setEmail(Map<String,Ref<JThing>> value);

        boolean hasFamilyName();
        String getFamilyName();
        void setFamilyName(String value);

        boolean hasFn();
        String getFn();
        void setFn(String value);

        boolean hasGeo();
        GeoContainer getGeo();
        void setGeo(GeoContainer value);

        boolean hasGivenName();
        String getGivenName();
        void setGivenName(String value);

        boolean hasHonorificPrefix();
        List<Ref<String>> getHonorificPrefix();
        void setHonorificPrefix(List<Ref<String>> value);

        boolean hasHonorificSuffix();
        List<Ref<String>> getHonorificSuffix();
        void setHonorificSuffix(List<Ref<String>> value);

        boolean hasLogo();
        String getLogo();
        void setLogo(String value);

        boolean hasNickname();
        String getNickname();
        void setNickname(String value);

        boolean hasOrg();
        Map<String,Ref<JThing>> getOrg();
        void setOrg(Map<String,Ref<JThing>> value);

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
        Map<String,Ref<JThing>> getTel();
        void setTel(Map<String,Ref<JThing>> value);

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
