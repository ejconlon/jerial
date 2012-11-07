package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.Speclike;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.jerializers.JerializerUtils;
import net.exathunk.jereal.base.util.JsonParser;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.jerializers.SchemaJerializer;
import net.exathunk.jereal.schema.util.Loader;
import net.exathunk.jereal.schema.util.SchemaRegistryBuilder;

import java.io.*;
import java.util.Map;

/**
 * java RunGen src/main/resources/schemas target/generated-sources/gen-javabean/net/exathunk/jereal/genschema net.exathunk.jereal.genschema
 * charolastra 11/4/12 11:27 AM
 */
public class RunGen {
    public static void main(String[] args) throws IOException, JerializerException {
        // first arg - schema dir, second arg - dest dir
        // TODO write schemas
        final String schemaDir = args[0];
        final String destDir = args[1];
        final String basePackage = args[2];

        File schemas = new File(schemaDir);
        assert schemas.isDirectory() && schemas.canRead();

        File dest = new File(destDir);
        assert !dest.exists();
        dest.mkdir();
        assert dest.isDirectory() && dest.canWrite();

        JsonParser parser = new JsonParser();
        TypeOracle oracle = new TypeOracleImpl();
        for (File schema : schemas.listFiles()) {
            BufferedReader reader = new BufferedReader(new FileReader(schema));
            JThing thing = parser.parse(reader);
            System.out.println(thing);
            Schema s = Loader.parseSchemaThing(thing);
            System.out.println(s);
            String rootString = schemas.toURI().toString();
            if (!rootString.endsWith("/")) rootString = rootString + "/";
            final String name = Util.xform(schema.toURI().toString().substring(rootString.length()));
            SchemaReader schemaReader = new SchemaReader(name, basePackage, s, oracle);

            GenWritable writable = MetaGen.makeDefault(schemaReader.getPackageName(), schemaReader.getClassName(), schemaReader.getImports(), schemaReader.getFields());
            Map<String, String> m = writable.makeClassToTextMap();

            final File dir = new File(destDir+"/"+name.toLowerCase());
            dir.mkdirs();
            for (Map.Entry<String, String> entry : m.entrySet()) {
                final String fullClass = entry.getKey();
                final String contents = entry.getValue();
                final String relName = fullClass.substring(fullClass.lastIndexOf(".")+1)+".java";
                final File f = new File(dir, relName);
                FileWriter writer = new FileWriter(f);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(contents, 0, contents.length());
                bufferedWriter.close();
            }
        }
    }
}
