package net.exathunk.jereal.schema;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.jerializers.Operator;
import net.exathunk.jereal.base.visitors.ArrayVisitor;
import net.exathunk.jereal.base.visitors.ObjectVisitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * charolastra 10/28/12 10:00 PM
 */
public class SchemaVisitor implements ObjectVisitor<Schema> {

    private final Schema schema;
    private final Map<JThing.Model, List<Operator<Schema>>> operatorMap;

    public SchemaVisitor() {
        schema = new Schema();
        operatorMap = new HashMap<JThing.Model, List<Operator<Schema>>>();
    }

    @Override
    public ObjectVisitor<Schema> seeObjectFieldStart(String key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ArrayVisitor<Schema> seeArrayFieldStart(String key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void seeStringField(String key, String value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void seeBooleanField(String key, Boolean value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void seeLongField(String key, Long value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void seeDoubleField(String key, Double value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void runFunc(Schema schema) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
