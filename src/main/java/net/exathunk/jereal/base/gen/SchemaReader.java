package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;


/**
 * charolastra 11/4/12 1:21 PM
 */
public class SchemaReader implements Genable {
    private final Schema schema;

    private final String name;
    private final String packageName;
    private final String className;
    private final Set<String> imports;
    private final Map<String, String> fields;

    public SchemaReader(String className, String packageName, Schema schema, TypeOracle oracle) {
        this.name = className.toLowerCase();
        this.className = className;
        this.packageName = packageName;
        this.schema = schema;
        this.imports = new TreeSet<String>();
        this.fields = new TreeMap<String, String>();
        parse(oracle);
    }

    private void parse(TypeOracle oracle) {
        if (!schema.properties.isEmptyRef()) {
            final Set<String> tempImports = new TreeSet<String>();
            final Map<String, String> tempFields = new TreeMap<String, String>();
            for (Map.Entry<String, SchemaRef> property : schema.properties.getRef().entrySet()) {
                try {
                    final String importClass = oracle.makeType(className, property.getValue(), null);
                    tempImports.add(importClass);
                    tempFields.put(Util.camelize(property.getKey()),importClass);
                } catch (NotImplementedException soon) {}
            }
            rejiggerImports(tempImports, imports);
            rejiggerFields(tempFields, fields);
        }
    }


    private static void rejiggerFields(Map<String, String> inMap, Map<String, String> outMap) {
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


    private static void rejiggerImports(Set<String> inSet, Set<String> outSet) {
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
                        outSet.add(expandClass(part));
                    }
                }
            } else if (imp.startsWith("Generated")) {
                outSet.add(expandClass(imp));
            }
        }
    }

    private static String expandClass(String imp) {
        if (imp.startsWith("Generated")) {
            final String ppart;
            if (imp.endsWith("Container")) {
                ppart = imp.substring(9, imp.length()-9).toLowerCase();
            } else {
                ppart = imp.substring(9).toLowerCase();
            }
            String pname = "net.exathunk.jereal.genschema."+ppart+"."+imp;
            return pname;
        }
        return imp;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public Set<String> getImports() {
        return imports;
    }

    @Override
    public Map<String, String> getFields() {
        return fields;
    }

    @Override
    public Schema getSchema() {
        return schema;
    }
}
