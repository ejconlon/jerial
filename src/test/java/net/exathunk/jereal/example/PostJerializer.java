package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

public class PostJerializer implements Jerializer<Post> {
    @Override
    public void jerialize(JerializerRegistry registry, Post object, JerialContext context) {
        context.builder.addJitem(Jitem.makeString(PathPart.key("title"), object.title));
        context.builder.addJitem(Jitem.makeString(PathPart.key("body"), object.body));
    }
}
