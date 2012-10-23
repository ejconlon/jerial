package net.exathunk.jereal.example;

import net.exathunk.jereal.base.JerialBuilder;
import net.exathunk.jereal.base.Jerializer;
import net.exathunk.jereal.base.Jitem;

public class PostJerializer implements Jerializer<Post> {
    @Override
    public void jerialize(Post object, JerialBuilder builder) {
        builder.addJitem(Jitem.makeString("title", object.title));
        builder.addJitem(Jitem.makeString("body", object.body));
    }
}
