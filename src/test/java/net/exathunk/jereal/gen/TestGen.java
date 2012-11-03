package net.exathunk.jereal.gen;

import net.exathunk.jereal.base.gen.GenWritable;
import net.exathunk.jereal.base.gen.MetaGen;
import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * charolastra 11/2/12 9:15 PM
 */
public class TestGen {
    @Test
    public void testBasic() {
        final String packageName = "foo.bar.baz";
        final String className = "Bongo";
        final Map<String, String> fields = new TreeMap<String, String>();
        fields.put("id", "String");
        fields.put("count", "Integer");

        final Set<String> imports = new TreeSet<String>();
        imports.add("gorp.goop.Ref");
        imports.add("boop.beep.RefImpl");

        GenWritable gen = MetaGen.makeDefault(packageName, className, imports, fields);

        for (Map.Entry<String, String> entry : gen.makeClassToTextMap().entrySet()) {
            System.out.println("CLASS: "+entry.getKey());
            System.out.print(entry.getValue());
        }
    }

}
