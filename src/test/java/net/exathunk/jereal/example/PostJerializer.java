package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.jerializers.JDSL;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.core.PathPart;

public class PostJerializer implements Jerializer<Post> {
    @Override
    public void jerialize(JDSL jdsl, Post object) {
        jdsl.addString("title", object.title);
        jdsl.addString("body", object.body);
    }
}
