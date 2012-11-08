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

public interface GeneratedAddressLike {

        boolean hasCountryName();
        String getCountryName();
        void setCountryName(String value);

        boolean hasExtendedAddress();
        String getExtendedAddress();
        void setExtendedAddress(String value);

        boolean hasLocality();
        String getLocality();
        void setLocality(String value);

        boolean hasPostOfficeBox();
        String getPostOfficeBox();
        void setPostOfficeBox(String value);

        boolean hasPostalCode();
        String getPostalCode();
        void setPostalCode(String value);

        boolean hasRegion();
        String getRegion();
        void setRegion(String value);

        boolean hasStreetAddress();
        String getStreetAddress();
        void setStreetAddress(String value);

}
