package net.exathunk.jereal.example;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

public class Post {
    public final Ref<String> title = new RefImpl<String>();
    public final Ref<String> body = new RefImpl<String>();

    public Post(String title, String body) {
        this.title.setRef(title);
        this.body.setRef(body);
    }
}
