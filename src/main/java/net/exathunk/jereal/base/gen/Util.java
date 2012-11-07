package net.exathunk.jereal.base.gen;

/**
 * charolastra 11/7/12 10:59 AM
 */
public class Util {

    private static String capitalize(String s) {
        final String[] parts = s.split("\\W+");
        final StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase());
        }
        return sb.toString();
    }

    private static String translate(String s) {
        if (s.equals("Number")) return "Double";
        else if (s.equals("Integer")) return "Long";
        else if (s.equals("Object")) return "JObject";
        else return s;
    }


    public static String xform(String s) {
        return translate(capitalize(s));
    }

}
