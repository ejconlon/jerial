package net.exathunk.jereal.genschema.address;

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
import net.exathunk.jereal.base.gen.*;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.address.*;

public class AddressContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, AddressContainer> {

    @Override
    public AddressContainer prototype(Speclike spec) throws JerializerException {
        return new AddressContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, AddressContainer domain) throws JerializerException {
        return (new AddressJerializer()).jerialize(recurser, dsl, domain.getAddressRef().getRef());
    }

}
