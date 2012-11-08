package net.exathunk.jereal.base.gen;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * charolastra 11/7/12 10:59 AM
 */
public class KlassContext {

    private final KlassTree klassTree;

    public KlassContext(KlassTree klassTree) {
        this.klassTree = klassTree;
    }

    public KlassTree getKlassTree() {
        return klassTree;
    }

    private String getKlassName() {
        return klassTree.getKlass().getKlassName();
    }

    private Klass makeKlass(String name) {
        String p = klassTree.getKlass().getPackageName();
        p = p.substring(0, p.lastIndexOf(".")+1) + capitalize(name).toLowerCase();
        return new Klass(capitalize(name)+"Container", p);
    }

    private Klass translateFromString(String name) {
        if (name.equalsIgnoreCase("string"))  return new Klass("String", "java.lang");
        if (name.equalsIgnoreCase("boolean")) return new Klass("Boolean", "java.lang");
        if (name.equalsIgnoreCase("long"))    return new Klass("Long", "java.lang");
        if (name.equalsIgnoreCase("double"))  return new Klass("Double", "java.lang");
        if (name.equalsIgnoreCase("number"))  return new Klass("Double", "java.lang");
        if (name.equalsIgnoreCase("integer")) return new Klass("Long", "java.lang");
        return makeKlass(name);
    }

    private Klass translateFromRef(String ref) {
        int lastSlash = ref.lastIndexOf("/");
        if (lastSlash >= 0) {
            ref = ref.substring(lastSlash+1);
        }
        return makeKlass(ref);
    }

    public KlassTree resolve(String name) {
        if (name.equals("#")) {
            return new KlassTree(makeKlass(klassTree.getKlass().getKlassName()));
        } else if (name.contains("/")) {
            return new KlassTree(translateFromRef(name));
        } else {
            return new KlassTree(translateFromString(name));
        }
    }

    public static String capitalize(String s) {
        final String[] parts = s.split("\\W+");
        final StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(part.substring(0, 1).toUpperCase() + part.substring(1));
        }
        return sb.toString();
    }

    public static String camelize(String key) {
        String s = capitalize(key);
        return s.substring(0, 1).toLowerCase()+s.substring(1);
    }

    public static void rejiggerFields(Map<String, KlassTree> inMap, Map<String, KlassTree> outMap) {
        final Set<String> keywords = new TreeSet<String>();
        keywords.addAll(Arrays.asList("extends", "implements", "class", "enum", "default", "static",
                "public", "private", "protected", "int", "long", "double", "float"));
        for (Map.Entry<String, KlassTree> f : inMap.entrySet()) {
            if (keywords.contains(f.getKey().toLowerCase())) {
                outMap.put(f.getKey()+"Field", f.getValue());
            } else {
                outMap.put(f.getKey(), f.getValue());
            }
        }
    }

    public static void rejiggerImports(Set<Klass> inSet, Set<Klass> outSet) {
        outSet.add(new Klass("Ref", "net.exathunk.jereal.base.functional"));
        outSet.add(new Klass("RefImpl", "net.exathunk.jereal.base.functional"));
        outSet.add(new Klass("JThing", "net.exathunk.jereal.base.core"));
        outSet.add(new Klass("Any2", "net.exathunk.jereal.base.gen"));
        outSet.add(new Klass("Any3", "net.exathunk.jereal.base.gen"));
        outSet.add(new Klass("*", "net.exathunk.jereal.base.dsl"));
        outSet.add(new Klass("*", "net.exathunk.jereal.base.jerializers"));
        outSet.add(new Klass("List", "java.util"));
        outSet.add(new Klass("Map", "java.util"));
        for (Klass k : inSet) {
            outSet.add(k);
        }
    }
}
