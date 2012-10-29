package net.exathunk.jereal.base;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Func2;
import net.exathunk.jereal.base.visitors.*;

import java.util.Map;

public class JsonObjectWriter extends TreeVisitorFactoryImpl<StringBuilder> {

    public JsonObjectWriter() {
        super(new MyWriter());
    }

    private static void writeJThing(JThing thing, StringBuilder out) {
        boolean needComma = false;
        switch (thing.getModel()) {
            case STRING:
                String sv = thing.rawGetString().runResFunc();
                if (sv != null) out.append('"');
                out.append(sv);
                if (sv != null) out.append('"');
                break;
            case LONG:
                out.append(thing.rawGetLong().runResFunc());
                break;
            case DOUBLE:
                out.append(thing.rawGetDouble().runResFunc());
                break;
            case BOOLEAN:
                Boolean bv = thing.rawGetBoolean().runResFunc();
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
                for (Map.Entry<String, JThing> child : thing.rawGetObject().seq()) {
                    if (needComma) out.append(',');
                    writeJThing(child.getValue(), out);
                    needComma = true;
                }
                out.append('}');
                break;
            case ARRAY:
                out.append('[');
                for (Map.Entry<Integer, JThing> child : thing.rawGetArray().seq()) {
                    if (needComma) out.append(',');
                    writeJThing(child.getValue(), out);
                    needComma = true;
                }
                out.append(']');
                break;
        }
    }

    private static class MyWriter implements Func2<TreeNodeMap<StringBuilder>, StringBuilder> {
        @Override
        public void runFunc(TreeNodeMap<StringBuilder> source, StringBuilder sink) {
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
                    writeJThing(value.getLeft(), out);
                } else if (value.hasMiddle()) {
                    value.getMiddle().runFunc(out);
                } else {
                    value.getRight().runFunc(out);
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
                    writeJThing(value.getLeft(), out);
                } else if (value.hasMiddle()) {
                    value.getMiddle().runFunc(out);
                } else {
                    value.getRight().runFunc(out);
                }
                needComma = true;
            }
            out.append(']');
        }
    }
}