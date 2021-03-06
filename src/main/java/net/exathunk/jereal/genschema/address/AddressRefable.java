package net.exathunk.jereal.genschema.address;

import java.lang.*;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;

public interface AddressRefable {

        Ref<String> getCountryNameRef();

        Ref<String> getExtendedAddressRef();

        Ref<String> getLocalityRef();

        Ref<String> getPostOfficeBoxRef();

        Ref<String> getPostalCodeRef();

        Ref<String> getRegionRef();

        Ref<String> getStreetAddressRef();

}
