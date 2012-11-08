package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.core.JThing;
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
        writables.add(new JerializerGen(genable));

        Genable containerGenable = makeContainerGenable(genable);
        writables.add(new ClassGen(containerGenable));
        writables.add(new InterfaceGen(containerGenable));
        writables.add(new RefableInterfaceGen(containerGenable));
        writables.add(new JerializerGen(containerGenable));
        return new MetaGen(writables);
    }

    private static Genable makeContainerGenable(final Genable genable) {
        return new Genable() {
            @Override
            public Klass getKlass() {
                return new Klass(genable.getKlass().getKlassName()+"Container", genable.getKlass().getPackageName());
            }

            @Override
            public Set<Klass> getImports() {
                final Set<Klass> tempImports = new TreeSet<Klass>(genable.getImports());
                final Set<Klass> imports = new TreeSet<Klass>();
                for (KlassTree klassTree : getFields().values()) {
                    tempImports.addAll(klassTree.collectImports());
                }
                KlassContext.rejiggerImports(tempImports, imports);
                return imports;
            }

            @Override
            public Map<String, KlassTree> getFields() {
                KlassContext klassContext = new KlassContext(new KlassTree(genable.getKlass()));
                KlassTree tree = (new TypeOracleImpl(klassContext)).makeType(SchemaRef.makeSchema(genable.getSchema()));
                for (int i = 0; i < tree.getTemplateArgs().size(); ++i) {
                    if (tree.getTemplateArgs().get(i).getKlass().equals(new Klass(JThing.class))) {
                        tree.getTemplateArgs().set(i, new KlassTree(genable.getKlass()));
                    }
                }
                final Map<String, KlassTree> containerFields = new TreeMap<String, KlassTree>();
                containerFields.put(KlassContext.camelize(genable.getKlass().getKlassName()), tree);
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
