package net.exathunk.jereal.gen;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.*;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * charolastra 11/2/12 9:15 PM
 */
public class TestGen {
    @Test
    public void testBasic() {
        final Klass klass = new Klass("Bongo", "foo.bar.baz");
        final Map<String, KlassTree> fields = new TreeMap<String, KlassTree>();
        fields.put("id", new KlassTree(new Klass(String.class)));
        fields.put("count", new KlassTree(new Klass(Long.class)));

        final Set<Klass> imports = new TreeSet<Klass>();
        imports.add(new Klass(Ref.class));
        imports.add(new Klass(RefImpl.class));

        final Schema schema = new Schema();
        schema.id.setRef("http://foo.bar.baz/bongo");
        schema.type_SchemaRef.setRef(new LinkedList<SchemaRef>());
        schema.type_SchemaRef.getRef().add(SchemaRef.makeRef("string"));
        schema.type_SchemaRef.getRef().add(SchemaRef.makeRef("#"));

        GenWritable gen = MetaGen.makeDefault(new Genable() {
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
        });

        for (Map.Entry<String, String> entry : gen.makeClassToTextMap().entrySet()) {
            System.out.println("CLASS: "+entry.getKey());
            System.out.print(entry.getValue());
        }
    }

}
