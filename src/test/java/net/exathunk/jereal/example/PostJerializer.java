package net.exathunk.jereal.example;

import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.Recurser;

public class PostJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, Post> {
    @Override
    public Post prototype(Speclike spec) {
        return new Post();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, Post object) {
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        objectDSL.seeString("title", object.title);
        objectDSL.seeString("body", object.body);
        return objectDSL;
    }
}
