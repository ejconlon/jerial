package net.exathunk.jereal.base;

import java.util.Map;
public class JsonObjectReader implements JerialVisitor<JerialContext> {

    public ObjectVisitor getObjectVisitor() {
        return new MyObjectVisitor();
    }

    private static class MyObjectVisitorJerializer implements Jerializer<TreeVisitor<JerialContext>> {
        @Override
        public void jerialize(TreeVisitor<JerialContext> object, JerialContext context) {
            for (Map.Entry<String, Either<Jitem, TreeVisitor<JerialContext>>> entry : object.getPairs().entrySet()) {
                final String key = entry.getKey();
                final Either<Jitem, TreeVisitor<JerialContext>> value = entry.getValue();
                if (value.hasLeft()) {
                    Logger.log("Reading simple jitem: "+value.getLeft());
                    context.builder.addJitem(value.getLeft());
                } else {

                    Logger.log("Reading object: "+key);
                    JerialContext newContext = context.push(key);
                    jerialize(value.getRight(), newContext);
                }
            }
        }
    }

    private static class MyObjectVisitor extends TreeVisitor<JerialContext> {
        @Override
        public ObjectVisitor seeObjectFieldStart(String key) {
            MyObjectVisitor v = new MyObjectVisitor();
            addObjectVisitor(key, v);
            return v;
        }

        @Override
        public void writeTo(JerialContext out) {
            (new MyObjectVisitorJerializer()).jerialize(this, out);
        }
    }
}
