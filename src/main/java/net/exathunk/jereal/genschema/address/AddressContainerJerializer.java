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
import net.exathunk.jereal.genschema.address.Address;

public class AddressContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, AddressContainer> {

    @Override
    public AddressContainer prototype(Speclike spec) {
        return new AddressContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, AddressContainer domain) throws JerializerException {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeWritable("address", new RefImpl(recurser.seeCustom(dsl, domain.getAddressRef(), Address.class)));
        return objectDSL;
    }

}