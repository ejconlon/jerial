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
import net.exathunk.jereal.genschema.address.GeneratedAddress;

public class GeneratedAddressContainer implements GeneratedAddressContainerLike, GeneratedAddressContainerRefable {

    private final Ref<GeneratedAddress> generatedAddress;

    public GeneratedAddressContainer() {
        generatedAddress = new RefImpl<GeneratedAddress>();
    }

    @Override
    public boolean hasGeneratedAddress() {
        return !generatedAddress.isEmptyRef();
    }
    @Override
    public GeneratedAddress getGeneratedAddress() {
        return generatedAddress.getRef();
    }
    @Override
    public void setGeneratedAddress(GeneratedAddress value) {
        generatedAddress.setRef(value);
    }
    @Override
    public Ref<GeneratedAddress> getGeneratedAddressRef() {
        return generatedAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedAddressContainer{ ");
        if (!generatedAddress.isEmptyRef()) sb.append("generatedAddress='").append(generatedAddress).append("', ");
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
        result = 31 * result + generatedAddress.hashCode();
        return result;
    }

}
