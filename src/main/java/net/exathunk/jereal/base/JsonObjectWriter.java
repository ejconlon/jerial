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

        private static void writeJitem(boolean needComma, Jitem jitem, StringBuilder out) {
            if (needComma) out.append(',');
            out.append('"');
            out.append(jitem.key);
            out.append("\":");
            switch (jitem.model) {
                case STRING:
                    out.append('"');
                    out.append((String)jitem.value);
                    out.append('"');
                    break;
                case LONG:
                case DOUBLE:
                    out.append(jitem);
                    break;
                case BOOLEAN:
                    if (((Boolean)jitem.value) == Boolean.TRUE) {
                        out.append("true");
                    } else {
                        out.append("false");
                    }
                    break;
                case OBJECT:
                    out.append('{');
                    needComma = false;
                    for (Jitem child : (Jerial)jitem.value) {
                        writeJitem(needComma, child, out);
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
                if (value.hasLeft()) {
                    writeJitem(needComma, value.getLeft(), out);
                } else {
                    value.getRight().writeTo(out);
                }
                needComma = true;
            }
            out.append('}');
        }
    }
}
