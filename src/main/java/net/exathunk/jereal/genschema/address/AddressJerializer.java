package net.exathunk.jereal.genschema.address;

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

public class AddressJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Address> {

    @Override
    public Address prototype(Speclike spec) {
        return new Address();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Address domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeString("countryName", domain.getCountryNameRef());
        objectDSL.seeString("extendedAddress", domain.getExtendedAddressRef());
        objectDSL.seeString("locality", domain.getLocalityRef());
        objectDSL.seeString("postOfficeBox", domain.getPostOfficeBoxRef());
        objectDSL.seeString("postalCode", domain.getPostalCodeRef());
        objectDSL.seeString("region", domain.getRegionRef());
        objectDSL.seeString("streetAddress", domain.getStreetAddressRef());
        return objectDSL;
    }

}
