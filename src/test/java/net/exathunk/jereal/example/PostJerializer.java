package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.visitors.PathPart;

public class PostJerializer implements Jerializer<Post> {
    @Override
    public void jerialize(JerializerRegistry registry, Post object, JerialContext context) {
        context.builder.addThing(PathPart.key("title"), JThing.make(object.title));
        context.builder.addThing(PathPart.key("body"), JThing.make(object.body));
    }
}
