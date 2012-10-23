package net.exathunk.jereal.base;

import java.util.Iterator;

public class JerialRunner implements JerialVisitorAdapter<Jerial> {

    public void runJerialVisitor(Jerial parent, JerialVisitor visitor) {
        visitor.seeStartObject();
        runJerialVisitorInner(parent.iterator(), visitor);
        visitor.seeEndObject();
    }

    private void runJerialVisitorInner(Iterator<Jitem> pairsIt, JerialVisitor visitor) {
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
                    visitor.seeObjectFieldStart(entry.key);
                    runJerialVisitorInner(((Jerial) entry.value).iterator(), visitor);
                    visitor.seeEndObject();
                    break;
            }
        }
    }
}
