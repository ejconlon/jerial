package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.JerializerException;
import net.exathunk.jereal.base.jerializers.JerializerUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * charolastra 10/24/12 7:53 PM
 */
public class Loader {

    public static String loadSchemaString(String name) throws IOException {
        InputStream is = Loader.class.getResourceAsStream("/schemas/"+name);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            sb.append(line).append('\n');
            line = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }

    public static Schema loadSchema(String name) throws IOException, JerializerException {
        final String schemaString = loadSchemaString(name);
        final Schema schema = new Schema();
        JerializerUtils.jsonToDomain(
            SchemaRegistryFactorySingleton.getInstance().makeDejerializerRegistry(),
            new SchemaDejerializer(), schemaString, schema);
        return schema;
    }
}
