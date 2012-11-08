package net.exathunk.jereal.genschema.address;

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

public class GeneratedAddressJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedAddress> {

    @Override
    public GeneratedAddress prototype(Speclike spec) {
        return new GeneratedAddress();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedAddress domain) throws JerializerException {
        dsl.seeString(domain.getCountryNameRef());
        dsl.seeString(domain.getExtendedAddressRef());
        dsl.seeString(domain.getLocalityRef());
        dsl.seeString(domain.getPostOfficeBoxRef());
        dsl.seeString(domain.getPostalCodeRef());
        dsl.seeString(domain.getRegionRef());
        dsl.seeString(domain.getStreetAddressRef());
        return null;
    }

}
