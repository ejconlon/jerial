package net.exathunk.jereal.genschema.address;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.address.GeneratedAddress;
import net.exathunk.jereal.genschema.address.GeneratedAddressContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public interface GeneratedAddressContainerLike {

        boolean hasGeneratedAddress();
        GeneratedAddress getGeneratedAddress();
        void setGeneratedAddress(GeneratedAddress value);

}
