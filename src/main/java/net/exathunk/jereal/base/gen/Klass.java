package net.exathunk.jereal.base.gen;

/**
 * charolastra 11/7/12 6:48 PM
 */
public class Klass implements Comparable<Klass> {

    private final String klassName;
    private final String packageName;

    public Klass(Class realClass) {
        this(realClass.getSimpleName(), extractPackage(realClass));
    }

    private static String extractPackage(Class realClass) {
        String name = realClass.getName();
        return name.substring(0, name.length()-realClass.getSimpleName().length()-1);
    }

    public Klass(String klassName, String packageName) {
        this.klassName = klassName;
        this.packageName = packageName;
        assert klassName != null;
        assert packageName != null;
    }

    public String getKlassName() {
        return klassName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getFullName() {
        return packageName+"."+klassName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klass)) return false;

        Klass klass = (Klass) o;

        if (!klassName.equals(klass.klassName)) return false;
        if (!packageName.equals(klass.packageName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = klassName.hashCode();
        result = 31 * result + packageName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getFullName();
    }

    @Override
    public int compareTo(Klass other) {
        return toString().compareTo(other.toString());
    }
}
