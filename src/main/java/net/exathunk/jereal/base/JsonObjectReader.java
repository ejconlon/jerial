package net.exathunk.jereal.base;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Func2;
import net.exathunk.jereal.base.visitors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class JsonObjectReader extends TreeVisitorFactoryImpl<JerialContext> {

    public JsonObjectReader() {
        super(new MyWriter());
    }

    private static class MyWriter implements Func2<TreeNodeMap<JerialContext>, JerialContext> {
        @Override
        public void runFunc(TreeNodeMap<JerialContext> source, JerialContext sink) {
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
                    context.builder.addThing(part, value.getLeft());
                } else if (value.hasMiddle()) {
                    Logger.log("Reading object: "+part);
                    JerialContext newContext = context.push(part);
                    writeObjectVisitor(value.getMiddle().getTreeNodeMap(), newContext);
                    context.builder.addThing(part, JThing.make(newContext.builder.buildObject()));
                } else {
                    Logger.log("Reading array");
                    JerialContext newContext = context.push(part);
                    writeArrayVisitor(value.getRight().getTreeNodeMap(), newContext);
                    List<JThing> list = new ArrayList<JThing>();
                    for (Map.Entry<Integer, JThing> item : newContext.builder.buildArray().seq()) { list.add(item.getValue()); }
                    context.builder.addThing(part, JThing.make(list));
                }
            }
        }

        public void writeArrayVisitor(TreeNodeMap<JerialContext> nodeMap, JerialContext context) {
            int index = 0;
            for (Map.Entry<PathPart, TreeNode<JerialContext>> entry : nodeMap) {
                final PathPart part = PathPart.index(index);
                final TreeNode<JerialContext> value = entry.getValue();
                if (value.hasLeft()) {
                    Logger.log("Reading simple jitem: "+value.getLeft());
                    context.builder.addThing(part, value.getLeft());
                } else if (value.hasMiddle()) {
                    Logger.log("Reading object");
                    JerialContext newContext = context.push(PathPart.index(index));
                    writeObjectVisitor(value.getMiddle().getTreeNodeMap(), newContext);
                    context.builder.addThing(part, JThing.make(newContext.builder.buildObject()));
                } else {
                    Logger.log("Reading array");
                    JerialContext newContext = context.push(PathPart.index(index));
                    writeArrayVisitor(value.getRight().getTreeNodeMap(), newContext);
                    List<JThing> list = new ArrayList<JThing>();
                    for (Map.Entry<Integer, JThing> item : newContext.builder.buildArray().seq()) { list.add(item.getValue()); }
                    context.builder.addThing(part, JThing.make(list));
                }
                index += 1;
            }
        }
    }
}
