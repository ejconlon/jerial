package net.exathunk.jereal.example;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.jerializers.JDSL;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerRegistry;
import net.exathunk.jereal.base.core.PathPart;

public class PostJerializer<C> implements Jerializer<Post, C> {
    @Override
    public void jerialize(JDSL<C> jdsl, JerializerRegistry<C> registry, Post object, C context) {
        jdsl.addString("title", object.title, context);
        jdsl.addString("body", object.body, context);
    }
}
