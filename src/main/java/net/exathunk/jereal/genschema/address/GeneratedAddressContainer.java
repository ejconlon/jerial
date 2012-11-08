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
import net.exathunk.jereal.genschema.address.GeneratedAddress;
import net.exathunk.jereal.genschema.address.GeneratedAddressContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedAddressContainer implements GeneratedAddressContainerLike, GeneratedAddressContainerRefable {

    private final Ref<GeneratedAddress> GeneratedAddress;

    public GeneratedAddressContainer() {
        GeneratedAddress = new RefImpl<GeneratedAddress>();
    }

    @Override
    public boolean hasGeneratedAddress() {
        return !GeneratedAddress.isEmptyRef();
    }
    @Override
    public GeneratedAddress getGeneratedAddress() {
        return GeneratedAddress.getRef();
    }
    @Override
    public void setGeneratedAddress(GeneratedAddress value) {
        GeneratedAddress.setRef(value);
    }
    @Override
    public Ref<GeneratedAddress> getGeneratedAddressRef() {
        return GeneratedAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedAddressContainer{ ");
        if (!GeneratedAddress.isEmptyRef()) sb.append("GeneratedAddress='").append(GeneratedAddress).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedAddressContainerLike) {
            GeneratedAddressContainerLike other = (GeneratedAddressContainerLike) o;
            if (hasGeneratedAddress()) {
                if (!other.hasGeneratedAddress()) return false;
                else if (!getGeneratedAddress().equals(other.getGeneratedAddress())) return false;
            } else if (other.hasGeneratedAddress()) return false;
            return true;
        } else if (o instanceof GeneratedAddressContainerRefable) {
            GeneratedAddressContainerRefable other = (GeneratedAddressContainerRefable) o;
            if (!getGeneratedAddressRef().equals(other.getGeneratedAddressRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + GeneratedAddress.hashCode();
        return result;
    }

}
