package net.exathunk.jereal.example;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Writable;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.Recurser;

public class PostJerializer<T extends PushableContext<T, U>, U> implements Jerializer<T, U, Post> {
    @Override
    public Post prototype() {
        return new Post();
    }

    @Override
    public Writable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Post object) {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeString("title", object.title);
        objectDSL.seeString("body", object.body);
        return objectDSL;
    }
}
