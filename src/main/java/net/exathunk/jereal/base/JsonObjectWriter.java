package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.*;

import java.util.List;
import java.util.Map;

public class JsonObjectWriter extends TreeVisitorFactory<StringBuilder> {

    public JsonObjectWriter() {
        super(new MyWriter());
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

    private static class MyWriter implements JerialNodeMapWriter<StringBuilder> {
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