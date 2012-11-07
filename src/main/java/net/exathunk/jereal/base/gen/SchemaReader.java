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
        final Set<String> tempImports = new TreeSet<String>();
        final Map<String, String> tempFields = new TreeMap<String, String>();

        if (!schema.properties.isEmptyRef()) {
           for (Map.Entry<String, SchemaRef> property : schema.properties.getRef().entrySet()) {
                try {
                    final String importClass = oracle.makeType(className+"Container", property.getValue(), null, null);
                    tempImports.add(importClass);
                    tempFields.put(Util.camelize(property.getKey()),importClass);
                } catch (NotImplementedException soon) {}
            }
        }

        Util.rejiggerImports(tempImports, imports);
        Util.rejiggerFields(tempFields, fields);
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
