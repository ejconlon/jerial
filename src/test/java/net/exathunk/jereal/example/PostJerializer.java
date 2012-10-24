package net.exathunk.jereal.example;

import net.exathunk.jereal.base.JerialContext;
import net.exathunk.jereal.base.Jerializer;
import net.exathunk.jereal.base.visitors.Jitem;

public class PostJerializer implements Jerializer<Post> {
    @Override
    public void jerialize(Post object, JerialContext context) {
        context.builder.addJitem(Jitem.makeString("title", object.title));
        context.builder.addJitem(Jitem.makeString("body", object.body));
    }
}
