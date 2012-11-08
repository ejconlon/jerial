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

public class Address implements AddressLike, AddressRefable {

    private final Ref<String> countryName;
    private final Ref<String> extendedAddress;
    private final Ref<String> locality;
    private final Ref<String> postOfficeBox;
    private final Ref<String> postalCode;
    private final Ref<String> region;
    private final Ref<String> streetAddress;

    public Address() {
        countryName = new RefImpl<String>();
        extendedAddress = new RefImpl<String>();
        locality = new RefImpl<String>();
        postOfficeBox = new RefImpl<String>();
        postalCode = new RefImpl<String>();
        region = new RefImpl<String>();
        streetAddress = new RefImpl<String>();
    }

    @Override
    public boolean hasCountryName() {
        return !countryName.isEmptyRef();
    }
    @Override
    public String getCountryName() {
        return countryName.getRef();
    }
    @Override
    public void setCountryName(String value) {
        countryName.setRef(value);
    }
    @Override
    public Ref<String> getCountryNameRef() {
        return countryName;
    }

    @Override
    public boolean hasExtendedAddress() {
        return !extendedAddress.isEmptyRef();
    }
    @Override
    public String getExtendedAddress() {
        return extendedAddress.getRef();
    }
    @Override
    public void setExtendedAddress(String value) {
        extendedAddress.setRef(value);
    }
    @Override
    public Ref<String> getExtendedAddressRef() {
        return extendedAddress;
    }

    @Override
    public boolean hasLocality() {
        return !locality.isEmptyRef();
    }
    @Override
    public String getLocality() {
        return locality.getRef();
    }
    @Override
    public void setLocality(String value) {
        locality.setRef(value);
    }
    @Override
    public Ref<String> getLocalityRef() {
        return locality;
    }

    @Override
    public boolean hasPostOfficeBox() {
        return !postOfficeBox.isEmptyRef();
    }
    @Override
    public String getPostOfficeBox() {
        return postOfficeBox.getRef();
    }
    @Override
    public void setPostOfficeBox(String value) {
        postOfficeBox.setRef(value);
    }
    @Override
    public Ref<String> getPostOfficeBoxRef() {
        return postOfficeBox;
    }

    @Override
    public boolean hasPostalCode() {
        return !postalCode.isEmptyRef();
    }
    @Override
    public String getPostalCode() {
        return postalCode.getRef();
    }
    @Override
    public void setPostalCode(String value) {
        postalCode.setRef(value);
    }
    @Override
    public Ref<String> getPostalCodeRef() {
        return postalCode;
    }

    @Override
    public boolean hasRegion() {
        return !region.isEmptyRef();
    }
    @Override
    public String getRegion() {
        return region.getRef();
    }
    @Override
    public void setRegion(String value) {
        region.setRef(value);
    }
    @Override
    public Ref<String> getRegionRef() {
        return region;
    }

    @Override
    public boolean hasStreetAddress() {
        return !streetAddress.isEmptyRef();
    }
    @Override
    public String getStreetAddress() {
        return streetAddress.getRef();
    }
    @Override
    public void setStreetAddress(String value) {
        streetAddress.setRef(value);
    }
    @Override
    public Ref<String> getStreetAddressRef() {
        return streetAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Address{ ");
        if (!countryName.isEmptyRef()) sb.append("countryName='").append(countryName).append("', ");
        if (!extendedAddress.isEmptyRef()) sb.append("extendedAddress='").append(extendedAddress).append("', ");
        if (!locality.isEmptyRef()) sb.append("locality='").append(locality).append("', ");
        if (!postOfficeBox.isEmptyRef()) sb.append("postOfficeBox='").append(postOfficeBox).append("', ");
        if (!postalCode.isEmptyRef()) sb.append("postalCode='").append(postalCode).append("', ");
        if (!region.isEmptyRef()) sb.append("region='").append(region).append("', ");
        if (!streetAddress.isEmptyRef()) sb.append("streetAddress='").append(streetAddress).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof AddressRefable) {
            AddressRefable other = (AddressRefable) o;
            if (!getCountryNameRef().equals(other.getCountryNameRef())) return false;
            if (!getExtendedAddressRef().equals(other.getExtendedAddressRef())) return false;
            if (!getLocalityRef().equals(other.getLocalityRef())) return false;
            if (!getPostOfficeBoxRef().equals(other.getPostOfficeBoxRef())) return false;
            if (!getPostalCodeRef().equals(other.getPostalCodeRef())) return false;
            if (!getRegionRef().equals(other.getRegionRef())) return false;
            if (!getStreetAddressRef().equals(other.getStreetAddressRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + countryName.hashCode();
        result = 31 * result + extendedAddress.hashCode();
        result = 31 * result + locality.hashCode();
        result = 31 * result + postOfficeBox.hashCode();
        result = 31 * result + postalCode.hashCode();
        result = 31 * result + region.hashCode();
        result = 31 * result + streetAddress.hashCode();
        return result;
    }

}
