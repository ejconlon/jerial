package net.exathunk.jereal.base.gen;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
        else if (s.equals("Object")) return s;
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

    public static void rejiggerFields(Map<String, String> inMap, Map<String, String> outMap) {
        final Set<String> keywords = new TreeSet<String>();
        keywords.addAll(Arrays.asList("extends", "implements", "class", "enum", "default", "static",
                "public", "private", "protected", "int", "long", "double", "float"));
        for (Map.Entry<String, String> f : inMap.entrySet()) {
            if (keywords.contains(f.getKey())) {
                outMap.put(f.getKey()+"Field", f.getValue());
            } else {
                outMap.put(f.getKey(), f.getValue());
            }
        }
    }

    public static void rejiggerImports(Set<String> inSet, Set<String> outSet) {
        outSet.add("net.exathunk.jereal.base.functional.Ref");
        outSet.add("net.exathunk.jereal.base.functional.RefImpl");
        outSet.add("net.exathunk.jereal.base.core.JThing");
        outSet.add("net.exathunk.jereal.genschema.links.GeneratedLinksContainer");
        outSet.add("net.exathunk.jereal.base.gen.Any2");
        outSet.add("net.exathunk.jereal.base.gen.Any3");
        outSet.add("java.util.List");
        outSet.add("java.util.Map");
        for (String imp : inSet) {
            if (imp.startsWith("Any")) {
                int start = imp.indexOf("<");
                int end = imp.indexOf(">");
                String[] parts = imp.substring(start, end).split(",");
                for (String part : parts) {
                    if (part.startsWith("Generated")) {
                        addPart(part, outSet);
                    }
                }
            } else if (imp.startsWith("Generated")) {
                addPart(imp, outSet);
            }
        }
    }

    public static void addPart(String imp, Set<String> outSet) {
        assert imp.startsWith("Generated");
        final String ppart;
        final String pstart;
        if (imp.endsWith("Container")) {
            pstart = imp.substring(0, imp.length()-9);
            ppart = pstart.substring(9, pstart.length()).toLowerCase();
        } else {
            pstart = imp;
            ppart = pstart.substring(9).toLowerCase();
        }
        String pname = "net.exathunk.jereal.genschema."+ppart+".";
        outSet.add(pname+pstart);
        outSet.add(pname+pstart+"Container");
    }
}
