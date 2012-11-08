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
import net.exathunk.jereal.genschema.address.Address;

public class AddressContainer implements AddressContainerLike, AddressContainerRefable {

    private final Ref<Address> address;

    public AddressContainer() {
        address = new RefImpl<Address>();
    }

    @Override
    public boolean hasAddress() {
        return !address.isEmptyRef();
    }
    @Override
    public Address getAddress() {
        return address.getRef();
    }
    @Override
    public void setAddress(Address value) {
        address.setRef(value);
    }
    @Override
    public Ref<Address> getAddressRef() {
        return address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AddressContainer{ ");
        if (!address.isEmptyRef()) sb.append("address='").append(address).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof AddressContainerLike) {
            AddressContainerLike other = (AddressContainerLike) o;
            if (hasAddress()) {
                if (!other.hasAddress()) return false;
                else if (!getAddress().equals(other.getAddress())) return false;
            } else if (other.hasAddress()) return false;
            return true;
        } else if (o instanceof AddressContainerRefable) {
            AddressContainerRefable other = (AddressContainerRefable) o;
            if (!getAddressRef().equals(other.getAddressRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + address.hashCode();
        return result;
    }

}
