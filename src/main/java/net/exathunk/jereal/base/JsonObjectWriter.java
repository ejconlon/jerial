package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.*;

import java.util.List;
import java.util.Map;

public class JsonObjectWriter implements JerialVisitor<StringBuilder> {

    public ObjectVisitor<StringBuilder> makeObjectVisitor() {
        return new MyObjectVisitor();
    }

    public ArrayVisitor<StringBuilder> makeArrayVisitor() {
        return new MyArrayVisitor();
    }

    private static void writeJitem(Jitem jitem, StringBuilder out) {
        boolean needComma = false;
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
                if (Boolean.TRUE.equals(jitem.value)) {
                    out.append("true");
                } else if (jitem.value != null) {
                    out.append("false");
                } else {
                    out.append("null");
                }
                break;
            case OBJECT:
                out.append('{');
                for (Jitem child : (Jerial)jitem.value) {
                    if (needComma) out.append(',');
                    writeJitem(child, out);
                    needComma = true;
                }
                out.append('}');
                break;
            case ARRAY:
                out.append('[');
                for (Jitem child : (List<Jitem>)jitem.value) {
                    if (needComma) out.append(',');
                    writeJitem(child, out);
                    needComma = true;
                }
                out.append(']');
                break;
        }
    }

    private static class MyObjectVisitor extends TreeObjectVisitor<StringBuilder> {

        @Override
        public ObjectVisitor<StringBuilder> seeObjectFieldStart(String key) {
            MyObjectVisitor v = new MyObjectVisitor();
            addObjectVisitor(key, v);
            return v;
        }

        @Override
        public ArrayVisitor<StringBuilder> seeArrayFieldStart(String key) {
            MyArrayVisitor v = new MyArrayVisitor();
            addArrayVisitor(key, v);
            return v;
        }

        @Override
        public void writeTo(StringBuilder out) {
            out.append('{');
            boolean needComma = false;
            for (Map.Entry<String, JerialNode<StringBuilder>> entry : getItems().entrySet()) {
                final String key = entry.getKey();
                final JerialNode<StringBuilder> value = entry.getValue();
                if (needComma) out.append(',');
                out.append('"');
                out.append(key);
                out.append("\":");
                if (value.hasLeft()) {
                    writeJitem(value.getLeft(), out);
                } else if (value.hasMiddle()) {
                    value.getMiddle().writeTo(out);
                } else {
                    value.getRight().writeTo(out);
                }
                needComma = true;
            }
            out.append('}');
        }
    }

    private static class MyArrayVisitor extends TreeArrayVisitor<StringBuilder> {

        @Override
        public ObjectVisitor<StringBuilder> seeObjectItemStart() {
            MyObjectVisitor v = new MyObjectVisitor();
            addObjectVisitor(v);
            return v;
        }

        @Override
        public ArrayVisitor<StringBuilder> seeArrayItemStart() {
            MyArrayVisitor v = new MyArrayVisitor();
            addArrayVisitor(v);
            return v;
        }

        @Override
        public void writeTo(StringBuilder out) {
            out.append('[');
            boolean needComma = false;
            for (Either3<Jitem, TreeObjectVisitor<StringBuilder>, TreeArrayVisitor<StringBuilder>> value : getItems()) {
                if (needComma) out.append(',');
                if (value.hasLeft()) {
                    writeJitem(value.getLeft(), out);
                } else if (value.hasMiddle()) {
                    value.getMiddle().writeTo(out);
                } else {
                    value.getRight().writeTo(out);
                }
                needComma = true;
            }
            out.append(']');
        }
    }
}