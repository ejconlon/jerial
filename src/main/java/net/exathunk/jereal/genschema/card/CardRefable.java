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

public interface CardRefable {

        Ref<List<Ref<String>>> getAdditionalNameRef();

        Ref<AddressContainer> getAdrRef();

        Ref<String> getBdayRef();

        Ref<JThing> getEmailRef();

        Ref<String> getFamilyNameRef();

        Ref<String> getFnRef();

        Ref<GeoContainer> getGeoRef();

        Ref<String> getGivenNameRef();

        Ref<List<Ref<String>>> getHonorificPrefixRef();

        Ref<List<Ref<String>>> getHonorificSuffixRef();

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
