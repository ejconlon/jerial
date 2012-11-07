package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;

import java.util.*;

/**
 * charolastra 11/3/12 2:30 PM
 */
public class MetaGen implements GenWritable {

    private final List<GenWritable> writables;

    public MetaGen(List<GenWritable> writables) {
        this.writables = writables;
    }

    public static GenWritable makeDefault(Genable genable) {
        List<GenWritable> writables = new ArrayList<GenWritable>();
        writables.add(new ClassGen(genable));
        writables.add(new InterfaceGen(genable));
        writables.add(new RefableInterfaceGen(genable));

        Genable containerGenable = makeContainerGenable(genable);
        writables.add(new ClassGen(containerGenable));
        writables.add(new InterfaceGen(containerGenable));
        writables.add(new RefableInterfaceGen(containerGenable));
        return new MetaGen(writables);
    }

    private static Genable makeContainerGenable(final Genable genable) {
        return new Genable() {
            @Override
            public String getClassName() {
                return genable.getClassName()+"Container";
            }

            @Override
            public String getPackageName() {
                return genable.getPackageName();
            }

            @Override
            public Set<String> getImports() {
                final Set<String> tempImports = new TreeSet<String>(genable.getImports());
                final Set<String> imports = new TreeSet<String>();
                for (String klass : getFields().values()) {
                    tempImports.add(klass);
                }
                Util.rejiggerImports(tempImports, imports);
                return imports;
            }

            @Override
            public Map<String, String> getFields() {
                String selfType = (new TypeOracleImpl()).makeType(genable.getClassName(), SchemaRef.makeSchema(genable.getSchema()), null, null);
                selfType = selfType.replace("JThing", genable.getClassName());
                final Map<String, String> containerFields = new TreeMap<String, String>();
                containerFields.put(genable.getClassName(), selfType);
                return containerFields;
            }

            @Override
            public Schema getSchema() {
                return genable.getSchema();
            }
        };
    }

    @Override
    public Map<String, String> makeClassToTextMap() {
        Map<String, String> map = new TreeMap<String, String>();
        for (GenWritable writable : writables) {
            Map<String, String> subMap = writable.makeClassToTextMap();
            for (Map.Entry<String, String> entry : subMap.entrySet()) {
                 map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }
}
