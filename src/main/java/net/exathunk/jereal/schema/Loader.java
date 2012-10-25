package net.exathunk.jereal.schema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * charolastra 10/24/12 7:53 PM
 */
public class Loader {
    public static String loadSchemaResource(final String name) throws IOException {
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
}
