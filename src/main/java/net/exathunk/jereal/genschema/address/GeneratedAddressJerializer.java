package net.exathunk.jereal.genschema.address;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedAddressJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, GeneratedAddress> {

    @Override
    public GeneratedAddress prototype(Speclike spec) {
        return new GeneratedAddress();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, GeneratedAddress domain) throws JerializerException {
        // dsl.addSomething(domain.getCountryNameRef());
        // dsl.addSomething(domain.getExtendedAddressRef());
        // dsl.addSomething(domain.getLocalityRef());
        // dsl.addSomething(domain.getPostOfficeBoxRef());
        // dsl.addSomething(domain.getPostalCodeRef());
        // dsl.addSomething(domain.getRegionRef());
        // dsl.addSomething(domain.getStreetAddressRef());
        return null;
    }

}
