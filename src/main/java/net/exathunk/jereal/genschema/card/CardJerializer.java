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

public class CardJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Card> {

    @Override
    public Card prototype(Speclike spec) {
        return new Card();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Card domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeWritable("additionalName", new RefImpl(recurser.seeCustomRefList(dsl, domain.getAdditionalNameRef(), String.class)));
        objectDSL.seeWritable("adr", new RefImpl(recurser.seeCustom(dsl, domain.getAdrRef(), AddressContainer.class)));
        objectDSL.seeString("bday", domain.getBdayRef());
        objectDSL.seeWritable("email", new RefImpl(recurser.seeThing(dsl, domain.getEmailRef())));
        objectDSL.seeString("familyName", domain.getFamilyNameRef());
        objectDSL.seeString("fn", domain.getFnRef());
        objectDSL.seeWritable("geo", new RefImpl(recurser.seeCustom(dsl, domain.getGeoRef(), GeoContainer.class)));
        objectDSL.seeString("givenName", domain.getGivenNameRef());
        objectDSL.seeWritable("honorificPrefix", new RefImpl(recurser.seeCustomRefList(dsl, domain.getHonorificPrefixRef(), String.class)));
        objectDSL.seeWritable("honorificSuffix", new RefImpl(recurser.seeCustomRefList(dsl, domain.getHonorificSuffixRef(), String.class)));
        objectDSL.seeString("logo", domain.getLogoRef());
        objectDSL.seeString("nickname", domain.getNicknameRef());
        objectDSL.seeWritable("org", new RefImpl(recurser.seeThing(dsl, domain.getOrgRef())));
        objectDSL.seeString("photo", domain.getPhotoRef());
        objectDSL.seeString("role", domain.getRoleRef());
        objectDSL.seeString("sound", domain.getSoundRef());
        objectDSL.seeWritable("tel", new RefImpl(recurser.seeThing(dsl, domain.getTelRef())));
        objectDSL.seeString("title", domain.getTitleRef());
        objectDSL.seeString("tz", domain.getTzRef());
        objectDSL.seeString("url", domain.getUrlRef());
        return objectDSL;
    }

}
