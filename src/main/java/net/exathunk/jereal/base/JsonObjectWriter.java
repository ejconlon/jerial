package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.*;

import java.util.List;
import java.util.Map;

public class JsonObjectWriter extends TreeVisitorFactoryImpl<StringBuilder> {

    public JsonObjectWriter() {
        super(new MyWriter());
    }

    private static void writeJitem(Jitem jitem, StringBuilder out) {
        boolean needComma = false;
        switch (jitem.getModel()) {
            case STRING:
                String sv = jitem.getString();
                if (sv != null) out.append('"');
                out.append(sv);
                if (sv != null) out.append('"');
                break;
            case LONG:
                out.append(jitem.getLong());
                break;
            case DOUBLE:
                out.append(jitem.getDouble());
                break;
            case BOOLEAN:
                Boolean bv = jitem.getBoolean();
                if (Boolean.TRUE.equals(bv)) {
                    out.append("true");
                } else if (bv != null) {
                    out.append("false");
                } else {
                    out.append("null");
                }
                break;
            case OBJECT:
                out.append('{');
                for (Jitem child : jitem.getObject()) {
                    if (needComma) out.append(',');
                    writeJitem(child, out);
                    needComma = true;
                }
                out.append('}');
                break;
            case ARRAY:
                out.append('[');
                for (Jitem child : jitem.getArray()) {
                    if (needComma) out.append(',');
                    writeJitem(child, out);
                    needComma = true;
                }
                out.append(']');
                break;
        }
    }

    private static class MyWriter implements TreeNodeMapWriter<StringBuilder> {
        @Override
        public void writeTo(TreeNodeMap<StringBuilder> source, StringBuilder sink) {
            if (source.isObject()) writeObject(source, sink);
            else writeArray(source, sink);
        }

        private void writeObject(TreeNodeMap<StringBuilder> nodeMap, StringBuilder out) {
            out.append('{');
            boolean needComma = false;
            for (Map.Entry<PathPart, TreeNode<StringBuilder>> entry : nodeMap) {
                final PathPart path = entry.getKey();
                final TreeNode<StringBuilder> value = entry.getValue();
                if (needComma) out.append(',');
                out.append('"');
                out.append(path.getLeft());
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

        private void writeArray(TreeNodeMap<StringBuilder> nodeMap, StringBuilder out) {
            out.append('[');
            boolean needComma = false;
            for (Map.Entry<PathPart, TreeNode<StringBuilder>> entry : nodeMap) {
                final TreeNode<StringBuilder> value = entry.getValue();
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