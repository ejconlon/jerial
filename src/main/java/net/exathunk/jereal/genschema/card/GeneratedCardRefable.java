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

public interface GeneratedCardRefable {

        Ref<List<String>> getAdditionalNameRef();

        Ref<GeneratedAddressContainer> getAdrRef();

        Ref<String> getBdayRef();

        Ref<JThing> getEmailRef();

        Ref<String> getFamilyNameRef();

        Ref<String> getFnRef();

        Ref<GeneratedGeoContainer> getGeoRef();

        Ref<String> getGivenNameRef();

        Ref<List<String>> getHonorificPrefixRef();

        Ref<List<String>> getHonorificSuffixRef();

        Ref<String> getLogoRef();

        Ref<String> getNicknameRef();

        Ref<JThing> getOrgRef();

        Ref<String> getPhotoRef();

        Ref<String> getRoleRef();

        Ref<String> getSoundRef();

        Ref<JThing> getTelRef();

        Ref<String> getTitleRef();

        Ref<String> getTzRef();

        Ref<String> getUrlRef();

}
