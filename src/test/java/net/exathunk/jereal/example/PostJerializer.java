package net.exathunk.jereal.example;

import net.exathunk.jereal.base.JerialContext;
import net.exathunk.jereal.base.Jerializer;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

public class PostJerializer implements Jerializer<Post> {
    @Override
    public void jerialize(Post object, JerialContext context) {
        context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("title"), object.title));
        context.builder.addJitem(Jitem.makeString(PathPart.makeLeft("body"), object.body));
    }
}
