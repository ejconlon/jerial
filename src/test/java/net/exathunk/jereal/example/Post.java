package net.exathunk.jereal.example;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

public class Post {
    public final Ref<String> title = new RefImpl<String>();
    public final Ref<String> body = new RefImpl<String>();

    public Post() {}

    public Post(String title, String body) {
        this.title.setRef(title);
        this.body.setRef(body);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (body != null ? !body.equals(post.body) : post.body != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }
}
