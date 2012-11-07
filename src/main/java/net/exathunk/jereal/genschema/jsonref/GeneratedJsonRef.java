package net.exathunk.jereal.genschema.jsonref;

public class GeneratedJsonRef implements GeneratedJsonRefLike, GeneratedJsonRefRefable {


    public GeneratedJsonRef() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedJsonRef{ ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedJsonRefLike) {
            GeneratedJsonRefLike other = (GeneratedJsonRefLike) o;
            return true;
        } else if (o instanceof GeneratedJsonRefRefable) {
            GeneratedJsonRefRefable other = (GeneratedJsonRefRefable) o;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        return result;
    }

}
