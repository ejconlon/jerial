package net.exathunk.jereal.base;

import net.exathunk.jereal.base.core.JArray;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Func1;
import net.exathunk.jereal.base.visitors.*;

import java.util.Map;

public class JerialRunner<U> implements JerialVisitorAdapter<JObject, U> {

    public Func1<U> runJerialVisitor(JObject parent, VisitorFactory<U> visitorFactory) {
        ObjectVisitor<U> objectVisitor = visitorFactory.makeObjectVisitor();
        runJerialVisitorInner(parent, objectVisitor);
        return objectVisitor;
    }

    private void runJerialVisitorInner(JObject parent, ObjectVisitor<U> objectVisitor) {
        for (Map.Entry<String, JThing> entry : parent.seq()) {
            //Logger.log("runJerialVisitorInner: "+entry);
            final PathPart part = PathPart.key(entry.getKey());
            final JThing value = entry.getValue();
            switch (value.getModel()) {
                case STRING:
                    objectVisitor.seeStringField(part.getLeft(), value.rawGetString().runResFunc());
                    break;
                case LONG:
                    objectVisitor.seeLongField(part.getLeft(), value.rawGetLong().runResFunc());
                    break;
                case DOUBLE:
                    objectVisitor.seeDoubleField(part.getLeft(), value.rawGetDouble().runResFunc());
                    break;
                case BOOLEAN:
                    objectVisitor.seeBooleanField(part.getLeft(), value.rawGetBoolean().runResFunc());
                    break;
                case OBJECT:
                    {
                        ObjectVisitor<U> childVisitor = objectVisitor.seeObjectFieldStart(part.getLeft());
                        runJerialVisitorInner(value.rawGetObject(), childVisitor);
                    }
                    break;
                case ARRAY:
                    {
                        ArrayVisitor<U> childVisitor = objectVisitor.seeArrayFieldStart(part.getLeft());
                        runJerialVisitorInner(value.rawGetArray(), childVisitor);
                    }
                    break;
            }
        }
    }

    private void runJerialVisitorInner(JArray parent, ArrayVisitor<U> arrayVisitor) {
        for (Map.Entry<Integer, JThing> entry : parent.seq()) {
            //Logger.log("runJerialVisitorInner: "+entry);
            final PathPart part = PathPart.index(entry.getKey());
            final JThing value = entry.getValue();
            switch (value.getModel()) {
                case STRING:
                    arrayVisitor.seeStringItem(value.rawGetString().runResFunc());
                    break;
                case LONG:
                    arrayVisitor.seeLongItem(value.rawGetLong().runResFunc());
                    break;
                case DOUBLE:
                    arrayVisitor.seeDoubleItem(value.rawGetDouble().runResFunc());
                    break;
                case BOOLEAN:
                    arrayVisitor.seeBooleanItem(value.rawGetBoolean().runResFunc());
                    break;
                case OBJECT:
                    {
                        ObjectVisitor<U> childVisitor = arrayVisitor.seeObjectItemStart();
                        runJerialVisitorInner(value.rawGetObject(), childVisitor);
                    }
                    break;
                case ARRAY:
                    {
                        ArrayVisitor<U> childVisitor = arrayVisitor.seeArrayItemStart();
                        runJerialVisitorInner(value.rawGetArray(), childVisitor);
                    }
                    break;
            }
        }
    }
}
