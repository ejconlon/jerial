package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.*;

import java.util.Map;
public class JsonObjectReader implements JerialVisitor<JerialContext> {

    public ObjectVisitor<JerialContext> makeObjectVisitor() {
        return new MyObjectVisitor();
    }

    public ArrayVisitor<JerialContext> makeArrayVisitor() {
        return new MyArrayVisitor();
    }

    private static class MyTreeVisitorJerializer implements Jerializer {

        // Ugh
        public void jerialize(Object object, JerialContext jerialContext) {
            throw new UnsupportedOperationException();
        }

        public void jerialize(TreeObjectVisitor<JerialContext> object, JerialContext context) {
            for (Map.Entry<String, JerialNode<JerialContext>> entry : object.getItems().entrySet()) {
                final String key = entry.getKey();
                final JerialNode<JerialContext> value = entry.getValue();
                if (value.hasLeft()) {
                    Logger.log("Reading simple jitem: "+value.getLeft());
                    context.builder.addJitem(value.getLeft());
                } else if (value.hasMiddle()) {
                    Logger.log("Reading object: "+key);
                    JerialContext newContext = context.push(key);
                    jerialize(value.getMiddle(), newContext);
                } else {
                    Logger.log("Reading array");
                    JerialContext newContext = context.push(key);
                    jerialize(value.getRight(), newContext);
                }
            }
        }

        public void jerialize(TreeArrayVisitor<JerialContext> object, JerialContext context) {
            for (Either3<Jitem, TreeObjectVisitor<JerialContext>, TreeArrayVisitor<JerialContext>> value : object.getItems()) {
                if (value.hasLeft()) {
                    Logger.log("Reading simple jitem: "+value.getLeft());
                    context.builder.addJitem(value.getLeft());
                } else if (value.hasMiddle()) {
                    Logger.log("Reading object");
                    JerialContext newContext = context.push(null);
                    jerialize(value.getMiddle(), newContext);
                } else {
                    Logger.log("Reading array");
                    JerialContext newContext = context.push(null);
                    jerialize(value.getRight(), newContext);
                }
            }
        }
    }

    private static class MyObjectVisitor extends TreeObjectVisitor<JerialContext> {
        @Override
        public ObjectVisitor<JerialContext> seeObjectFieldStart(String key) {
            MyObjectVisitor v = new MyObjectVisitor();
            addObjectVisitor(key, v);
            return v;
        }

        @Override
        public ArrayVisitor<JerialContext> seeArrayFieldStart(String key) {
            MyArrayVisitor v = new MyArrayVisitor();
            addArrayVisitor(key, v);
            return v;
        }

        @Override
        public void writeTo(JerialContext out) {
            (new MyTreeVisitorJerializer()).jerialize(this, out);
        }
    }

    private static class MyArrayVisitor extends TreeArrayVisitor<JerialContext> {

        @Override
        public ObjectVisitor<JerialContext> seeObjectItemStart() {
            MyObjectVisitor v = new MyObjectVisitor();
            addObjectVisitor(v);
            return v;
        }

        @Override
        public ArrayVisitor<JerialContext> seeArrayItemStart() {
            MyArrayVisitor v = new MyArrayVisitor();
            addArrayVisitor(v);
            return v;
        }

        @Override
        public void writeTo(JerialContext out) {
            (new MyTreeVisitorJerializer()).jerialize(this, out);
        }
    }
}
