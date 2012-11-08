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

    private final Klass klass;
    private final Set<Klass> imports;
    private final Map<String, KlassTree> fields;

    public SchemaReader(Klass klass, Schema schema) {
        this.klass = klass;
        this.schema = schema;
        this.imports = new TreeSet<Klass>();
        this.fields = new TreeMap<String, KlassTree>();
        parse();
    }

    private void parse() {
        TypeOracle oracle = new TypeOracleImpl(new KlassContext(new KlassTree(klass)));
        final Set<Klass> tempImports = new TreeSet<Klass>();
        final Map<String, KlassTree> tempFields = new TreeMap<String, KlassTree>();

        if (!schema.properties.isEmptyRef()) {
           for (Map.Entry<String, SchemaRef> property : schema.properties.getRef().entrySet()) {
                try {
                    final KlassTree importClass = oracle.makeType(property.getValue());
                    tempImports.addAll(importClass.collectImports());
                    tempFields.put(KlassContext.camelize(property.getKey()),importClass);
                } catch (NotImplementedException soon) {}
            }
        }

        KlassContext.rejiggerImports(tempImports, imports);
        KlassContext.rejiggerFields(tempFields, fields);
    }

    @Override
    public Klass getKlass() {
        return klass;
    }

    @Override
    public Set<Klass> getImports() {
        return imports;
    }

    @Override
    public Map<String, KlassTree> getFields() {
        return fields;
    }

    @Override
    public Schema getSchema() {
        return schema;
    }
}
