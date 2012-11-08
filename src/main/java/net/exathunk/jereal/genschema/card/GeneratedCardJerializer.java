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
        // dsl.addSomething(domain.getAdrRef());
        // dsl.addSomething(domain.getBdayRef());
        // dsl.addSomething(domain.getEmailRef());
        // dsl.addSomething(domain.getFamilyNameRef());
        // dsl.addSomething(domain.getFnRef());
        // dsl.addSomething(domain.getGeoRef());
        // dsl.addSomething(domain.getGivenNameRef());
        // dsl.addSomething(domain.getHonorificPrefixRef());
        // dsl.addSomething(domain.getHonorificSuffixRef());
        // dsl.addSomething(domain.getLogoRef());
        // dsl.addSomething(domain.getNicknameRef());
        // dsl.addSomething(domain.getOrgRef());
        // dsl.addSomething(domain.getPhotoRef());
        // dsl.addSomething(domain.getRoleRef());
        // dsl.addSomething(domain.getSoundRef());
        // dsl.addSomething(domain.getTelRef());
        // dsl.addSomething(domain.getTitleRef());
        // dsl.addSomething(domain.getTzRef());
        // dsl.addSomething(domain.getUrlRef());
        return null;
    }

}
