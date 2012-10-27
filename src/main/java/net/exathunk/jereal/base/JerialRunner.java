package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.*;

import java.util.List;

public class JerialRunner<U> implements JerialVisitorAdapter<Jerial, U> {

    public Writer<U> runJerialVisitor(Jerial parent, VisitorFactory<U> visitorFactory) {
        ObjectVisitor<U> objectVisitor = visitorFactory.makeObjectVisitor();
        runJerialVisitorInner(parent, objectVisitor, null);
        return objectVisitor;
    }

    private void runJerialVisitorInner(Iterable<Jitem> parent, ObjectVisitor<U> objectVisitor, ArrayVisitor<U> arrayVisitor) {
        final boolean isObject = objectVisitor != null;
        for (Jitem entry : parent) {
            //Logger.log("runJerialVisitorInner: "+entry);
            final PathPart part = entry.getPart();
            switch (entry.getModel()) {
                case STRING:
                    if (isObject) objectVisitor.seeStringField(part.getLeft(), entry.getString());
                    else arrayVisitor.seeStringItem(entry.getString());
                    break;
                case LONG:
                    if (isObject) objectVisitor.seeLongField(part.getLeft(), entry.getLong());
                    else arrayVisitor.seeLongItem(entry.getLong());
                    break;
                case DOUBLE:
                    if (isObject) objectVisitor.seeDoubleField(part.getLeft(), entry.getDouble());
                    else arrayVisitor.seeDoubleItem(entry.getDouble());
                    break;
                case BOOLEAN:
                    if (isObject) objectVisitor.seeBooleanField(part.getLeft(), entry.getBoolean());
                    else arrayVisitor.seeBooleanItem(entry.getBoolean());
                    break;
                case OBJECT:
                    if (isObject) {
                        ObjectVisitor<U> childVisitor = objectVisitor.seeObjectFieldStart(part.getLeft());
                        runJerialVisitorInner(entry.getObject(), childVisitor, null);
                    } else {
                        ObjectVisitor<U> childVisitor = arrayVisitor.seeObjectItemStart();
                        runJerialVisitorInner(entry.getObject(), childVisitor, null);
                    }
                    break;
                case ARRAY:
                    if (isObject) {
                        ArrayVisitor<U> childVisitor = objectVisitor.seeArrayFieldStart(part.getLeft());
                        runJerialVisitorInner(entry.getArray(), null, childVisitor);
                    } else {
                        ArrayVisitor<U> childVisitor = arrayVisitor.seeArrayItemStart();
                        runJerialVisitorInner(entry.getArray(), null, childVisitor);
                    }
                    break;
            }
        }
    }
}
