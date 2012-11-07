package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * charolastra 11/4/12 1:21 PM
 */
public class SchemaReader {
    private final Schema schema;

    private final String name;
    private final String packageName;
    private final String className;
    private final Set<String> imports;
    private final Map<String, String> fields;

    public SchemaReader(String className, String basePackage, Schema schema, TypeOracle oracle) {
        this.name = className.toLowerCase();
        this.className = className;
        this.packageName = basePackage+"."+name;
        this.schema = schema;
        this.imports = new TreeSet<String>();
        this.fields = new TreeMap<String, String>();
        parse(oracle);
    }

    private void parse(TypeOracle oracle) {
        if (!schema.properties.isEmptyRef()) {
            for (Map.Entry<String, SchemaRef> property : schema.properties.getRef().entrySet()) {
                try {
                    final String importClass = oracle.makeType(className, property.getValue());
                    imports.add(importClass);
                    fields.put(property.getKey(),importClass);
                } catch (NotImplementedException soon) {}
            }
        }
    }

    public String getClassName() {
        return className;
    }

    public String getPackageName() {
        return packageName;
    }

    public Set<String> getImports() {
        return imports;
    }

    public Map<String, String> getFields() {
        return fields;
    }
}
