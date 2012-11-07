package net.exathunk.jereal.base.gen;

/**
 * charolastra 11/7/12 10:59 AM
 */
public class Util {

    private static String capitalize(String s) {
        final String[] parts = s.split("\\W+");
        final StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(part.substring(0, 1).toUpperCase() + part.substring(1));
        }
        return sb.toString();
    }

    private static String translate(String s) {
        if (s.equals("Number")) return "Double";
        else if (s.equals("Integer")) return "Long";
        else if (s.equals("Object")) return "JThing";
        else if (s.equals("String")) return s;
        else if (s.equals("Long")) return s;
        else if (s.equals("Double")) return s;
        else if (s.equals("Boolean")) return s;
        else if (s.equals("Array")) return s;
        else return "Generated"+s+"Container";
    }


    public static String xform(String s) {
        int lastSlash = s.lastIndexOf("/");
        if (lastSlash >= 0) {
            s = s.substring(lastSlash+1);
        }
        return translate(capitalize(s));
    }

    public static String camelize(String key) {
        String s = capitalize(key);
        return s.substring(0, 1).toLowerCase()+s.substring(1);
    }
}
