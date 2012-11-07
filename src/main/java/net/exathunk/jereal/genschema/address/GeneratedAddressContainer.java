package net.exathunk.jereal.genschema.address;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedAddressContainer {

    private final Ref<String> countryName;
    private final Ref<String> extendedAddress;
    private final Ref<String> locality;
    private final Ref<String> postOfficeBox;
    private final Ref<String> postalCode;
    private final Ref<String> region;
    private final Ref<String> streetAddress;

    public GeneratedAddressContainer() {
        countryName = new RefImpl<String>();
        extendedAddress = new RefImpl<String>();
        locality = new RefImpl<String>();
        postOfficeBox = new RefImpl<String>();
        postalCode = new RefImpl<String>();
        region = new RefImpl<String>();
        streetAddress = new RefImpl<String>();
    }

    public boolean hasCountryName() {
        return !countryName.isEmptyRef();
    }
    public String getCountryName() {
        return countryName.getRef();
    }
    public void setCountryName(String value) {
        countryName.setRef(value);
    }
    public Ref<String> getCountryNameRef() {
        return countryName;
    }

    public boolean hasExtendedAddress() {
        return !extendedAddress.isEmptyRef();
    }
    public String getExtendedAddress() {
        return extendedAddress.getRef();
    }
    public void setExtendedAddress(String value) {
        extendedAddress.setRef(value);
    }
    public Ref<String> getExtendedAddressRef() {
        return extendedAddress;
    }

    public boolean hasLocality() {
        return !locality.isEmptyRef();
    }
    public String getLocality() {
        return locality.getRef();
    }
    public void setLocality(String value) {
        locality.setRef(value);
    }
    public Ref<String> getLocalityRef() {
        return locality;
    }

    public boolean hasPostOfficeBox() {
        return !postOfficeBox.isEmptyRef();
    }
    public String getPostOfficeBox() {
        return postOfficeBox.getRef();
    }
    public void setPostOfficeBox(String value) {
        postOfficeBox.setRef(value);
    }
    public Ref<String> getPostOfficeBoxRef() {
        return postOfficeBox;
    }

    public boolean hasPostalCode() {
        return !postalCode.isEmptyRef();
    }
    public String getPostalCode() {
        return postalCode.getRef();
    }
    public void setPostalCode(String value) {
        postalCode.setRef(value);
    }
    public Ref<String> getPostalCodeRef() {
        return postalCode;
    }

    public boolean hasRegion() {
        return !region.isEmptyRef();
    }
    public String getRegion() {
        return region.getRef();
    }
    public void setRegion(String value) {
        region.setRef(value);
    }
    public Ref<String> getRegionRef() {
        return region;
    }

    public boolean hasStreetAddress() {
        return !streetAddress.isEmptyRef();
    }
    public String getStreetAddress() {
        return streetAddress.getRef();
    }
    public void setStreetAddress(String value) {
        streetAddress.setRef(value);
    }
    public Ref<String> getStreetAddressRef() {
        return streetAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedAddressContainer{ ");
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
        if (o instanceof GeneratedAddressContainer) {
            GeneratedAddressContainer other = (GeneratedAddressContainer) o;
            if (hasCountryName()) {
                if (!other.hasCountryName()) return false;
                else if (!getCountryName().equals(other.getCountryName())) return false;
            } else if (other.hasCountryName()) return false;
            if (hasExtendedAddress()) {
                if (!other.hasExtendedAddress()) return false;
                else if (!getExtendedAddress().equals(other.getExtendedAddress())) return false;
            } else if (other.hasExtendedAddress()) return false;
            if (hasLocality()) {
                if (!other.hasLocality()) return false;
                else if (!getLocality().equals(other.getLocality())) return false;
            } else if (other.hasLocality()) return false;
            if (hasPostOfficeBox()) {
                if (!other.hasPostOfficeBox()) return false;
                else if (!getPostOfficeBox().equals(other.getPostOfficeBox())) return false;
            } else if (other.hasPostOfficeBox()) return false;
            if (hasPostalCode()) {
                if (!other.hasPostalCode()) return false;
                else if (!getPostalCode().equals(other.getPostalCode())) return false;
            } else if (other.hasPostalCode()) return false;
            if (hasRegion()) {
                if (!other.hasRegion()) return false;
                else if (!getRegion().equals(other.getRegion())) return false;
            } else if (other.hasRegion()) return false;
            if (hasStreetAddress()) {
                if (!other.hasStreetAddress()) return false;
                else if (!getStreetAddress().equals(other.getStreetAddress())) return false;
            } else if (other.hasStreetAddress()) return false;
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
