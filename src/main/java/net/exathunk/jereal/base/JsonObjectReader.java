package net.exathunk.jereal.base;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.visitors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class JsonObjectReader extends TreeVisitorFactoryImpl<JerialContext> {

    public JsonObjectReader() {
        super(new MyWriter());
    }

    private static class MyWriter implements TreeNodeMapWriter<JerialContext> {
        @Override
        public void writeTo(TreeNodeMap<JerialContext> source, JerialContext sink) {
            if (source.isObject()) {
                writeObjectVisitor(source, sink);
            } else {
                writeArrayVisitor(source, sink);
            }
        }

        public void writeObjectVisitor(TreeNodeMap<JerialContext> nodeMap, JerialContext context) {
            for (Map.Entry<PathPart, TreeNode<JerialContext>> entry : nodeMap) {
                final PathPart part = entry.getKey();
                final TreeNode<JerialContext> value = entry.getValue();
                if (value.hasLeft()) {
                    Logger.log("Reading simple jitem: "+value.getLeft());
                    context.builder.addJitem(value.getLeft());
                } else if (value.hasMiddle()) {
                    Logger.log("Reading object: "+part);
                    JerialContext newContext = context.push(part);
                    writeObjectVisitor(value.getMiddle().getTreeNodeMap(), newContext);
                    context.builder.addJitem(Jitem.makeObject(part, newContext.builder.buildObject()));
                } else {
                    Logger.log("Reading array");
                    JerialContext newContext = context.push(part);
                    writeArrayVisitor(value.getRight().getTreeNodeMap(), newContext);
                    List<Jitem> list = new ArrayList<Jitem>();
                    for (Jitem item : newContext.builder.buildObject()) { list.add(item); }
                    context.builder.addJitem(Jitem.makeArray(part, list));
                }
            }
        }

        public void writeArrayVisitor(TreeNodeMap<JerialContext> nodeMap, JerialContext context) {
            int index = 0;
            for (Map.Entry<PathPart, TreeNode<JerialContext>> entry : nodeMap) {
                final TreeNode<JerialContext> value = entry.getValue();
                if (value.hasLeft()) {
                    Logger.log("Reading simple jitem: "+value.getLeft());
                    context.builder.addJitem(value.getLeft());
                } else if (value.hasMiddle()) {
                    Logger.log("Reading object");
                    JerialContext newContext = context.push(PathPart.index(index));
                    writeObjectVisitor(value.getMiddle().getTreeNodeMap(), newContext);
                    context.builder.addJitem(Jitem.makeObject(PathPart.index(index), newContext.builder.buildObject()));
                } else {
                    Logger.log("Reading array");
                    JerialContext newContext = context.push(PathPart.index(index));
                    writeArrayVisitor(value.getRight().getTreeNodeMap(), newContext);
                    List<Jitem> list = new ArrayList<Jitem>();
                    for (Jitem item : newContext.builder.buildObject()) { list.add(item); }
                    context.builder.addJitem(Jitem.makeArray(PathPart.index(index), list));
                }
                index += 1;
            }
        }
    }
}
