package net.exathunk.jereal.genschema.card;

import java.lang.String;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.address.GeneratedAddressContainer;
import net.exathunk.jereal.genschema.geo.GeneratedGeoContainer;

public class GeneratedCardJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedCard> {

    @Override
    public GeneratedCard prototype(Speclike spec) {
        return new GeneratedCard();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedCard domain) throws JerializerException {
        // dsl.addSomething(domain.getAdditionalNameRef());
        recurser.seeCustom(dsl, domain.getAdrRef(), GeneratedAddressContainer.class);
        dsl.seeString(domain.getBdayRef());
        recurser.seeThing(dsl, domain.getEmailRef());
        dsl.seeString(domain.getFamilyNameRef());
        dsl.seeString(domain.getFnRef());
        recurser.seeCustom(dsl, domain.getGeoRef(), GeneratedGeoContainer.class);
        dsl.seeString(domain.getGivenNameRef());
        // dsl.addSomething(domain.getHonorificPrefixRef());
        // dsl.addSomething(domain.getHonorificSuffixRef());
        dsl.seeString(domain.getLogoRef());
        dsl.seeString(domain.getNicknameRef());
        recurser.seeThing(dsl, domain.getOrgRef());
        dsl.seeString(domain.getPhotoRef());
        dsl.seeString(domain.getRoleRef());
        dsl.seeString(domain.getSoundRef());
        recurser.seeThing(dsl, domain.getTelRef());
        dsl.seeString(domain.getTitleRef());
        dsl.seeString(domain.getTzRef());
        dsl.seeString(domain.getUrlRef());
        return null;
    }

}
