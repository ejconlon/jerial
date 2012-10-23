package net.exathunk.jereal.example;

import net.exathunk.jereal.base.*;

public class TestPost {
    public static void main(String[] args) throws JerializerException {
        Post p = new Post("foo", "bar");
        JerialBuilder builder = new MapBuilder();
        Jerializer<Post> jerializer = new PostJerializer();
        jerializer.jerialize(p, builder);
        Jerial jerial = builder.buildJerial();
        JerialWriter writer = new JsonObjectWriter();
        (new JerialRunner()).runJerialVisitor(jerial, writer);
        StringBuilder sb = new StringBuilder();
        writer.writeJerial(sb);
        String s = sb.toString();
        System.out.println("WROTE: "+s);

        JerialReader reader = new JsonObjectReader(new SimpleMapBuilderFactory());
        (new JsonParser()).runJerialVisitor(s, reader);
        for (Jitem entry : reader.readJerial()) {
            System.out.println("READ: "+entry.key+" => "+entry.value.toString()+" => "+entry.model);
        }
    }
}
