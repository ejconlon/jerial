package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.*;

import java.util.List;

public class JerialRunner<U> implements JerialVisitorAdapter<Jerial, U> {

    public Writer<U> runJerialVisitor(Jerial parent, JerialVisitor<U> visitor) {
        ObjectVisitor<U> objectVisitor = visitor.makeObjectVisitor();
        runJerialVisitorInner(parent, objectVisitor, null);
        return objectVisitor;
    }

    private void runJerialVisitorInner(Iterable<Jitem> parent, ObjectVisitor<U> objectVisitor, ArrayVisitor<U> arrayVisitor) {
        final boolean isObject = objectVisitor != null;
        for (Jitem entry : parent) {
            //Logger.log("runJerialVisitorInner: "+entry);
            switch (entry.model) {
                case STRING:
                    if (isObject) objectVisitor.seeStringField(entry.key, (String) entry.value);
                    else arrayVisitor.seeStringItem((String)entry.value);
                    break;
                case LONG:
                    if (isObject) objectVisitor.seeLongField(entry.key, (Long) entry.value);
                    else arrayVisitor.seeLongItem((Long)entry.value);
                    break;
                case DOUBLE:
                    if (isObject) objectVisitor.seeDoubleField(entry.key, (Double) entry.value);
                    else arrayVisitor.seeDoubleItem((Double)entry.value);
                    break;
                case BOOLEAN:
                    if (isObject) objectVisitor.seeBooleanField(entry.key, (Boolean) entry.value);
                    else arrayVisitor.seeBooleanItem((Boolean) entry.value);
                    break;
                case OBJECT:
                    if (isObject) {
                        ObjectVisitor<U> childVisitor = objectVisitor.seeObjectFieldStart(entry.key);
                        runJerialVisitorInner((Jerial) entry.value, childVisitor, null);
                    } else {
                        ObjectVisitor<U> childVisitor = arrayVisitor.seeObjectItemStart();
                        runJerialVisitorInner((Jerial)entry.value, childVisitor, null);
                    }
                    break;
                case ARRAY:
                    if (isObject) {
                        ArrayVisitor<U> childVisitor = objectVisitor.seeArrayFieldStart(entry.key);
                        runJerialVisitorInner((List<Jitem>) entry.value, null, childVisitor);
                    } else {
                        ArrayVisitor<U> childVisitor = arrayVisitor.seeArrayItemStart();
                        runJerialVisitorInner((List<Jitem>) entry.value, null, childVisitor);
                    }
                    break;
            }
        }
    }
}
