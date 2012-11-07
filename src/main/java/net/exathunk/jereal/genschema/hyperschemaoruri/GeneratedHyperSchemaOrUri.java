package net.exathunk.jereal.genschema.hyperschemaoruri;

public class GeneratedHyperSchemaOrUri implements GeneratedHyperSchemaOrUriLike, GeneratedHyperSchemaOrUriRefable {


    public GeneratedHyperSchemaOrUri() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedHyperSchemaOrUri{ ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedHyperSchemaOrUriLike) {
            GeneratedHyperSchemaOrUriLike other = (GeneratedHyperSchemaOrUriLike) o;
            return true;
        } else if (o instanceof GeneratedHyperSchemaOrUriRefable) {
            GeneratedHyperSchemaOrUriRefable other = (GeneratedHyperSchemaOrUriRefable) o;
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
