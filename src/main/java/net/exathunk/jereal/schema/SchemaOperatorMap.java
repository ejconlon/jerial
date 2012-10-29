package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.jerializers.Operator;
import net.exathunk.jereal.base.jerializers.OperatorMap;

/**
 * charolastra 10/29/12 12:36 PM
 */
public class SchemaOperatorMap extends OperatorMap<Schema> {
    public SchemaOperatorMap() {
        put(JThing.Model.STRING, PathPart.key("name"), new Operator<Schema>() {
            @Override
            public void runFunc(PathPart pathPart, JThing thing, Schema schema) {
                schema.name = thing.rawGetString().runResFunc();
            }
        });
    }
}
