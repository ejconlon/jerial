package net.exathunk.jereal.base;

import java.util.Map;

public class JsonObjectWriter implements JerialVisitor<StringBuilder> {

    public ObjectVisitor<StringBuilder> getObjectVisitor() {
        return new MyObjectVisitor();
    }

    private static class MyObjectVisitor extends TreeVisitor<StringBuilder> {

        @Override
        public ObjectVisitor seeObjectFieldStart(String key) {
            MyObjectVisitor v = new MyObjectVisitor();
            addObjectVisitor(key, v);
            return v;
        }

        private static void writeJitem(Jitem jitem, StringBuilder out) {
            switch (jitem.model) {
                case STRING:
                    if (jitem.value != null) out.append('"');
                    out.append((String)jitem.value);
                    if (jitem.value != null) out.append('"');
                    break;
                case LONG:
                case DOUBLE:
                    out.append(jitem.value);
                    break;
                case BOOLEAN:
                    if (((Boolean)jitem.value) == Boolean.TRUE) {
                        out.append("true");
                    } else if (jitem.value != null) {
                        out.append("false");
                    } else {
                        out.append("null");
                    }
                    break;
                case OBJECT:
                    out.append('{');
                    boolean needComma = false;
                    for (Jitem child : (Jerial)jitem.value) {
                        if (needComma) out.append(',');
                        writeJitem(child, out);
                        needComma = true;
                    }
                    out.append('}');
                    break;
            }
        }

        @Override
        public void writeTo(StringBuilder out) {
            out.append('{');
            boolean needComma = false;
            for (Map.Entry<String, Either<Jitem, TreeVisitor<StringBuilder>>> entry : getPairs().entrySet()) {
                final String key = entry.getKey();
                final Either<Jitem, TreeVisitor<StringBuilder>> value = entry.getValue();
                if (needComma) out.append(',');
                out.append('"');
                out.append(key);
                out.append("\":");
                if (value.hasLeft()) {
                    writeJitem(value.getLeft(), out);
                } else {
                    value.getRight().writeTo(out);
                }
                needComma = true;
            }
            out.append('}');
        }
    }
}
