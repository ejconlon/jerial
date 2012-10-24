package net.exathunk.jereal.base;

import java.util.Iterator;

public class JerialRunner<U> implements JerialVisitorAdapter<Jerial, U> {

    public Writer<U> runJerialVisitor(Jerial parent, JerialVisitor<U> visitor) {
        JerialVisitor.ObjectVisitor<U> objectVisitor = visitor.getObjectVisitor();
        runJerialVisitorInner(parent.iterator(), objectVisitor);
        return objectVisitor;
    }

    private void runJerialVisitorInner(Iterator<Jitem> pairsIt, JerialVisitor.ObjectVisitor<U> visitor) {
        while (pairsIt.hasNext()) {
            final Jitem entry = pairsIt.next();
            switch (entry.model) {
                case STRING:
                    visitor.seeStringField(entry.key, (String) entry.value);
                    break;
                case LONG:
                    visitor.seeLongField(entry.key, (Long) entry.value);
                    break;
                case DOUBLE:
                    visitor.seeDoubleField(entry.key, (Double) entry.value);
                    break;
                case BOOLEAN:
                    visitor.seeBooleanField(entry.key, (Boolean) entry.value);
                    break;
                case OBJECT:
                    JerialVisitor.ObjectVisitor<U> childVisitor = visitor.seeObjectFieldStart(entry.key);
                    runJerialVisitorInner(((Jerial) entry.value).iterator(), childVisitor);
                    break;
            }
        }
    }
}
