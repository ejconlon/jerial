package net.exathunk.jereal.example;

import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.Recurser;

public class PostJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, Post> {
    @Override
    public void jerialize(Recurser<T, U> recurser, ObjectDSL<T, U> dsl, Post object) {
        dsl.seeString("title", object.title);
        dsl.seeString("body", object.body);
    }
}
