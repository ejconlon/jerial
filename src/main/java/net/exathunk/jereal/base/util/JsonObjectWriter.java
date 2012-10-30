package net.exathunk.jereal.base.util;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.*;

public class JsonObjectWriter implements TypedVisitor, Func1<StringBuilder> {

    private final StringBuilder sb;
    private final Stack<Boolean> needComma;

    public JsonObjectWriter() {
        sb = new StringBuilder();
        needComma = new ConsStack<Boolean>();
        needComma.push(Boolean.FALSE);
    }

    private void outputComma() {
        if (Boolean.TRUE.equals(needComma.peek())) {
            sb.append(',');
        } else {
            needComma.pop();
            needComma.push(Boolean.TRUE);
        }
    }

    private void outputKey(Path path) {
        if (!path.isEmpty()) {
            final PathPart part = path.head();
            if (part.hasLeft()) {
                sb.append('"');
                sb.append(part.getLeft());
                sb.append('"');
                sb.append(':');
            }
        }
    }

    private void output(Path path, String v, boolean quote) {
        outputComma();
        outputKey(path);
        if (quote && v != null) sb.append('"');
        sb.append(v);
        if (quote && v != null) sb.append('"');
    }

    @Override
    public void runFunc(StringBuilder out) {
        out.append(sb);
    }

    @Override
    public void visitObjectStart(Path part, JObject thing) throws VisitException {
        outputComma();
        outputKey(part);
        sb.append('{');
        needComma.push(Boolean.FALSE);
    }

    @Override
    public void visitObjectEnd(Path part, JObject thing) {
        sb.append('}');
        needComma.pop();
    }

    @Override
    public void visitArrayStart(Path part, JArray thing) {
        outputComma();
        outputKey(part);
        sb.append('[');
        needComma.push(Boolean.FALSE);
    }

    @Override
    public void visitArrayEnd(Path part, JArray thing) {
        sb.append(']');
        needComma.pop();
    }

    @Override
    public void visitString(Path part, JString thing) {
        String v = thing.runResFunc();
        output(part, v, true);
    }

    @Override
    public void visitBoolean(Path part, JBoolean thing) {
        String v = null;
        Boolean x = thing.runResFunc();
        if (x != null) v = x.toString().toLowerCase();
        output(part, v, false);
    }

    @Override
    public void visitLong(Path part, JLong thing) {
        String v = null;
        Long x = thing.runResFunc();
        if (x != null) v = x.toString();
        output(part, v, false);
    }

    @Override
    public void visitDouble(Path part, JDouble thing) {
        String v = null;
        Double x = thing.runResFunc();
        if (x != null) v = x.toString();
        output(part, v, false);
    }
}